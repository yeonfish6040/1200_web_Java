module.exports = {
    name: `jsonArTest`,
    description: `json array practice`,

    run: function(callback) {
        const fs = require('fs')

        function product(name, price, count) {
            this.name = name
            this.price = price
            this.count = count

            this.json = JSON.stringify(this)

        }

        var products = new Array();
        products.push(new product('mouse', 18900, 5).json)
        products.push(new product('keyboard', 38500, 9).json)
        products.push(new product('monitor', 187000, 3).json)
        console.log(products);

        path = `./functions/json/`
        // fs.writeFile(`${path}shop.json`, `[${products.toString()}]`, `utf-8`, (e) => {
        //     if (e) throw e
        //     else console.log(`fileWrite() success`);
        // })

        fs.readFile(`${path}shop.json`, 'utf-8', (e, data) => {
            if (e) throw e;
            else console.log(`readFile() success`);
            getTotal(data)
        })

        var sumObj = new Object()

        function getTotal(data) {
            products = JSON.parse(data)
            var totalPrice = 0
            var totalStock = 0

            // totalPrice = price*count
            console.log(products.map(e => e.name))
            products.map(e => e.price * e.count).forEach(e => totalPrice += e)
            products.map(e => e.count).forEach(e => totalStock += e)

            // console.log(totalPrice);
            // console.log(totalStock);

            sumObj.totalPrice = totalPrice
            sumObj.totalStock = totalStock

            fs.writeFile(`${path}sum.json`, JSON.stringify(sumObj), e => {
                if (e) throw e;
                else console.log(`writeFile success`);
            })

            // totalStock = (e => this.count += e.count)
        }

        callback(false)
    }
}
