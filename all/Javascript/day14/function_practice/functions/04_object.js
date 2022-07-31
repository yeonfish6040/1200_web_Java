module.exports = {
    name: 'objects',
    description: `object pratice`,

    run: function() {
        var account = {
            owner: "이선셍",
            code: "2132",
            balance: 982632392,
            deposit: function(money) {this.balance += money},
            withdraw: function(money) {this.balance -= money},
            show_balance: function(){return this.balance}
        }
        with(console) {
            console.log(account);
            console.log(account.owner);
            account.deposit(50000)
            console.log(account.show_balance());
        }
    }
}