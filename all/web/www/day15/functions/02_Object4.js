module.exports = {
    name: `object`,
    description: `object practice`,

    run: function(callback) {
        // 프로토타입
        // new 뒤에 나오는 생성자를 자바스크립트에서는 프로토타입이라고 함
        function User(id, pw, name, age) {
            this.id = id
            this.pw =  pw
            this.name = name
            this.age = age || 1 // 나이를 입력하지 않았을 때 this.age를 1로 설정

            this.intro = () => {
                console.log(this.id);
                console.log(this.pw);
                console.log(this.name);
                console.log(this.age);
            }
        }

        han = new User('han8811', '1111', 'Hankook', 20)
        lee = new User('lee8878', '1234', 'leeppp')

        console.log(han);
        console.log(JSON.stringify(han));

        lee.intro()
        han.intro = intro1
        
        function intro1(){
            console.log(`뭘 자꾸 캐물어요`);
        }

        han.intro()
        
        callback(false)
    }
}