const box = document.querySelector('.box');

let boxY = box.scrollHeight;
let boxHeight = box.clientHeight;
// console.log(boxY); // 497, 박스의 총높이
// console.log(box.clientHeight); // 192, 화면상 나타나는 박스 높이 실제 안쪽만 잡힌다심, client의 의미가 정확히 어떤 의미로 쓰이는 거지...

let isDisabled = true;
box.addEventListener('scroll', ()=>{
  let scroll = box.scrollTop; // 스크롤해서 움직인 높이
  // 마지막까지 이동한 값은 boxY-boxHeight 임 주의!!!
  // console.log(scroll);
  // isDisabled를 조건식 앞에 두는 걸 권장하는데, 왜냐하면 isDisabled가 false이면 뒤에 조건식 거르고 바로 판단할 수 있어서 연산을 줄여주기 때문...
  if(isDisabled && (boxHeight + scroll > boxY-5)) { // boxHeight + scroll > boxY-5 일부 오차값이 생길 수 있어서 필요하다심
    // alert('마지막임');
    isDisabled = false;
    // chk.removeAttribute('disabled');
    document.querySelector('#chk').disabled = false; // true면 비활성화, false면 해당 태그 활성화임~~~
  }
});

let windowHeight = window.innerHeight; // 창화면 내용 높이, 사용자가 창크기 줄이면 줄어드는 값
console.log('windowHeight', windowHeight); //
let bodyHeight = document.querySelector('body').clientHeight;
console.log('bodyHeight', bodyHeight); //
window.addEventListener('scroll', ()=>{
  let windowScroll = window.scrollY; // window는 scrollY
  let barWidth = 100*windowScroll/(bodyHeight-windowHeight);
  console.log('barWidth', barWidth);
  document.querySelector('.bar').style.width = `${barWidth}%`;
});