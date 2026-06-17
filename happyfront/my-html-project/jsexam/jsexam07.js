const person = {
    name: 'kang',
    age:25,
    city:'서울',
    isStudent:true
};

console.log(typeof person);

console.log(person.name);

console.log(person["age"]);

person.name = "carami";

console.log(person.name);

person.email = "carami@gmail.com";

console.log(person.email);

const dog ={
    name: "멍멍이",
    age: 3,
    sound: "멍멍",

    say: function(){
        console.log("======function======");
        console.log(this);
        console.log(this.sound);
        console.log("==============");
    },

    say2: () => {
        console.log("======>=====");
        console.log(this);
        console.log(this.sound);
        console.log("==============");
    },
};

dog.say();
console.log(dog);
console.log(dog.name);
console.log(dog.age);

dog.say2();

const winTest = () =>{
    console.log("객체밖 :: " + this);
};

winTest();