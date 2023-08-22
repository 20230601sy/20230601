// 부트스트랩에 있는 드롭다운이 있는 탭... 탭메뉴 직접 만들 거라심

// 순수 쌩자바로 한 거를 보통 바닐라 js 라고 한다심. 왜인지는 모르겠다심. 알 거 같기도 ㅋㅋㅋ 맛있겠다 바닐라ㅎㅎ 따지고보면 라이브러리 가져다 쓰는 건데... Node.js, View js, 앵귤러 js 등등 많다심
// const tabBtn = document.querySelectorAll('.tab-button');
// const tabContent = document.querySelectorAll('.tab-content');

// 일단 2번 눌렀을 때부터 해보라심
// tabBtn[1].addEventListener('click', ()=>{
//   // alert('2번 누름!'); // 중간중간 확인할 것!ㅎ
//   for(let i=0; i<tabBtn.length; i++)
//     tabBtn[i].classList.remove('select');
//   for(let i=0; i<tabContent.length; i++)
//     tabContent[i].classList.remove('show');
//   tabBtn[1].classList.add('select');
//   tabContent[1].classList.add('show');
// });

// let rmSelect = () => {
//   tabBtn.forEach((item)=>item.classList.remove('select'));
//   tabContent.forEach((item)=>item.classList.remove('show'));
// };
// tabBtn.forEach((item, i)=>{
//   item.addEventListener('click', ()=>{
//     rmSelect();
//     item.classList.add('select');
//     tabContent[i].classList.add('show');
//   });
// });

// $('.tab-button').on('click', (e)=> { // 인덱스를 알려면 버블링 개념을 알아야 한다심... 바닐라js처럼 반복문 굴리는 방법으로 설명하심
//   // console.log(e.target.innerHTML.charAt(0));
//   // console.log($(e.target).index());
//   $('.tab-button').removeClass('select');
//   $('.tab-content').removeClass('show');
//   // $('.tab-button').eq(Number(e.target.innerHTML.charAt(0))-1).addClass('select');
//   // $('.tab-content').eq(Number(e.target.innerHTML.charAt(0))-1).addClass('show');
//   $('.tab-button').eq($(e.target).index()).addClass('select');
//   $('.tab-content').eq($(e.target).index()).addClass('show');
// });

// 반복문을 사용하면 성능 저하가 생기기 때문에 버블링을 활용해서 할 거라심
// 이벤트를 애초에 tab-button에 걸어주는 게 아닌 list에 걸어줄 거라심
// const tabBtn = $('.tab-button');
// const tabContent = $('.tab-content');
// function showTab(index) {
//   tabBtn.removeClass('select');
//   tabContent.removeClass('show');
//   tabBtn.eq(index).addClass('select');
//   tabContent.eq(index).addClass('show');
// }
// $('.list').on('click', (e) => {
// console.log(e);
// console.log(e.target == document.querySelectorAll('.tab-button')[0]); // jQuery로 나오는 target이랑 js로 나오는 target이 형태가 조금 달라서 둘이 비교는 안된다심...
// for(let i=0; i<$('.tab-button').length; i++)
//   if($(e.target).is($('.tab-button').eq(i)))
//     showTab(i);

// showTab($(e.target).index()); // ??? 걍 인덱스 쓰시징... ㄷㄷ
// });

// 이제 다른 기능으로 다시 변경할 거라심
// HTML에 dataset 이라는 게 있다심
// dataset : 사용자 정의 속성
// 속성에 대한 기능이 존재하진 않음
// 태그에 대한 정보를 dataset에 어느 정도 심어줄 수 있다심
// <태그 data-이름='값'> 태그 안에 단순한 값만 보관하는 용도, 태그들을 식별하기 위한 데이터를 넣을 때 사용한다심
// 기능은 화면상에 무슨 변화가 있다든지 그런 아무런 기능이 없고 특정 값을 보관할 수 있는 변수같은 느낌이라심
// 이 값을 js에서 불러와서 쓸 수 있다심
// data-index="0", data-val="2000" , ...
// e.target.dataset.index, tabBtn[1].dataset.val 등등 으로 호출 가능한 듯
// 이제 위에서 했던 걸 반복문 안 쓰고 할 거라심
// const tabBtn = $('.tab-button');
// const tabContent = $('.tab-content');
// let index = 1;
// $('.list').on('click', (e) => {
//   // alert(e.target.dataset.index);

//   tabBtn.eq(index).removeClass('select');
//   tabContent.eq(index).removeClass('show');

//   // design bug... 빈공간
//   if(index != undefined) {
//     index = Number(e.target.dataset.index);
//     tabBtn.eq(index).addClass('select');
//     tabContent.eq(index).addClass('show');
//   }
// });
// dataset은 많이 쓰는 속성 중의 하나라심, 복잡한 코드를 간단하게 할 수 있음...

const tabBtn = document.querySelectorAll('.tab-button');
const tabContent = document.querySelectorAll('.tab-content');
let index = 0;
document.querySelector('.list').addEventListener('click', (e) => {
  let index_ = e.target.dataset.index;
  if(index_ != undefined) {
    tabBtn[index].classList.remove('select');
    tabContent[index].classList.remove('show');
    index = Number(index_);
    tabBtn[index].classList.add('select');
    tabContent[index].classList.add('show');
  }
});