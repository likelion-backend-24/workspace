console.log("hello");

console.log(greet("강경미", "안녕")); //function() 은 호이스팅이 되어서 실행가능!!
console.log(greet("강경미"));

function greet(name) {
  return `안녕하세요, ${name}님`;
}
function greet(name, message) {
  return `${message}, ${name}님`;
}

// console.log(greet2("carami"));   호이스팅 되지 않으므로 오류!!!

// 상수에 함수가 들어가네요. (함수를 일급객체로 취급해줌!!)
const greet2 = function (name) {
  return `안녕하세요, ${name}님`;
};

// const greet2 = function (name, message) {
//   return `${message}, ${name}님`;
// };

console.log(greet2("carami"));

const greet3 = (name) => {
  return `안녕하세요, ${name}님!`;
};

console.log(greet3("박민수"));

// 기본 형태
const add = (a, b) => {
  return a + b;
};

// 축약 1: 본문이 한 줄이면 중괄호와 return 생략 가능
const add2 = (a, b) => a + b;

// 축약 2: 매개변수가 하나면 괄호 생략 가능
const double = (x) => x * 2;

// 축약 3: 매개변수가 없으면 빈 괄호 필수
const sayHello = () => {
  return "Hello!";
};

const sayHello2 = () => "hi!!";

console.log(sayHello());

console.log(sayHello2());

// ❌ 잘못된 방법 - 중괄호가 함수 본문으로 해석됨
const createUser = (name) => {
  name: name;
}; // undefined 반환!

// ✅ 올바른 방법 - 소괄호로 감싸기
const createUser2 = (name) => ({ name: name });

// 또는 풀어서 작성
const createUser3 = (name) => {
  return { name: name };
};

console.log(createUser("김철수")); // undefined
console.log(createUser2("김철수")); //{ name: '김철수' }
console.log(createUser3("김철수")); //{ name: '김철수' }

const createTodo = (text) => ({
  id: Date.now(),
  text: text,
  done: false,
});

const todo1 = createTodo("자바스크립트 복습하기.");

console.log(todo1);

const createTodo2 = (text) => ({
  id: Date.now(),
  text, //단축속성명  text:text
  done: false,
});

const todo2 = createTodo2("자바스크립트 복습하기.");
console.log(todo2);

const user = {
  name: "김철수",

  // 일반 함수: this = 호출한 객체 (user)
  greetNormal: function () {
    console.log(`안녕하세요, ${this.name}입니다.`);
  },

  // 화살표 함수: this = 상위 스코프의 this
  greetArrow: () => {
    console.log(`안녕하세요, ${this.name}입니다.`);
  },

  //setTimeout안의 함수는 별도로 호출되므로 this가 user가 아님!!
  delayedGreenNormal: function () {
    setTimeout(function () {
      console.log(`setTimeout function ${this.name}님 hello!! `);
    }, 100);
  },
  //setTimeout 안의 화살표 함수는 this가 user 가된다.
  delayedGreenArrow: function () {
    setTimeout(() => {
      console.log(`setTimeout function ${this.name}님 hello!! `);
    }, 100);
  },
};

user.greetNormal(); // 안녕하세요, 김철수입니다.
user.greetArrow(); // 안녕하세요, undefined입니다. (전역 this 참조)

user.delayedGreenNormal(); //setTimeout function undefined님 hello!!
user.delayedGreenArrow(); //setTimeout function 김철수님 hello!!
