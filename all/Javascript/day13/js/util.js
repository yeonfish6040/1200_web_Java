const getPermutations = (arr, num) => {
    const results = [];
    if (num === 1) return arr.map(v => [v]);

    arr.forEach((fixed, index, origin) => {
        
        const permutations = getPermutations(origin, num - 1);

        const attached = permutations.map(v => [fixed, ...v]);

        results.push(...attached);
    });

    return results;
}

const sleep = (ms) => {
    const wakeUpTime = Date.now() + ms;
    while (Date.now() < wakeUpTime) {}
}
