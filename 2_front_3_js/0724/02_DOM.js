// 02_DOM.js
// DOM ( Document Object Model - 문서 객체 모델 )
// 돔이라는 게 뭐냐면 html문서를 접근하기 위한 ... 자바로 치면 인터페이스라고 보면 된다심
// 태그들을 자바스크립트에서 접근해서 제어하고 
// document (html 파일 전체) > html > head, body
// head > meta, title, body > div, p ... 등등
// 구조는 html 문서를 직접 보거나 개발자도구에서 보거나 아무튼 간단히 할 수 있는 거 해보면...
document.body.style.background = 'pink';
// 종류는 엄청 많아서... 그때그때 볼거라심
// 실제 태그가 존재할 수도 있고, 존재하지 않는다고 할 수도 있음
// script 링크 위치가 중요한데, 
// (1) head에 넣으면 문서를 읽어오는 도중에 html 요소를 접근하려고 하면 없다고 내뱉기 때문에...
// (2) script 태그에서 효과 넣고 하기 때문에 로딩시간이 걸림... 웹페이지 로딩속도가 느려지기 때문에
// 그래서 script 태그를 html body 최하단에 넣는 거임

// html에서 작업해서 조금 확인해보기

// id로 접근하는 방법 (애초에 html에서 id는 중복하면 안됨, 처음 id에만 작업됨. 신경쓸 것)
document.getElementById('ele').style.background = 'white';
document.getElementById('ele').style.color = 'red';
// 문서 전체에서 검색작업을 2번 해야 하기 때문에, 변수에 담아서 쓴다심
const ele = document.getElementById('ele');
ele.style.background = 'white';
ele.style.color = 'red';

// 선택자를 이용해서 접근하는 방법
let ul = document.querySelectorAll('ul'); // 매개변수로는 css에서 썼던 선택자를 쓰면 됨, All이라는 건 다 가지고 온다는 의미..
// ul.style.background = 'white'; // 이러면 안됨...해당 선택자가 1개만 있다고 해도 배열방 써줘야 함
ul[1].style.background = 'white'; // querySelectorAll은 여러가지를 담고 있다보니 배열처럼 사용해야 함... 한번에 일괄적으로 안되는 불편함이 있음

let lastLi = document.querySelectorAll('ul>li:last-child');
lastLi[2].style.color = 'red';

let test = document.querySelector('.test'); // 첫번째꺼 하나만 가져옴
test.style.color = 'red';

test = document.querySelector('#ele');
test.style.color = 'skyblue';

// JS하면서 jQuery도 같이 할 거라심, 새로운 언어가 아니라 JS 라이브러리... 요즘 최신은 잘 안 쓰지만 레거시에는 많이 걸려있다심, JS 라이브러리는 엄청 많다심, react, view, 쌩자바는 불편하게 만들어진 게 많다심...
// jQuery는 document.querySelector('#ele')를 $("#ele")로 확 줄여준다심 ㄷㄷ
console.log('------------------------------');
for(let node of document.body.children)
  console.log(node);
console.log('------------------------------');
for(let node of document.body.children)
  if(node.matches('a')) // matches 안에도 선택자, a 태그만 걸러줌
    console.log(node);
console.log('------------------------------');
for(let node of document.body.children)
  if(node.matches('a[href $="zip"')) // 태그속성 검색자, 따옴표 주의!
    console.log(node);

// 진도 좀 빨리 나가서 리액트도 같이 할 거라심 js 라이브러리니까 js 잘하면 리액트도 잘 한다심 ㄷㄷ
// 이번주 안으로 js 끝낼거라심

// 부모요소 찾아주는 거
console.log('------------------------------');
let chapter = document.querySelector('.chapter');
console.log(chapter.closest('.book')); // chapter를 감싸는 태그중에서, 매개변수(선택자) 찾기
console.log(chapter.closest('.content')); // 내가 원하는 조상요소 찾기이므로 부모의 부모도 가능
console.log(chapter.closest('#ele')); // 전혀 관계 없는 거 찾으면 null 반환 침

// 이런 것도 있음, 여기는 이름만들어감 선택자가 들어가는 게 아니기 때문에 .이나 #이 안 들어감
document.getElementsByClassName('클래스이름');
document.getElementsByTagName('태그명');
document.getElementsByName('name 이름'); // input 태그에서 많이 썼던 name...
