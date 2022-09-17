// Prints dependencies information
// https://next.yarnpkg.com/advanced/pnpapi#traversing-the-dependency-tree

if (!process.versions.pnp) {
  console.error('Error: process.versions.pnp not found: ' + JSON.stringify(process.versions, null, 2));
}

const pnp = (() => {
  const module = require('module');
  if (typeof module.findPnpApi === 'function') {
    return module.findPnpApi(process.cwd());
  }
  return require('pnpapi');
})();

function findOrCreate(packageLocator, tree) {
  const key = JSON.stringify(packageLocator);
  const node = tree[key];
  if (node) {
    return node;
  }
}

const buildTree = (workspaceLocators) => {
  const tree = {};
  let nextDependencyId = 1;

  function traverse(packageLocator) {
    const packageLocatorJson = JSON.stringify(packageLocator);
    if (tree.hasOwnProperty(packageLocatorJson)) {
      return tree[packageLocatorJson];
    }
    const pkg = pnp.getPackageInformation(packageLocator);
    if (pkg == null) {
      console.error(pkg, 'Unavailable package information for ' + JSON.stringify(packageLocator));
      return null;
    }
    const dependency = createDependency(nextDependencyId++, packageLocator.name, pkg.packageLocation);
    tree[packageLocatorJson] = dependency;
    for (const [name, reference] of pkg.packageDependencies.entries()) {
      if (reference !== null) {
        const childDependency = traverse({name, reference});
        if (childDependency !== null && childDependency.id !== dependency.id) {
          dependency.dependencies.push(childDependency.id);
        }
      }
    }
    return dependency;
  }

  for (const workspaceLocator of workspaceLocators) {
    traverse(workspaceLocator);
  }

  return tree;
};

function createDependency(id, dependencyName, dependencyRequireableLocation) {
  const node = {
    id: id,
    name: dependencyName,
    requireableLocation: dependencyRequireableLocation,
    dependencies: []
  };
  if (typeof pnp.resolveVirtual === 'function') {
    const resolvedVirtual = pnp.resolveVirtual(dependencyRequireableLocation);
    if (resolvedVirtual && resolvedVirtual !== dependencyRequireableLocation) {
      node.resolvedVirtualRequireableLocation = resolvedVirtual;
    }
  }
  return node;
}

function addDependencyInfo(dependencies, dependencyName, dependencyRequireableLocation) {
  const info = {
    name: dependencyName,
    requireableLocation: dependencyRequireableLocation
  };
  if (typeof pnp.resolveVirtual === 'function') {
    const resolvedVirtual = pnp.resolveVirtual(dependencyRequireableLocation);
    if (resolvedVirtual && resolvedVirtual !== dependencyRequireableLocation) {
      info.resolvedVirtualRequireableLocation = resolvedVirtual;
    }
  }
  dependencies.push(info);
}

function fetchDependencyTree() {
  const dependencyTree = {};
  if (typeof pnp.getDependencyTreeRoots === 'function') {
    const tree = buildTree(pnp.getDependencyTreeRoots());
    dependencyTree.nodes = Object.values(tree);
    const workspaces = [];
    for (const workspaceLocator of pnp.getDependencyTreeRoots()) {
      const workspaceLocatorJson = JSON.stringify(workspaceLocator);
      const workspaceInfo = tree[workspaceLocatorJson];
      if (!workspaceInfo) {
        throw Error('Cannot find ' + workspaceLocatorJson);
      }
      workspaces.push({
                        location: workspaceInfo.requireableLocation,
                        id: workspaceInfo.id
                      });
    }
    dependencyTree.workspaces = workspaces;
  }
  else {
    const workspace = {};
    traverseDependencyTree_v1(workspace);
    dependencyTree.workspaces = [workspace];
  }
  return dependencyTree;
}

function traverseDependencyTree_v1(workspace) {
  const messagePrefix = '[Yarn PnP legacy API] ';
  workspace.location = process.cwd();
  workspace.dependencies = [];

  function addDeps(dependencies) {
    const issuer = process.cwd() + '/';
    for (const dependencyName of Object.keys(dependencies)) {
      try {
        addDependencyInfo(workspace.dependencies, dependencyName, pnp.resolveToUnqualified(dependencyName, issuer));
      }
      catch (e) {
        console.error(messagePrefix + 'Failed resolveToUnqualified(' + dependencyName + ', ' + issuer + ')', e);
      }
    }
  }

  let packageJson;
  try {
    const packageJsonPath = require('path').join(process.cwd(), 'package.json');
    packageJson = require(packageJsonPath);
  }
  catch (e) {
    console.error(messagePrefix + ' Cannot find ./package.json');
    throw e;
  }
  addDeps(packageJson.dependencies || {});
  addDeps(packageJson.devDependencies || {});
}

const dependencyTree = fetchDependencyTree();
const result = {
  environment: {
    'process.versions': {
      node: process.versions.node,
      pnp: process.versions.pnp
    },
    'pnp.VERSIONS': pnp.VERSIONS,
    'pnp.resolveVirtual': typeof pnp.resolveVirtual === 'function'
  },
  dependencyTree: dependencyTree
};

process.stdout.write(
    "##intellij-yarn-pnp-deps-tree-start\n" +
    JSON.stringify(result) +
    "\n##intellij-yarn-pnp-deps-tree-end\n"
);
