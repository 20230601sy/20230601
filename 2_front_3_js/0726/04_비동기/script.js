// 타이머 같은 거 만들 거라심
// setTimeout : 설정한 시간이 지난 뒤 실행
// setTimeout(콜백함수, 시간ms)
// 5초 뒤에 창이 사라지게 할 거라심

// setTimeout(()=>{
//   alert('test');
// }, 3000);

// 이런 setTimeout 같은 함수는 js에서 제공하는 대표적인 비동기 함수 중의 하나라심
// 일반적인 함수들은 동기식함수라심
// console.log 여러 개 실행시키면 위에서부터 차례대로 실행
// 중간에 alert이 있으면 alert 작동 끝날 때까지 대기
// 비동기는 무조건 처리하는 게 아니라 처리할 게 많으면 건너 뛸 수 있음...

// console.log('1');
// console.log('1');
// setTimeout(()=>{
//   console.log('test');
// }, 3000);
// console.log('1');
// console.log('1');

// 예를 들어 서버에서 데이터를 받아올 때 양이 많으면
// 계속 기다리고 있을 순 없잖음
// 화면 표시 멈출 거임? 그럼 안 되지... 한국인은 못참아 안들어간다심 케케
// 시간이 좀 걸리는 거는 뒤로 미루는 거임
// 밑에 처리할 게 있으면 내려간다
// 이게 기본적인 비동기 방식의 기본 개념
// 지금은 간단한 개념 정도만 봐두라심
// 쓰레드는 분할하는 거지...완전 다른 개념이라심
// 웹페이지는 기본적으로 싱글쓰레드라심

setTimeout(()=>{
  document.querySelector('.alert').style.display = 'none';
}, 3000);

function show() {
  document.querySelector('.alert').style.display = 'block';
}
setTimeout(show, 3000);

// 다른 비동기방식 함수 중에는 계속 반복적으로 실행하는 setInterval(콜백함수, 주기ms)가 있음
// let i=0;
// setInterval(()=>{
//   console.log(i++);
// }, 1000);

// 활용하면 timer도 만들 수 있다심 물론 타이머는 다른 걸로 사용하는 게 더 좋다심
let t = 0;
let temp = setInterval(()=>{
  document.querySelector('.alert-secondary > span').innerHTML = ++t;
}, 1000);

// 할인 5초전!!!
// setInterval 은 계속 돌아가고 있으니까 자원소모가 됨
// 중지시키는 건 setInterval을 저장하고 있는 변수가 있어야 하고 그거를 clearInterval 넣어주면 됨
const timeTag = document.querySelector('.alert-danger > span');
let totalTime = Number(timeTag.innerHTML)*1000;
let interval = setInterval(()=>{
  timeTag.innerHTML = Number(timeTag.innerHTML) - 1;
}, 1000);
let timeout = setTimeout(()=>{
  clearInterval(interval);
  document.querySelector('.alert-danger').innerHTML = '할인 마감';
}, totalTime);

setTimeout(()=>{
  clearTimeout(temp);
}, 6000);

// 시계도 만들 수 있다심
const date = new Date();
console.log(date);
console.log(date.getFullYear()); // 년
console.log(date.getMonth() + 1); // 월 0~11
console.log(date.getDay()); // 요일 (일요일:0 ~ 토요일:7)
console.log(date.getDate()); // 일
console.log(date.getHours()); // 시
console.log(date.getMinutes()); // 분
console.log(date.getSeconds()); // 초

function showClock() {
  let time = new Date();
  let hour = String(time.getHours()).padStart(2, 0); // 2자리 0으로 채워 나오게 하는 함수 padStart 사용 : 문자열.padStart(자리수, 채울 문자), 숫자라서 String오로 형변환함.
  let minite = String(time.getMinutes()).padStart(2, 0);
  let second = String(time.getSeconds()).padStart(2, 0);
  document.querySelector('.alert-primary').innerHTML = `${hour}시 ${minite}분 ${second}초`;  
}
showClock(); // 시작 1초의 틈이 생기지 않도록!
let timeInterval = setInterval(showClock, 1000);
setTimeout(()=>{
  clearInterval(timeInterval);
}, 600000);