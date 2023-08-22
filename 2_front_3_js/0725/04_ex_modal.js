// 04_ex_modal.js

// 0724 03 ex alert에서 했던 알림창 방식
// (1) JS 문법
// const btnClose = document.querySelector('.close');
// const blackBg = document.querySelector('.black-bg');
// // const btnModify = document.querySelector('#modify-btn');
// const btnModify = document.getElementById('modify-btn');
// // blackBg.style.display = 'none';

// function closeFn() {
//   blackBg.style.display = 'none';
// }
// btnClose.addEventListener('click', closeFn);

// function showFn() {
//   blackBg.style.display = 'block';
// }
// // btnModify.addEventListener('click', showFn);
// window['modify-btn'].addEventListener('click', showFn); // 거참... 허허...

// (2) Jquery 문법
// $('.close').on('click', () => $('.black-bg').css('display', 'none'));
// $('#modify-btn').on('click', () => $('.black-bg').css('display', 'block'));

// css에서 만든 .show 를 탈부착시키는 방식으로 작업하심
// (3) JS 문법
// document.querySelector('#modify-btn').addEventListener('click', ()=>{
//   document.querySelector('.black-bg').classList.add('show');
//   document.querySelector('.black-bg').classList.toggle('show'); // 클래스 토글시켜도 됨
// });
// document.querySelector('.close').addEventListener('click', ()=>{
//   document.querySelector('.black-bg').classList.remove('show');
//   document.querySelector('.black-bg').classList.toggle('show'); // 클래스 토글시켜도 됨 동일하니까 함수 하나로 뺄 수도...
// });

const toggleShow = () => {
  document.querySelector('.black-bg').classList.toggle('show');
}
document.querySelector('#modify-btn').addEventListener('click', toggleShow);
document.querySelector('.close').addEventListener('click', toggleShow);

// (4) Jquery 문법
// $('#modify-btn').on('click', () => $('.black-bg').addClass('show'));
// $('.close').on('click', () => $('.black-bg').removeClass('show'));
// 마찬가지로...
// const toggleShow = () => {
//   // $('.black-bg').toggleClass('show'); 
//   $('.black-bg').toggle('show'); // toggle 로 하면 애니메이션도 됨, 남발하면 성능 저하의 원인이 된다심 ㄷㄷ
//   // jQuery에서는 애니메이션도 같이 부여된 것들도 몇 가지 있다심 그렇지만... css transition keyframe 이용하면 되니까...
//   // $('.black-bg').fadeIn('show'); // 나타나게 하는 거
//   // $('.black-bg').fadeOut('show'); // 없어지게 하는 거
// };
// $('#modify-btn').on('click', toggleShow);
// $('.close').on('click', toggleShow);