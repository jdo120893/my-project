console.log("hello js");

let value = 10;
console.log(value);
value = 'hello';
console.log(value);
value = function() {
   console.log("hello");
};
console.log(value);

value();

const a = 10;

// a = 20;

var varvalue = 10;

var varvalue = 20;

console.log(varvalue);

console.log(b);

var b = 20;

console.log(b);

// console.log(letb);

let letb = 10;

function varScopeTest(){
    if(true){
        var varScope = 20;
    }
    console.log(varScope);
}

varScopeTest();

function letScopeTest(){
    if(true){
        let letScope = 20;
    }
    // console.log(letScope);
}

letScopeTest();

let str = "abc";
console.log(typeof str);
str = 10;
console.log(typeof str);

