
function add(a, b){
    console.log("a+b");
    return a + b;
}
function add(a){
    console.log("a+a");
    return a+a;
}


add(10);
add(10, 20);
add(10,20,30,40);
add(10, 20, 30, 40, 50, 60);

function add(a, b, c){
    console.log(arguments.length);
    console.log("6번째 값:::: " + arguments[5]);
    return a+ b+ c;
}

