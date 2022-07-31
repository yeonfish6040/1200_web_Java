module.exports = {
    name: "jsonFile",
    description: "jsonFile using test",

    run: function() {
        const fs = require("fs")
        let user = new Object()
        let userJSON;

        user.name = "Erik"
        user.id = "Skylove8"
        user.pw = "1111"
        
        userJSON = JSON.stringify(user)

        // 기본적으로 비동기
        fs.writeFile('./json/user.json', userJSON, 'UTF-8', (e) => {
            if(e) throw e;
            else console.log();
        })
    }
}