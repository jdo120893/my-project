console.log(true && "hello");
console.log(false && "hello");

let food = {foodName : "피자"};

function getFoodName(food) {
    return food.foodName;
}

console.log(getFoodName(food));

food = null;

console.log(getFoodName(food));

function getFoodName(food) {
    if (!food) return "아무거나";
    return food.foodName;
}

// 단축연산
function getFoodName(food) {
    return food && food.foodName;
}

console.log("======================");
console.log(true && "hello");
console.log(false && "hello");

console.log(true || "hello");
console.log(false || "hello");

console.log("=======자바 스크립트가 false로 판단하는 값들==========")
console.log(null && "hello");
console.log(undefined && "hello");
console.log("" && "hello");
console.log(0 && "hello");

console.log("========자바 스크립트가 true로 판단하는 값들========");
console.log("a" || "hello");
console.log(1 || "hello");

let a;
let b = null;
let c = undefined;
let d = 100;
let e = "aa";

let f = a || b || c || d || e;

console.log(f);

const name = null;

const username = name || "guest";

console.log(username);

console.log("========?? --- '', 0 을 값자체로 판단해줌. true로 판단해줌 ========");
console.log(null ?? "hello");
console.log(undefined ?? "hello");
console.log("" ?? "hello");
console.log(0 ?? "hello");

console.log("a" ?? "hello");
console.log(1 ?? "hello");