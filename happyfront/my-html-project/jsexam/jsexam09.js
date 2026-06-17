function add(a , b){
    return a +b
}
console.log(add(3,5));

function isEven(num){
    return num % 2 === 0;
}

console.log(isEven(10));
console.log(isEven(7));

function getLength(str){
    return str.length
}

console.log(getLength("hello"))

function sumArray(arr){
    let sum = 0
    for(let i = 0; i<arr.length; i++){
        sum += arr[i]
    }
    return sum
}

console.log(sumArray([1, 2, 3, 4]))

function toFahrenheit(celsius){
    return celsius * 9 / 5 + 32
}

function checkTemperature(fahrenheit){
    if(fahrenheit >= 100){
        return "더움"
    }
    return "보통"
}

const f = toFahrenheit(30)
console.log(checkTemperature(f))

function getUserInfo(name, age){
    if(age >= 20){
        return name + "님은 성인입니다."
    }
    return name + "님은 미성년자입니다."
}

console.log(getUserInfo("홍길동", 25))
console.log(getUserInfo("김철수", 17))

const name = "홍길동";
const age = 25;
const isStudent = true;

console.log(`안녕하세요, 저는 ${name}이고 ${age}살입니다. ${isStudent ? "학생입니다.": "학생이 아닙니다."}`);

function add(a, b){
    return a +b
}
console.log(add(3,4))

function getCircleArea(d){
    return d * d * 3.14
}
console.log(getCircleArea(5))

function greet(name){
    return `안녕하세요, ${name}님!` 
}
console.log(greet("김철수"))

const student = {
    name: "abc",
    age: 26,
    grade: 2,
    subjects: ["국어", "수학", "과학"]
}

console.log(student.name)
console.log(student.age + 1)
student.subjects.push("영어");
console.log(student)

const fruits= ["체리", "사과", "토마토", "키위", "딸기"]
console.log(fruits[0], fruits[4])
fruits.push("오렌지")
console.log(fruits)
console.log(fruits.length)
console.log(fruits.includes("사과"))

const getGrade = (score) => {
        if(score >= 90) return "A" 
        if(score >= 80) return "B" 
        if(score >= 70) return "C" 
        if(score >= 60) return "D" 
        else return "F"
}
[95, 87, 73, 65, 45].forEach(score => console.log(`${score}점: ${getGrade(score)}`));

const getDay = (num) => {
    switch(num){
        case 1:
        return "월요일"
        case 2:
        return "화요일"
        case 3:
        return "수요일"
        case 4:
        return "목요일"
        case 5: return "금요일";
        case 6: 
        return "토요일";
        case 7: 
        return "일요일";
        default: 
        return "잘못된 요일 번호입니다."
    }
}

for(let i = 1; i < 9; i++){
    console.log(`${i}: ${getDay(i)}`);
}

const calculate = {
    add(a,b)
}