module.exports = {
    name: `json`,
    description: `json practice`,
    
    run: function() {
        user = {
            name: "Erik",
            age: 30
        }
        // userJSON = JSON.stringify(user)
        // console.log(userJSON);
        userJSON = `{"name": "Erik","age": 30}`
        console.log(userJSON);
        user = JSON.parse(userJSON)
        console.log(user.name)


        let productJSON = `{"name":"Mouse", "price":18000}`
        let product = JSON.parse(productJSON)
        console.log(product.name);
        console.log(product.price);

        productJSON = JSON.stringify(product)
        console.log(productJSON);
    }
}