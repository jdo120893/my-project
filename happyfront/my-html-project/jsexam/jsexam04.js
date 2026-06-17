let name = "carami";
let greeting = `Hello, ${name}`;

console.log(greeting);

let isActive = true;

console.log(typeof isActive);

console.log("carami's ");
console.log('carami"s ');

const emptyValue = null;

console.log(emptyValue);

let notDefined;
console.log(notDefined);

console.log(1 === "1");

console.log(true&&true);
console.log(true&&false);

console.log(true||false);
console.log(false||false);

console.log(!true);
console.log(!false);

// 조건 ? 참일때 : 거짓일때
const age = 20;
const status = age >= 18 ? '성인' : '미성년자';
console.log(status);  // 성인

// 중첩 삼항 연산자 (가독성 주의)
const score = 85;
const grade = score >= 90 ? 'A' :
              score >= 80 ? 'B' :
              score >= 70 ? 'C' : 'F';
console.log(grade);  // B