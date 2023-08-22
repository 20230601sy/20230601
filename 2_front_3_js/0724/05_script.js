// 05_script.js
let fruits = [
  { name : 'apple', memo : '새콤달콤 사과'},
  { name : 'mango', memo : '달달한 망고'},
  { name : 'melon', memo : '맛있는 메론'} // 이런 데이터는 원래 서버에서 받아오는 거라심... 형식은 배열 안에 object로 동일하다심, 지금은 서버가 읍으니껜...ㅠㅋ
];

// document.querySelectorAll('.card-body > h5')[0].innerHTML = fruits[0].name;
// document.querySelectorAll('.card-body > p')[0].innerHTML = fruits[0].memo;
// // 속성 값을 바꾸는 함수는 setAttribute(속성명 string href, class, src 등등등등, 속성값)
// document.querySelectorAll('.card > img')[0].setAttribute('src', '../../img/' + fruits[0].name + ".jpg");

// for(let i=0; i<fruits.length; i++) {
//   // JS 문법
//   // document.querySelectorAll('.card-body > h5')[i].innerHTML = fruits[i].name;
//   // document.querySelectorAll('.card-body > p')[i].innerHTML = fruits[i].memo;
//   // document.querySelectorAll('.card > img')[i].setAttribute('src', `../../img/${fruits[i].name}.jpg`); // js 옛날 버전은 백틱이 안된다심...spring legacy할 때 말씀하실 거라심

//   // Jquery 문법
//   // $('.card-body > h5').html('바꿈'); // 모두 바꿔짐 querySelectorAll은 배열방식인 것과 차이가 있음
//   $('.card-body > h5').eq(i).html(fruits[i].name); // eq가 배열방번호 나타내는 것과 동일함, html은 생자바에서 innerHTML
//   $('.card-body > p').eq(i).html(fruits[i].memo);
//   $('.card > img').eq(i).attr('src', `../../img/${fruits[i].name}.jpg`); // setAttribute가 그냥 attr(속성명, 속성값)임
//   // 편한 거 쓰면 되는데 이왕이면 JS를 정확하게 하고 Jquery는 덤이라고 생각하라심 JS 모르는데 Jquery 알면 이상한 거라심 ㅋㅋㅋ
// }

// html 추가도 js로 하는 첫번째 방법
let first = document.createElement('div'); // div라는 태그를 인식함
// first.className = 'col'; // 이방법은 기존에 있는 class를 날려버림
first.classList.add('col'); // 기존에 있는 class들에 추가하는 방법으로 좀더 안전한 방법임.
first.innerHTML = 
`<div class="card" style="width: 18rem;">
  <img src="../../img/${fruits[0].name}.jpg" class="card-img-top">
  <div class="card-body">
    <h5 class="card-title">${fruits[0].name}</h5>
    <p class="card-text">${fruits[0].memo}</p>
    <button class="btn btn-primary">담기</button>
  </div>
</div>`;
// document.querySelector('.row').appendChild(first); // 자식 뒤에 추가

// 두번째 방법, col 박스 만들지 말고 전체 변수 다 넣기
let second = 
`<div class="col">
  <div class="card" style="width: 18rem;">
    <img src="../../img/${fruits[1].name}.jpg" class="card-img-top">
    <div class="card-body">
      <h5 class="card-title">${fruits[1].name}</h5>
      <p class="card-text">${fruits[1].memo}</p>
      <button class="btn btn-primary">담기</button>
    </div>
  </div>
</div>`; // second는 단순 string 변수임, html 노드로 만들어서 집어넣게 끔해줘야 함. insertAdjacentHTML
// JS 문법
// document.querySelector('.row').insertAdjacentHTML("beforeend", second);
// Jquery 문법, 그냥 append 하면 됨
// $('.row').append(second);

// for(let i=0; i<fruits.length; i++) {
//   second = 
//     `<div class="col">
//       <div class="card" style="width: 18rem;">
//         <img src="../../img/${fruits[i].name}.jpg" class="card-img-top">
//         <div class="card-body">
//           <h5 class="card-title">${fruits[i].name}</h5>
//           <p class="card-text">${fruits[i].memo}</p>
//           <button class="btn btn-primary">담기</button>
//         </div>

//       </div>
//     </div>`;
//     $('.row').append(second);
// }

// let rowBox = $('.row'); // 반복문 안에 매번 검색시키면 시간이 걸리니껜.
// fruits.forEach((fruit) => {
//   content = 
//   `<div class="col">
//     <div class="card" style="width: 18rem;">
//       <img src="../../img/${fruit.name}.jpg" class="card-img-top">
//       <div class="card-body">
//         <h5 class="card-title">${fruit.name}</h5>
//         <p class="card-text">${fruit.memo}</p>
//         <button class="btn btn-primary">담기</button>
//       </div>

//     </div>
//   </div>`;
//   rowBox.append(content);
// });

// 혼자해보는 기존 html 활용방식 ㄷㄷ 되긴 된다ㅎ
// let col = document.querySelector('.col');
// // fruits.forEach((fruit)=> {
// //   let newCol = col.cloneNode(true);
// //   newCol.children[0].children[0].setAttribute('src',`../../img/${fruit.name}.jpg`);
// //   newCol.children[0].children[1].children[0].innerHTML = fruit.name;
// //   newCol.children[0].children[1].children[1].innerHTML = fruit.memo;
// //   rowBox.append(newCol);
// // });
// col.style.display = 'none';

