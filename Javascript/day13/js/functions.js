const print_o2t = () => {
    console.log('print_o2t()');
    
    var total = 0
    for(i=0;i<10;i++){
        console.log(i+1);
    }
}
print_o2t()

const print_total = () => {
    console.log('print_total()');
    
    var total = 0
    for(i=0;i<10;i++){
        total += (i+1)
    }
    console.log(total);
    
}
print_total()

const print_o2n = (n) => {
    console.log('print_o2n()');
    
    var total = 0
    for(i=0;i<n;i++){
        total += (i+1)
    }
    console.log(total);
    
}
print_o2n(100)