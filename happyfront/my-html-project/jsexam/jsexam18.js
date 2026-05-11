// function hi() {
//   console.log("hello~~");
// }

// console.log("Start~~");
// //비동기함수
// setTimeout(hi, 3000);

// console.log("end~~");

// console.log("end~~");

// console.log("end~~");

// console.log("end~~");

function work() {
  setTimeout(() => {
    console.log("work start!!!");
    const start = Date.now();
    for (let i = 0; i < 1000000; i++) {}

    const end = Date.now();

    console.log(end - start + "ms");
    console.log("work end!!");
  }, 0);
}

console.log("start!!");
work(); // 이 함수가 다 실행되고 나면 해야할 일이 있다.
console.log("work()가 끝나면 해야할일!!!"); //work()보다 먼저 실행되요..
// 콜백함수!!!
console.log("end!!");
