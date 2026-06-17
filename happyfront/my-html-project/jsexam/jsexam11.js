const arr1 = [1, 2, 3];
const arr2 = [4, 5,6];
const combined = [...arr1, ...arr2];
console.log(combined);

const original = [1, 2, 3];
const copy = [...original];
console.log(copy);

const[first, second, ...rest] = [1, 2, 3, 4, 5];
console.log(first);
console.log(second);
console.log(rest);

let x = 10, y = 20;
[x, y] = [y, x];
console.log(x, y);

const numbers = [1, 2, 3, 4,5];

numbers.forEach(num => {console.log(num * 2);});

const doubled = numbers.map(num => num * 2);
console.log(doubled);

const evens1 = numbers.filter(num => num % 2 === 0);
console.log(evens1);

const newEvens = [];
let index = 0;
for(let i = 0; i < numbers.length; i++){
if(numbers[i] % 2 === 0){
    newEvens[index++] = numbers[i];
}
}
console.log(newEvens);

const sum = numbers.reduce((acc, cur) => acc + cur, 0);
console.log(sum);

const avg = numbers.reduce((acc, cur, idx, arr) => {
    if(idx === arr.length - 1) {
        return(acc + cur) / arr.length;
    }
return acc + cur;}, 0);
console.log(avg);

const users = [
    { id: 1, name: '김철수'},
    { id: 2, name: '이영희'},
    { id: 3, name: '박민수'}
];

const user = users.find(u => u.id === 2);
console.log(user);

const index = users.findIndex(u => u.id === 2);
console.log(index);

