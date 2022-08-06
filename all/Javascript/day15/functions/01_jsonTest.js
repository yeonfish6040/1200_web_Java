module.exports = {
    name: `jsonTest`,
    description: `json practice again`,

    run: function(callback) {
        const fs = require('fs')

        var train = new Array()
        var hong = {name: '홍길동', age: 20, level: 1}
        var lee = {name: '이순신', age: 40, level: 2}
        var jang = {name: '장보고', age: 19, level: 3}

        train.push(hong)
        train.push(lee)
        train.push(jang)

        console.log(train);

        var trainJSON = JSON.stringify(train)
        console.log(trainJSON);
        
        var path = "./functions/json/"

        fs.writeFile(`${path}train.json`, trainJSON, "utf-8", (e) => {
            if (e) throw e
            else console.log(`writeFile() success`);
        })

        fs.readFile(`${path}train.json`, `utf-8`, (e, data) => {
            if (e) throw e
            else console.log(`readFile() success`);
            var trainAr = JSON.parse(data)
            console.log(trainAr);

            for(i in trainAr) {
                console.log(trainAr[i].name, trainAr[i].level);
            }
        })
        callback(false)
    }
}
