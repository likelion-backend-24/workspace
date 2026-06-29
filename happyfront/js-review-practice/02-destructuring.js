const user = {
  name: "김철수",
  age: 25,
  email: "kim@example.com",
};

// 기존 방식
// const name = user.name;
// const age = user.age;

// 구조 분해 할당
// const { age, email, name } = user;

const { email, name } = user;

// const { email2, name2 } = user;  //이건 안되요!!

console.log(name); // 김철수
// console.log(age); // 25
console.log(email); // kim@example.com

const customer = {
  id: 1,
  customerName: "kang",
  phoneNumber: "010-111-111",
  address: "경기도 고양시",
};

const { customerName, address } = customer;

console.log(customerName);
console.log(address);

const user2 = {
  id: 1,
  profile: {
    firstName: "철수",
    lastName: "김",
    address: {
      city: "서울",
      district: "강남구",
    },
  },
  settings: {
    theme: "dark",
    notifications: true,
  },
};

const {
  profile: {
    firstName,
    lastName,
    address: { city, district },
  },
  settings: { theme },
} = user2;

console.log(firstName);
console.log(city);

//배열의 구조분해는 순서가 중요!!!
const colors = ["빨강", "파랑", "초록"];

// 기존 방식
const first = colors[0];
const second = colors[1];

// 구조 분해 할당
// const [first, second, third] = colors;

console.log(first); // 빨강
console.log(second); // 파랑
// console.log(third); // 초록

const numbers = [1, 2, 3, 4, 5];

// 두 번째 요소 건너뛰기
// const [first, , third] = numbers;

console.log(first); // 1
// console.log(third); // 3

const user5 = { name: "kim", age: 25 };

greetUser(user5);

function greetUser(user) {
  console.log(`${user.name} 님은 ${user.age} 입니다.`);
}

function greetUser({ name, age }) {
  console.log(`${name} 님은 ${age} 입니다.`);
}

function useState(initialValue) {
  let state = initialValue;

  const setState = (newValue) => {
    state = newValue;
    console.log(`state가 ${newValue}로 변경됨`);
  };

  return [state, setState];
}

const [a, b] = useState(0);

console.log(a);
b(4);

const [count, setCount] = useState(0);

console.log(count);
setCount(1);

const [name, setName] = useState("no name");
console.log(name);
setName("knag");

const [price, setPrice] = useState(1000);
console.log(price);
setPrice(20000);
