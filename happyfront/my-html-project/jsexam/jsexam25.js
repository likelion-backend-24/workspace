let oldName = "kang";
let newName = "carami";

if (newName) {
  oldName = newName;
}
// 위의 if 문과 동일함.
newName && (oldName = newName);
// 이것은 다른코드  newName true라면 newName = oldName     ==  kang 이 출력되겠어요.
// if (newName) {
//   newName = oldName;
// }
// 위 if문과 같은 코드겠어요~~

newName &&= oldName;

const person = { name: "", age: 0 };

// const person = { name: "" };

person.name ||= "carami";

person.age ||= 20;
// person.age ??= 20;

console.log(person);

function makeObj(obj) {
  obj.name ??= "guest";
  obj.age ??= 15;
  return obj;
}

console.log(makeObj(person));

console.log(makeObj({}));

console.log(makeObj({ name: "kang" }));

console.log(makeObj({ age: 10 }));
