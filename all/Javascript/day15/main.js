const fs = require(`fs`)

main(4)

function main(step) {
    funcDir = `./functions`
    func = {}
    fs.readdir(funcDir, (err, files) => {
        if (err) throw err
        files.forEach(file => {
            if(!file.endsWith(".js")) return
            funcTemp = require(`${funcDir}/${file}`)
            func[funcTemp.name] = funcTemp
            console.log(`[${file}] - function ${func[funcTemp.name].name} is ready`)
        })
        try {
            console.log(`\nrun =====================`);
            func[Object.keys(func)[step-1]].run((val) => {
                if (val) console.log(val);
                else console.log(`clean exit. run success`);
            })
        }catch(e) {
            console.log(`unhandled exception: \n${e}`)
        }
    })    
}