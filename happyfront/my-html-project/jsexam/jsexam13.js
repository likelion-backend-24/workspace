for (let i = 0; i < 5; i++) {
  console.log(i);
}

const colors = ["red", "green", "blue"];
for (let i = 0; i < colors.length; i++) {
  console.log(colors[i]);
}

let count = 0;
while (count < 5) {
  console.log(count);
  count++;
}

// for...in (객체 속성 순회)
const person = {
  name: "김철수",
  age: 25,
  address: "경기도 고양시",
  add: function (a, b) {
    return a + b;
  },
};

const { name, age, address } = person;

function test({ name }) {
  console.log(name);
}

test(person);

const arr = [1, 2, 3];

const [a, b, c] = arr;

for (let key in person) {
  console.log(`${key}: ${person[key]}`);
}
