// 기본 for문
for (let i = 0; i < 5; i++) {
    console.log(i);
}

// 배열 순회
const colors = ['red', 'green', 'blue'];
for (let i = 0; i < colors.length; i++) {
    console.log(colors[i]);
}

let count = 0;
while(count < 5){
    console.log(count);
    count++;
}

const person = { name: '김철수', age: 25 };
for (let key in person) {
    console.log(`${key}: ${person[key]}`);
}

for(let i = 0; i < 10; i++){
    if(i === 5) break;
    console.log(i);
}

for (let i = 0; i < 5; i++){
    if(i === 2) continue;
    console.log(i);
}

function sumOf(numbers) {
    let sum = 0;
    for(let i = 0; i < numbers.length; i++){
        sum += numbers[i];
    }
    return sum;
}

const result = sumOf([1, 2, 3, 4, 5]);
console.log(result);

for(let i = 0; i <= 20; i++){
    if(i % 3 === 0){
        console.log(i);
    }
}