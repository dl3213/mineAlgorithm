// console.log("helloJS");
// var a
// console.log(a)

console.log(isNaN(NaN)) //true
console.log(typeof NaN) //number
console.log(undefined === undefined) //true
console.log(0.1 + 0.2 == 0.3) //false
console.log('A' - 'B') //Nan
console.log('A' - 'B' + 1) //Nan
console.log(typeof '3') //string
console.log(typeof 3) //number
console.log(typeof +'3') //number
console.log(typeof(''+3)) //string
console.log(2+1+'3') //33
console.log('3'+2+1) //321
console.log("0||1=" + (0||1)) //1
console.log("1||2=" + (1||2)) //1
console.log("0&&1=" + (0&&1)) //0
console.log("1&&2=" + (1&&2)) //2
console.log(1&&2&&0) //0
console.log(1&&0&&1) //0
console.log(1&&2&&3) //3
console.log(1||2||0) //1
console.log(0||2||1) //2
console.log(0||0||false) //false
console.log(1&&2||0) //2
console.log(0||2&&1) //1
console.log(0&&2||1) //1
