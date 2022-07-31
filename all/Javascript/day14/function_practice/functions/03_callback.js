module.exports = {
    name: `callback`,
    description: `callback test`,

    run: function() {
        function mul(num1, num2, callback){
            if (callback) {
                callback(num1 * num2)
            }
        }

        function print(value) {
            console.log(`야 쟤가 이거 주더라: ${value}`);
        }
        mul(3, 9, print)
        console.log(`\n`);
        // 상품명, 가격, 개수를 전달받은 후 전체 금액을 출력한다.
        // 1. 상품명과 가격은 A함수에서 전달받는다.
        // 2. B함수에서는 상품명과 전체 금액글 전달받아서 출력한다.
        // 3. A함수는 B함수를 callback함수로 전달받는다
        function pay(name, price, count, callback) {
            let total = price * count
            callback(name, total)
        }

        function printAll(name, total) {
            console.log(`${name}: ${total}$`);
        }

        pay("Potato", 1500, 5, printAll)
    }
}