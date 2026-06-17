// function Animal(type, name, sound){
//     this.type = type;
//     this.name = name;
//     this.sound = sound;
//     this.say = function(){
//         console.log(this.sound);
//     };
// }

// const dog = new Animal('개', '멍멍이', '멍멍');
// const cat = new Animal('고양이', '야옹이', '야옹');

// dog.say();
// cat.say();

// class Animal{
// constructor(type, name, sound){
//     this.type = type;
//     this.name = name;
//     this.sound = sound;
// }

// say(){
//     console.log(this.sound);
// }
// }

// class Dog extends Animal{
//     constructor(name, sound){
//         super('개', name, sound);
//     }
// }

// class Cat extends Animal{
//     constructor(name, sound){
//         super('고양이', name, sound);
//     }
// }

// const dog = new Dog('멍멍이', '멍멍');
// const cat = new Cat('야옹이', '야옹');
// const dog2 = new Dog('왈왈이', '왈왈');
// const cat2 = new Cat('냐옹이', '냐옹');

// dog.say();
// cat.say();
// dog2.say();
// cat2.say();

// 기본 에러 처리
// try {
//     const result = someFunction();
//     console.log(result);
// }catch(error){
//     console.error('에러 발생:', error.message);
// } finally{
//     console.log('정리 작업');
// }

// // 에러 던지기
// function divide(a, b){
//     if(b === 0){
//         throw new Error('0으로 나눌 수 없습니다!');
//     }
//     return a / b;
// }

// try{
//     const result = divide(10, 0);
// } catch(error){
//     console.error(error.message);
// }

// function Animal(type, name, sound){
//     this.type = type;
//     this.name = name;
//     this.sound = sound;
// }

// Animal.prototype.say = function(){
//     console.log(this.sound);
// };

// Animal.prototype.sharedValue = 1;

// const dog = new Animal('개', '멍멍이', '멍멍');
// const cat = new Animal('고양이', '야옹이', '야옹');

// dog.say();
// cat.say();
// console.log(dog.sharedValue);
// console.log(cat.sharedValue);

function Animal(type, name, sound){
    this.type = type;
    this.name = name;
    this.sound = sound;
}

Animal.prototype.say = function(){
    console.log((this.sound));
};

function Dog(name, sound){
    Animal.call(this, '개', name, sound);
}
Dog.prototype = Object.create(Animal.prototype);
Dog.prototype.constructor = Dog;

function Cat(name, sound) {
    Animal.call(this, '고양이', name, sound);
}
Cat.prototype = Object.create(Animal.prototype);
Cat.prototype.constructor = Cat;

const dog = new Dog('멍멍이', '멍멍');
const cat = new Cat('야옹이', '야옹');

dog.say();
cat.say();