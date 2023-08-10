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

$('.tab-button').on('click', (e)=> { // 인덱스를 알려면 버블링 개념을 알아야 한다심... 바닐라js처럼 반복문 굴리는 방법으로 설명하심
  // console.log(e.target.innerHTML.charAt(0));
  // console.log($(e.target).index());
  $('.tab-button').removeClass('select');
  $('.tab-content').removeClass('show');
  // $('.tab-button').eq(Number(e.target.innerHTML.charAt(0))-1).addClass('select');
  // $('.tab-content').eq(Number(e.target.innerHTML.charAt(0))-1).addClass('show');
  $('.tab-button').eq($(e.target).index()).addClass('select');
  $('.tab-content').eq($(e.target).index()).addClass('show');
});