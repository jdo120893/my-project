function add(a,b){
    return a + b;
}

let result = add(3,4);
console.log(result);

function add(a, b){
    return a + b + 100;
}

function add(a, b){
    return "hahahaha";
}

let plus = function(a, b){
    return a+ b;
};

plus(1, 2);

plus = function(a, b){
    return "hoho";
}

let test = plus;

console.log(typeof test);

function ppp(abc){
    return abc;
}

let func = ppp(plus);

func();

ppp(plus)();

function add(a ,b){
    return a+ b;
}

const add2 = (a, b) => a + b;