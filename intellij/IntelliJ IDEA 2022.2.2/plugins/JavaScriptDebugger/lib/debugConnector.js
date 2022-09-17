try {
  if (process.env.PORT_PUBLISHER) {
    publishDebugPort()
    return;
  }

  if (hasInspectArg()) {
    return;
  }

  if (isElectronRendererProcess()) {
    return;
  }

  if (isNpmPrefixOnWindows()) {
    // Workaround for WEB-55884: 'npm prefix -g' is the first process spawned by npm.cmd.
    // After terminating debugged processes we terminate the whole process (see org.jetbrains.debugger.connection.VmConnection#close).
    // Let's skip attaching to such processes.
    return;
  }
  try {
    if (!require('worker_threads').isMainThread) {
      // will be attached using WIP NodeWorker domain
      return;
    }
  }
  catch (ignored) {
  }
  let asyncInspectorOpenSupported = isAsyncInspectorOpenSupported();

  let inspector = require("inspector");
  const debugConnectionForwarder = require('./debugConnectionForwarder');
  const {execFile, execFileSync} = require('child_process');
  let port = findAvailablePort(inspector);
  if (debugConnectionForwarder.shouldForwardDebugConnection()) {
    debugConnectionForwarder.forwardDebugConnectionAndWait(port);
    return;
  }

  let launchPortPublisher = asyncInspectorOpenSupported ? execFileSync : execFile;
  const interpreter = process.env["JB_INTERPRETER"] || process.execPath;
  let publisherEnv = Object.assign({}, process.env, {
    PORT_PUBLISHER: true,
    JB_IDE_PORT: process.env["JB_IDE_PORT"],
    JB_IDE_HOST: process.env["JB_IDE_HOST"],
    JB_DEBUG_PORT: port,
    NODE_OPTIONS: ''
  });
  launchPortPublisher(interpreter, [__filename], {
    env: publisherEnv,
    stdio: 'inherit'
  });
  if (!asyncInspectorOpenSupported) {
    inspector.open(port, getBindHost(), true);
  }

}
catch (e) {
  console.error("Error in JetBrains node debug connector: ", e)
}

function publishDebugPort() {
  let idePort = process.env["JB_IDE_PORT"];
  let ideHost = process.env["JB_IDE_HOST"] || '127.0.0.1';
  let debugPort = process.env["JB_DEBUG_PORT"];

  const net = require('net');
  const TIMEOUT = 15000;
  const socket = net.createConnection({host: ideHost, port: idePort}, () => {
    socket.on('data', (d) => {
      clearTimeout(timeoutId);
      socket.destroy();
    });

    socket.write(debugPort, "utf8");
    const timeoutId = setTimeout(() => {
      process.stderr.write("Debugger didn't connect during timeout\n")
      return socket.destroy();
    }, TIMEOUT);
  });
  socket.setNoDelay(true);
  socket.on('error', err => {
    console.error("Error in debuggerConnector: " + err.message + "\n" + err.stack);
    if (process.env.JB_WSL_MSG) {
      console.error("\n" + process.env.JB_WSL_MSG +"\n")
    }
    process.exit(0);
  });
}

function hasInspectArg() {
  return process.execArgv.find(
      arg => arg === "--inspect" || arg === "--inspect-brk" || arg.startsWith("--inspect-brk=") || arg.startsWith("--inspect=")
  );
}

function isElectronRendererProcess() {
  return process.type && process.type === "renderer" ||
         process.argv.indexOf("--type=renderer") >= 0;
}

function isNpmPrefixOnWindows() {
  return process.platform === 'win32' &&
    process.argv.length === 4 &&
    process.argv[1].endsWith('\\node_modules\\npm\\bin\\npm-cli.js') &&
    process.argv[2] === 'prefix' &&
    process.argv[3] === '-g';
}

/**
 * inspector.open(...,...,false) doesn't work properly on some node versions. It opens the port but debugger can't attach.
 */
function isAsyncInspectorOpenSupported() {
  try {
    let versions = process.versions.node.split(".");
    let major = parseInt(versions[0]);
    let minor = parseInt(versions[1]);
    let asyncInspectorOpenSupported = major >= 11 || (major === 10 && minor >= 7);
    return asyncInspectorOpenSupported;
  }
  catch (e) {
    process.stderr.write("Cannot parse node version: " + process.versions.node + "\n" + e.message);
    return false;
  }
}

function findAvailablePort(inspector) {
  try {
    let closeAuxiliaryInspector = !isAsyncInspectorOpenSupported();
    if (closeAuxiliaryInspector) {
      process.stderr.write("[IntelliJ is searching for port] ")
    }

    inspector.open(0, getBindHost(), false);
    let url = inspector.url();
    let schemeSeparatorIndex = url.indexOf("://");
    let slashIndex = url.indexOf("/", schemeSeparatorIndex + 3);
    let colonIndex = url.substr(0, slashIndex).lastIndexOf(":");
    let portString = url.substr(colonIndex + 1, slashIndex - colonIndex - 1);
    let port = Number(portString);
    if (!port) throw Error("failed to parse " + url);

    if (closeAuxiliaryInspector) {
      inspector.close()
    }

    return port;
  }
  catch(e) {
    inspector.close();
    throw e;
  }
}

/**
 * @return host to listen on for inspector connections. If undefined, localhost will be used.
 */
function getBindHost() {
  return process.env.JETBRAINS_NODE_BIND_HOST;
}
