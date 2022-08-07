const button = document.getElementById("confirm")
var tr_temp = []


button.onclick = confirm

function confirm() {
    console.log("Confirm Button Pressed");
    const input = document.getElementById("input")
    const trs = document.querySelectorAll("tbody tr")
    check = false
    trs.forEach((tr) => {
        var td = tr.firstElementChild
        tr.style.color = ""
        if (input.value == td.innerHTML) {
            tr.style.color = "blue"
            check = true
        }
    })

    if (!check) {
        alert("try again")
    }
}