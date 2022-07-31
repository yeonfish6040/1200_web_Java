module.exports = {
    name: `object2`,
    description: `second object practice`,

    run: function() {
        var account = new Object()
        account.owner = `이선생`
        account.balance = 90
        account.deposit = deposit
        account.withdraw = withdraw

        function deposit(money) {
            this.balance += money
        }
        function withdraw(money) {
            this.balance -= money
            return money
        }
    }
}