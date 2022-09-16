module.exports = {
    name: `defualt`,
    description: `function method arg defualt value test`,
    run: function() {
        var data = false
        data = data || 10;
        console.log(data);
        
        if (!undefined) {
            console.log(`undefined is false`);
        }

        // ===: 값과 타입이 모두 같다면 true
        let data1
        console.log(data1 === undefined);

    }
}