module.exports = {
    name: `arrayTests`,
    description: `array test for practice`,

    run: function() {
        var data = []
        data[0] = 20
        console.log(data);
        data[3] = 20
        console.log(data);

        var data2 = [20, 5, 6, 12, 10]
        data2.push(19)
        console.log(data2)

        console.log(data2.join("|"));
        
        console.log(data2.slice(1, 3));
        console.log(data2.slice(1));
        data2.forEach((e, i, ar) => {
            ar[i] = e**2
        })
        console.log(data2);
        let data4 = new Array(7)
        data4.push('월')
        console.log(data4)

        data4 = new Array(7)
        let index = 0
        data4[index++] = "월"
        data4[index++] = "화"
        data4[index++] = "수"
        data4[index++] = "목"
        data4[index++] = "금"
        data4[index++] = "토"
        data4[index++] = "일"
        console.log(data4);
        console.log(data4.toString());

        let week = new Array("월","화","수")
        week.forEach((v) => {
            console.log(`${v}요일`);
        })
    }
}
