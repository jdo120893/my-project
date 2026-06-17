let oldName = "kang";
let newName;

if (newName) {
    oldName = newName;
}

newName && (oldName = newName);

newName &&= oldName;

const person = { name: "", age: 0};

// const person = { name: "" };
person.name ||= "carami";

// person.age  ||= 20;
person.age ??= 20;

console.log(person);

function makeObj(obj) {
    obj.name ??= "guest";
    obj.age ??= 20;
    return obj;
}

console.log(makeObj(person));

console.log(makeObj({}));

console.log(makeObj({ name: "kang"}));

console.log(makeObj({ age: 10}));