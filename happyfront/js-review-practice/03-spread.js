const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const test = [arr1, arr2];

console.log(test);

const combined = [...arr1, ...arr2];
console.log(combined);

// 배열 복사
const copy = [...arr1];
console.log(copy); // [1, 2, 3]

// 중간에 요소 추가
const withMiddle = [...arr1, 10, 20, ...arr2];
console.log(withMiddle); // [1, 2, 3, 10, 20, 4, 5, 6]

const user = {
  name: "김철수",
  age: 25,
};

// 객체 복사
const userCopy = { ...user };

// 속성 추가
const userWithEmail = { ...user, email: "kim@example.com" };
console.log(userWithEmail);
// { name: "김철수", age: 25, email: "kim@example.com" }

// 속성 덮어쓰기
const olderUser = { ...user, age: 26 };
console.log(olderUser);
// { name: "김철수", age: 26 }

let todos = [
  { id: 1, text: "리액트 공부하기", done: false },
  { id: 2, text: "자바스크립트 복습하기", done: true },
];

function setTodos(newTodos) {
  todos = newTodos;
  console.log("Todo update :: ", todos);
}

//퀴즈1.  위의 todos 배열에 항목을 하나 더 추가 해보세요.
const newItem = { id: 3, text: "점심맛있게먹기", done: false };
setTodos([...todos, newItem]);
console.log(todos);

//퀴즈2. todos 배열에서 id가 2번인 데이터를 삭제해 주세요.
setTodos(todos.filter((todo) => todo.id !== 2));
console.log(todos);
//퀴즈3. todos 배열에서 id가 1번인 데이터의 done이 true라면 false 로
//       false라면 true 로 바꿔주세요..
setTodos(
  todos.map((todo) => (todo.id === 1 ? { ...todo, done: !todo.done } : todo)),
);
console.log(todos);

let cartState = [
  { id: 1, productName: "pen", price: 3000, quantity: 1 },
  { id: 2, productName: "note", price: 5000, quantity: 5 },
  { id: 3, productName: "pad", price: 300000, quantity: 2 },
];

//1. id가 1인 상품의 수량을 3으로 바꿔주세요.
let cartState2 = cartState.map((product) =>
  product.id === 1 ? { ...product, quantity: 3 } : product,
);
console.log(cartState2);
//2. 새로운 상품을 하나 추가하세요.

//3. id가 3인 상품을 삭제해 주세요.

// 첫 번째 인자는 first, 나머지는 모두 others 배열로
function introduce(first, second, ...others) {
  console.log("첫 번째:", first);
  console.log("나머지:", others);
}

introduce("사과", "바나나", "딸기", "포도");
// 첫 번째: 사과
// 나머지: ["바나나", "딸기", "포도"]

const numbers = [1, 2, 3, 4, 5];

const [first, second, ...rest] = numbers;

console.log(first); // 1
console.log(second); // 2
console.log(rest); // [3, 4, 5]

const user8 = {
  name: "김철수",
  age: 25,
  email: "kim@example.com",
  phone: "010-1234-5678",
};

const { name, ...others } = user8;

console.log(name); // 김철수
console.log(others); // { age: 25, email: "kim@example.com", phone: "010-1234-5678" }
