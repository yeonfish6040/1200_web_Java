const btns = document.querySelectorAll(".btn")

console.log(btns)
current = 0
highlight()
for (i in btns) {
    if (isNaN(i)) continue
    btns[i].addEventListener('click', function() {
        id = this.id-1
        current = 90*id
        move()
        
        resetInter()
    })
}

const arrows = document.querySelectorAll(".arrow")

console.log(arrows)
for (i in arrows) {
    if (isNaN(i)) continue
    
    arrows[i].addEventListener('click', function() {
        this.className.indexOf("next") != -1 ? next() : prev()
        
        resetInter()
    })
}

bannerLoop = setInterval(() => {
    next()
}, 5000)

function next() {
    current = (current == 450 ? 0 : current+90)
    move()
}

function prev() {
    current = (current == 0 ? 450 : current-90)
    move()
}

function resetInter() {
    clearInterval(bannerLoop)
    bannerLoop = setInterval(() => {
        next()
    }, 5000)
}

function move() {
    document.getElementsByClassName("banner")[0].animate([
        { transform: `translateX(-${current}vw)` }
    ], {
        duration: 1000,
        fill: "forwards"
    })
    highlight()
}

function highlight() {
    id = current / 90 + 1
    for (i in btns) {
        if (isNaN(i)) continue
        btns[i].style.color = ""
    }
    document.getElementById(id).style.color = "white"
}