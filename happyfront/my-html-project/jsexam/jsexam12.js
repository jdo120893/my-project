// const users = [
//     { id: 1, name: '김철수'},
//     { id: 2, name: '이영희'},
//     { id: 3, name: '박민수'}
// ];

// const user = users.find(u => u.id === 2);
// console.log(user);

// const index = users.findIndex(u => u.id === 2);
// console.log(index);

// const numbers = [10, 20, 30, 40];
// const index = numbers.indexOf(30);
// numbers.splice(index, 1);
// console.log(numbers);

// const arr = [ 10, 20, 30, 40 ];
// const sliced = arr.slice(0,2);
// console.log(sliced);
// console.log(arr);

const array = [1, 2, 3, 4 ,5];
console.log(array.join());
console.log(array.join(' '));
console.log(array.join(' - '));

const fruits = ['사과', '바나나', '오렌지', '포도'];

// indexOf - 인덱스 찾기
console.log(fruits.indexOf('바나나'));  // 1
console.log(fruits.indexOf('수박'));    // -1 (없음)

// includes - 포함 여부 확인
console.log(fruits.includes('오렌지'));  // true
console.log(fruits.includes('수박'));    // false