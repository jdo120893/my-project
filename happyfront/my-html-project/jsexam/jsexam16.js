function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

// function process(func) {
//   console.log("안녕!!");
//   sleep(3000).then(() => {
//     console.log("반갑습니다.");

//     func();
//   });
// }

async function process() {
  console.log("안녕!!");

  await sleep(3000);
  console.log("반갑습니다.");
}

console.log("process 호출 전!!");

// process(() => {
//   console.log("프로세스 종료!!");
// });

process();

console.log("process 호출 후!!");
