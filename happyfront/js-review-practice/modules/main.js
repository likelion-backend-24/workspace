import { PI, add, divide } from "./utils.js";
import Calculator from "./Calculator.js";
import { FFFNAME } from "./Calculator.js";

console.log(PI);
console.log(add(2, 4));

console.log(divide(4, 2));

const cal = new Calculator();
console.log(cal.add(2, 4));

console.log(FFFNAME);
