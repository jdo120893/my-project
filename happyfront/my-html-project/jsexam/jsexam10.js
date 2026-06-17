// 배열 생성
const fruits = ['사과', '바나나', '오렌지'];
const numbers = [1, 2, 3, 4, 5];
const mixed = [1, 'hello', true, null];

// 요소 접근
console.log(fruits[0]);    // 사과
console.log(fruits[2]);    // 오렌지

// 요소 수정
fruits[1] = '포도';

// 길이 확인
console.log(fruits.length);  // 3

console.log(fruits);

const arr = [1, 2, 3];

// 추가/제거
arr.push(4);        // 끝에 추가: [1, 2, 3, 4]
arr.pop();          // 끝에서 제거: [1, 2, 3]

arr.unshift(0);     // 앞에 추가: [0, 1, 2, 3]
arr.shift();        // 앞에서 제거: [1, 2, 3]

// 연결과 분할
const arr2 = [4, 5];
const combined = arr.concat(arr2);  // [1, 2, 3, 4, 5]
const sliced = combined.slice(1, 3);  // [2, 3]
console.log(sliced);

const arr5 = [1, 2, 3];

const [a , b, c] = arr5;
console.log(a);
console.log(b);
console.log(c);