// 이제 장바구니 기능 구현할 거임
// 장바구니 지금은 서버가 없으니 로컬스토리지를 활용할 거임, 사용자 컴퓨터에 저장시키는 개념
// 개발자도구 Application > Local Storage > http:// // 사용자 모르게 저장을 시켜줄 수 있음 으아닛 ㄷㄷ
// 장점 브라우저를 꺼도 남아 있음
// Session Storage 같은 경우는 사용자 컴퓨터에 저장되는 거는 동일한데 브라우저(인터넷창) 끄면 지워짐
// 기본적으로 로컬스토리지 안에는 key, value 형식으로 들어감
// 몇가지 함수 정리
// localStorage.setItem('name','홍길동'); // 추가, sessionStorage에 넣고 싶으면 sessionStorage 로 쓰면 됨
// localStorage.getItem('name'); // 키값 매개변수와 동일한 거 찾아서 value값 반환해줌
// map 형식이라 수정하는 게 따로 존재하지는 않고 덮어씌우기 하면 됨
// localStorage.setItem('name','고길동'); // 수정됨

// 주의사항 문자열만 들어감! 
// 배열 안돼!
// let arr = [1, 2, 3, 4, 5];
// localStorage.setItem('arr', arr);
// let arr2 = localStorage.getItem('arr');
// console.log(arr2, typeof arr2); // 1,2,3,4,5 string, 단순 문자열...

// object 안돼!
// let user = {
//   name : '홍길동',
//   age : 20
// };
// localStorage.setItem('user', user);
// let user2 = localStorage.getItem('user');
// console.log(user2, typeof user2); // [object Object] string 아무 정보도 없음 ㄷㄷ

// // key, value로 이루어진 JSON, 이전에 봤던 직렬화...를 해줘야 함
// localStorage.setItem('user', JSON.stringify(user));
// user2 = localStorage.getItem('user');
// console.log(user2, typeof user2); // {"name":"홍길동","age":20} string, 이단계에서는 user2.name 같은 거 안됨
// user2 = JSON.parse(user2);
// console.log(user2, typeof user2); // {name: '홍길동', age: 20} 'object' 이제 user2.name 가능!

// 드디어 장바구니 작업
// 담기에 onclick 넣어 주기 힘드니까 cart라는 class 추가함

let rowBox = $('.row');
fruits.forEach((fruit) => {
  content = 
  `<div class="col">
    <div class="card" style="width: 18rem;">
      <img src="../../img/${fruit.name}.jpg" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title">${fruit.name}</h5>
        <p class="card-text">${fruit.memo}</p>
        <button class="btn btn-primary cart">담기</button>
      </div>

    </div>
  </div>`;
  rowBox.append(content);
});

// 이벤트리스너
// document.querySelectorAll('.cart')[0].addEventListener('click', function(){
//   alert('hi');
// }); // querySelectorAll 쓰면 반복문 써야 함.
// 그래서 Jquery 문법으로 할 거라심

$('.cart').on('click', function(e){ // .on = .addEvent on은 이벤트가 다 그렇다심 onclick, onfocus 등등, event의 e 이벤트 객체 자동으로 보내짐
  // alert('hi');
  // console.log(e); // E.Event {originalEvent: PointerEvent, type: 'click', target: button.btn.btn-primary.cart, currentTarget: button.btn.btn-primary.cart, isDefaultPrevented: ƒ, …}
  // Target에 버튼 정보가 담겨있음
  // console.log(e.target);
  // 전전 태그를 읽을 수 없는 구린 JS
  // console.log(e.target.previousElementSibling.previousElementSibling.innerHTML); // 메론 클릭하면 melon 출력됨
  // Jquery 문법
  let name = $(e.target).siblings('h5').text(); // 태그 안에 내용만 빼주는 거는 .text()
  // console.log(name);
  // localStorage.setItem('name', name);

  // 장바구니 담기 클릭할 때마다 갯수 늘어나야 함! 숫자 연산
  // localStorage.setItem(name, Number(localStorage.getItem(name))+1);

  // 이렇게 하면 순서가 안 담김 JSON 형태로 작업하시려나봄 ㄷㄷ
  // let item = localStorage.getItem('name');
  // if(item === null)
  //   localStorage.setItem('name', JSON.stringify([name]));
  // else {
  //   item = JSON.parse(item);
  //   item.push(name);
  //   localStorage.setItem('name', JSON.stringify(item));
  // }

  // 흐음... key : fruits, value : [ { 'name' : name, 'cnt' : 1} ] 왜 이렇게 넣으시려는 건지...
  // key가 다른 거와 중복될 수 있어서 그렇게 관리하는 건가.. 한번 더 포장하는 거 같은 느낌
  let temp = JSON.parse(localStorage.getItem('fruits'));
  if(temp === null)
    localStorage.setItem('fruits', JSON.stringify([{'name' : name, 'cnt' : 1}]));
  else {
    // console.log(temp);
    let isHave = false;
    temp.forEach((data, i)=> {
      // console.log(data, i); // i 는 index
      if(data.name === name) {
        isHave = true;
        data.cnt++;
      }
    });
    if(!isHave)
      temp.push({'name' : name, 'cnt' : 1});
    localStorage.setItem('fruits', JSON.stringify(temp));
  }
});

// 장바구니 페이지에 표시
let list = document.querySelector('.list');

// 이건 순서 담긴 거 장바구니에 그대로 표시해준 거
// // list.innerHTML = `${localStorage.getItem('name')}`;
// let item = JSON.parse(localStorage.getItem('name'));
// item.forEach((data)=>$('.list').append(`<div>${data}</div>`));

// 갯수로 표시해주는 거!
// for(let i=0; i<localStorage.length; i++)
//   list.insertAdjacentHTML("beforeend", `<div>${localStorage.key(i)}: ${localStorage.getItem(localStorage.key(i))}</div>`);

let listItems = JSON.parse(localStorage.getItem('fruits'));
listItems.forEach((data)=>list.insertAdjacentHTML("beforeend", `<div>${data.name}: ${data.cnt}</div>`));

