const input = document.querySelector("input[name='pw']")
const div = document.getElementById("toggle")
const img = document.getElementById("img")
const onBtn = document.getElementById("on")
const offBtn = document.getElementById("off")
const result = document.getElementById("result")
const wrap = document.querySelector("div.wrap")
PNM_count = 0

input.addEventListener('keyup', function(evt) {
    if (evt.keyCode == 13) { // enter
        SuperCar.engineStart();
    }
})

onBtn.addEventListener("click", function() {
    SuperCar.engineStart();
})
offBtn.addEventListener("click", function() {
    SuperCar.engineStop();
})
div.addEventListener("click", function(element) {
    type = input.getAttribute('type')
    if (type == "password") {
        input.setAttribute("type", "text")
        div.style.backgroundImage = "url('./img/eye.jpg')"
    }else{
        input.setAttribute("type", "password")
        div.style.backgroundImage = "url('./img/noeye.jpg')"
    }
})

function err(cmd) {
    switch (cmd) {
        case "E_A_R":
            out("이미 동작중!")
            break

        case "E_N_R":
            out("엔진이 동작중이지 않습니다")
            break
        
        case "E_P_N_M":
            PNM_count++
            if (PNM_count != 3) {
                out(`비밀번호 오류! (연속 ${PNM_count})`)
            } else {
                out(`비밀번호 오류! (연속 ${PNM_count})`)
                wrap.style.visibility = "hidden"
                setTimeout(() => {
                    img.style.background = "url('./img/경찰.png')"
                    onBtn.style.display = "none"
                    offBtn.style.display = "none"
                    out("경찰출동")
                }, 2000);
            }
    }
}

function out(txt) {
    result.innerHTML = txt
    setTimeout(() => {
        result.innerHTML = ""
    }, 2000)
}

function SuperCar() {
    this.pw = "0000"

}

SuperCar.prototype.pw = prompt("비밀번호 등록")

var isStart = false
SuperCar.engineStart = () => {
    console.log("Engine Start");
    if (isStart == true) return err("E_A_R");
    if (SuperCar.prototype.pw != input.value) return err("E_P_N_M");
    wrap.style.visibility = "hidden"
    input.value == ""
    img.style.background = "url('./img/시동켜기.gif')"
    isStart = true
    out("동작중")
}

SuperCar.engineStop = () => {
    if (!isStart) return err("E_N_R")
    img.style.backgroundImage = "url('./img/시동끄기.gif')"
    isStart = false
    out("시동이 꺼집니다")
    wrap.style.visibility = "visible"
}