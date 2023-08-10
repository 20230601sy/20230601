// 05_ex2_navBar.js

// jQuery 자동 완성이 안되니까 불편한데... 
// 해결하려면 몇가지 설치해야 한다심
// nodejs 검색 후 LTS(long time stability?? 라심) 버전 다운로드, 현재 버전은 불완전한 느낌이 있다심
// https://nodejs.org/ko/download
// 서버긴 하고 패키지 매니저를 사용할 거라심
// 사용자들이 여러 가지 라이브러리를 저장해놓은 ... 서버 // pip 같은 건가
// 리액트할 때는 많이 사용할 거라심
// 부트스트랩같은 겉도 노드제이에스 이용해서 npm ... 하면 폴더 안에 설치가 된다심
// 초기에 한 번 해야 하는 작업 있다심
// vscode 재부팅하라심
// ctrl + ` 눌러서 터미널창 열고 
// node js 초기화 작업해야 한다심
// 터미널 창에 npm init 치고 엔터 // npm은 node package manager? 약자라심
// 엔터 여러번 누르면 폴더에 package.json이 생성되는 거 확인 가능
// 터미널 창에 npm install @types/jquery --save 치고 엔터하면 2개 패키지 설치됐다고 나옴
// 한번만 설치하면 되지만... vscode 새폴더 읽어오면 다시 설치해야 한다심

// const toggleBtn = document.querySelector('.navbar-toggler');
// const listGroup = document.querySelector('.list-group');
// toggleBtn.addEventListener('click', () => listGroup.classList.toggle('show'));

$('.navbar-toggler').on('click', () => $('.list-group').toggleClass('show'));

// // $('.list-group-item').on('mouseover', (e) => e.target.classList.add('active'));
// // $('.list-group-item').on('mouseout', (e) => e.target.classList.remove('active'));
$('.list-group-item').on('mouseover', (e) => e.target.classList.remove('text-bg-dark'));
$('.list-group-item').on('mouseout', (e) => e.target.classList.add('text-bg-dark'));

// body 다크모드/라이트모드 버튼
const lightBtn = document.querySelector('.light-btn');
const darkBtn = document.querySelector('.dark-btn');
const toggleBtn = document.querySelector('.toggle-btn');
const body = document.querySelector('body');
darkBtn.addEventListener('click', () => {
  body.style.color = 'white';
  body.style.background = 'black';
});
lightBtn.addEventListener('click', () => {
  body.style.color = 'black';
  body.style.background = 'white';
});
// body 다크모드/라이트모드 토글
// let isLightMode = true;
// toggleBtn.addEventListener('click', (e) => {
//   if(isLightMode) {
//     body.style.color = 'white';
//     body.style.background = 'black';
//     e.target.style.color = 'black';
//     e.target.style.background = 'white';
//     e.target.setAttribute('value', '라이트모드');
//     toggleBtn.value = '라이트모드'; // 이것도 된다심
//  
//   } else {
//     body.style.color = 'black';
//     body.style.background = 'white';
//     e.target.style.color = 'white';
//     e.target.style.background = 'black';
//     e.target.setAttribute('value', '다크모드');
//   }
//   isLightMode = !isLightMode;
// });

$('.light-btn').on('click', () => {
  $('body').css('background','white');
  $('body').css('color','black');
});
$('.dark-btn').on('click', () => {
  $('body').css('background','black');
  $('body').css('color','white');
});

// $('.toggle-btn').on('click', () => $('body').toggleClass('text-bg-dark')); // 걍 bootstrap 쓸거면 확실히...ㅋㅋㅋ

$('.toggle-btn').on('click', () => {
  if($('.toggle-btn').val() === '토글모드' || $('.toggle-btn').val() === '다크모드') {
    $('body').css('background','black');
    $('body').css('color','white');
    $('.toggle-btn').attr('value', '라이트모드');
  } else {
    $('body').css('background','white');
    $('body').css('color','black');
    $('.toggle-btn').val('다크모드');
  }
});
