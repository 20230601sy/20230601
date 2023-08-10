// 개발자도구 콘솔에 내용을 출력함
// 일반 유저들은 볼 필요가 없기 때문에 개발 완료된 후 다 삭제한다심
// 개발 중간 중간 확인용
console.log("hello js");

// document는 해당하는 문서 전체를 의미함 그러니까... html 내용으로 출력... 근데 이건 잘 안 쓴다심 당연할 듯
// 태그로 넣는 거지...
document.write("Java Script");

// js 기본 문법
// ; 붙어야 함
// 개발자 관대한 언어
// 역풍으로 타입스크립트가 생겼긴 한데...라심
// ; 빠졌다고 해도 동작을 알아서 보완해서 실행을 시킴...

// "", '' 구분 안 함, 취향차이 알아서 쓸 것

// 변수 선언하는 방법
// let 변수명;
// 상수 제외 모든 선언방법 동일
// 옛날에는 var라는 게 있었는데... 구시대의 유물... 문제가 많아서 사용 안 한다심
let a = 'hello', b=10, c=3.14;
console.log(a);

a = 1232;
// 동적데이터타입 특성을 가진 자바스크립트 언어
// 선언했던 데이터 타입과 다른 데이터이더라도 재대입 가능
console.log(a);

// 상수 선언, 자바에서 final과 동일
// const 상수명
// 자바와 달리 항상 대문자로 쓰지는 않고 임시로 쓸 때는 소문자로 쓰기도 한다심
// 기억하기 힘든 변하지 않는, 특정한 의미가 있는 값을 특정한 값을 저장하고자 할 때 대문자 변수명 사용한다고 이해하라심
// 함수(함수도 자바스크립트에서는 변수로 저장할 수 있다심, html 태그도 변수 안에 넣을 수 있다심) 이런 경우는 소문자로 쓰기도 한다심ㅎ
const MAX = 100;
const aaa = 111;

// 자바스크립트도 자료형은 있다심, 변수 선언할 때 사용하지는 않지만...
// 숫자는 int, double 아니라 number라고 함
let num = 123;
console.log(num/2);
console.log(num/0);
// Infinity도 number형, 숫자를 가지고 계산되다가 나온 값들... 변수 안에 직접 참조도 가능
num = Infinity;
console.log(num);

// 타입이 숫자인데 계산중에 에러가 발생했다는 표시는 NaN으로 함!
console.log("abc"/10); // NaN... 계산에 관련되어 에러를 발생시켜 멈추는 경우는 거의 없다고 보면 됨
// 이렇기 때문에 중간중간 확인하지 않는 이상 문제발생을 찾기가 어렵기도 한다심

// 타입확인하는 건 typeof 쓰면 되는데 이따가 본다심

let str = `abc`; // 백틱 ` 으로도 문자열 인식, 물론 변수 선언할 때는 잘 안 쓰고 표현식! 쓸 때 써짐
let str1 = "abc";
let str2 = 'def';
let str3 = str + str2;
console.log(str3);
// console.log(str + "와 " + str2 +"를 합치면 " + str + str2 + "입니다.");
// `` 안에다가 표현식 ${변수명} 쓰면 변수 내용물을 뽑아낼 수 있다심
// 더하기 생략하려고 ... 번거롭게 ㅋㅋㅋ 그렇지만 가독성은 좀 더 좋은 거 같으니 ...
console.log(`${str}와 ${str2}를 합치면 ${str}${str2}입니다.`);
// 표현식에는 변수 말고 계산식도 들어간다심
// 표현식 작성하려면 무조건 백틱 안에 있어야 한다심
console.log(`${str}와 ${str2}를 합치면 ${str+str2}입니다.`);

let bool = true;
console.log(bool);
// 조건식도 자바처럼 넣을 수 있음
bool = 4 > 1;
console.log(bool);

let s = null;
// 어느 데이터타입에도 속하지 않는 데이터타입... 자료형
// 여기서 null은 자바의 참조하는 객체가 존재하지 않는다의 의미와는 조금 다른데...???라고 하심 뭐가 다르지 ㄷㄷ
// 알 수 없는 값, 비어있는 값으로 생각하면 된다심
let p;
console.log(p);
// 값을 할당시키지 않았을 때 null 값을 출력시키는 게 아니라 undefined로 출력됨 ㄷㄷ
let u = undefined;
// undefined 지정할 수는 있지만 이렇게는 안 한다심.
// 의도적으로 값을 비워놓고 싶을 때 null을 쓰고, 할당시키지 않을 때는 그냥 비워놓는다심
p = p + 10;
console.log(p); // NaN 출력됨

// 문제 발생 시 계산하기 전에 type을 확인해보면 문제 파악 확인하기 용이함... 종종 필요할 수 있다심
console.log(typeof 1); // number, 한칸 띄고 쓸 건지
console.log(typeof(1)); // 괄호 안에 쓸 건지... 매개변수는 값이나 변수 넣으면 됨.
console.log(typeof 3.14); // number
console.log(typeof NaN); // number
console.log(typeof Infinity); // number
console.log(typeof 'a'); // string
console.log(typeof 'str'); // string
console.log(typeof false); // boolean
console.log(typeof bool); // boolean
console.log(typeof null); // object 객체... 까놓고보면 객체는 아니라고 그냥 null로 인식하라심
console.log(typeof undefined); // undefined
// 타입은 이거 외에도 조금 더 있어서... 함수, 배열, object 형 같은 게 있다심

let name = "홍길동";
console.log(`결과 : ${name} * 10`); // 결과 : 홍길동 * 10
console.log(`결과 : ${name * 10}`); // 결과 : NaN
console.log(`결과 : ${'name'}`); // 결과 : name

// 여기까지가 변수랑 자료형들... 자바랑 비슷하죠? 허허... 허허허...

// 알림창 발생시키는 거 2개 더 볼거라심

// alert 처럼 메세지를 띠워주는 게 모달이라고 한다심, 메세지 + 확인 버튼이 끝
// alert("기본 알림창");
// alert(name);

// 입력받게끔 창을 띠워주고 싶을 때
// prompt(안내메세지), prompt(안내메세지, 입력받은 값의 기본값) 
// prompt('내용을 입력');
// prompt('내용을 입력', name);
// prompt에서 사용자가 입력한 값, prompt가 리턴한 값을 변수에 저장해야 완성
// let age = prompt('나이를 입력하세요');
// alert(typeof(age));  // 문자열임
// age = age + 2;  // 30 입력하면 302 출력, + 빼고는 *, -는 다 잘 동작함... 타입이 너무 유연해서 생기는 문제
// 숫자 연산하려면 형변환 함수 Number(인수) 사용 필요!
// age = Number(age) + 2;
// alert(age);
// esc 누르거나 값 입력 안 할 경우 null 리턴됨

// 확인, 취소 선택창
// let isMale = confirm('남자입니까?'); // 확인 누르면 true, 취소 누르면 false
// console.log(typeof isMale); // boolean
// console.log(isMale);

// 안타깝게도 창에 대한 디자인을 수정하지 못하므로 html과 css로 디자인해서 직접 만들기도 한다심
// 귀찮으면 그냥 있는 거 쓰는 거라심 ㄷㄷ
// 모달 창도 예쁘게 만들어둔 것 갖다 쓸 수도 있다심

// 모달창은 실행 시 그 단계에서 멈춤, 중지상태라고 보면 된다심
// 모달창 관련 작업이 끝나지 않으면 스크립트 하부 내용이 처리되지 않음

// 창 뜨는 거 귀찮아서 다 주석처리함

console.log('이제 형변환 시작 ==============================');
// 이제 형변환에 관련된 내용 본다심
// 동일하게 명시적 형변환, 묵시적 형변환 있다심

// 문자로 형변환, 예측한 범위내에서 이뤄지는 거라 어려울 게 없다심
let value = 10;
console.log(typeof value);
value = String(value);
console.log(typeof value);
console.log(value);

value = true;
console.log(typeof value);
value = String(value);
console.log(typeof value);
console.log(value);

value = null;
console.log(typeof value);
value = String(value);
console.log(typeof value); // string
console.log(value); // null 단순 문자열

// 숫자형 변환, 명시하지 않아도 어느 정도 조정하긴 한다심
console.log('a' / 'b'); // NaN
console.log('6' / '2'); // 3 출력됨 ㄷㄷ, 자동형변환, 묵시적 형변환
// 나중에 서버에서 받아오는 데이터, 정확하게는 json... 다 숫자처럼 보이지만 실제로 문자열이기 때문에 형변환 필요한 경우 종종 있다심

let numStr = '123';
num = Number(numStr);
console.log(num, typeof num); // 출력 내용을 + 으로 처리해도 되지만 , 써도 된다심, 123 'number'

let data;
console.log(Number(data), typeof data); // NaN 'undefined'

console.log(bool, Number(bool), typeof bool); // true 1 'boolean'
console.log(false, Number(false), typeof false); // false 0 'boolean'

console.log(null, typeof null, Number(null), typeof Number(null)); // null 'object' 0 'number'

// Number는 일단 앞뒤 trim 시키고 나서 숫자 변환 시도함
console.log(Number('1 2 3')); // NaN
console.log(Number('         123        ')); // 123
console.log(Number('                 ')); // 0

// boolean 형변환
// 0, '', null, undefined, NaN 만 false 나머지는 true라고 생각하면 된다심
console.log(Boolean(1)); // true
console.log(Boolean(123)); // true, 있으면 모두 true
console.log(Boolean(0)); // false
console.log(Boolean(null)); // false
console.log(Boolean(NaN)); // false
console.log(Boolean(undefined)); // false
console.log(Boolean(Infinity)); // true

console.log(Boolean('true')); // true
console.log(Boolean('false')); // true ㅋㅋㅋ tricky 내용물이 있기만 하면 true라는 거
console.log(Boolean('1')); // true
console.log(Boolean('0')); // true, 이건 언어마다 다르다심 어떤 언어는 '0' 문자 0을 false로 인식하기도 한다심 ㄷㄷ 뭐냐 넌 ㅡㅡ
console.log(Boolean(' ')); // true
console.log(Boolean('')); // false

//연산자
console.log('이제 연산자 시작 ==============================');
// +, -, *, /, %
// ** 거듭제곱
console.log(2**3); // 2^3 = 8 출력됨

let a1, b1, c1;
a1 = b1 = c1 = 10 + 5;
// 이렇게 안 쓰긴 하지만 되긴 한다심, 이런 걸 체이닝이라고 한다심
// 아래 순서로 작동된다고 이해하면 되고, 이렇게 쓰면 가독성 떨어지니까 쓰지말라심ㅎ
c1 = 10 + 5;
b1 = c1;
a1 = b1;

// && || !   // 비트연산자 & | ~
// == 자바랑 조금 다르다심, 타입체크 안 하고 똑같이 생겼으면 같다고 함, 요놈! 주의해야 할듯
// == 동등연산자라고 한다심
console.log(123=='123'); // true
console.log(0==false); // true
// 타입까지 체크해서 같은지 확인해주는 거는 일치연산자 === 어지간하면 3개짜리 쓰라심
console.log(123==='123'); // false
console.log(0===false); // false

// 같지 않다도 마찬가지 !=(동등), !==(일치)
console.log(1!=false); // true
console.log(1!==false); // true
console.log(0!=false); // false
console.log(0!==false); // true

// 조건문
// if
let age = '20';
if(age >= 20){
  console.log('성인');
} else if(age >= 10) {
  console.log('청소년');
} else {
  console.log('어린이');
}
// 성인
// else if, else 생략 가능, 한줄일 때 {} 생략 가능 등등 동일

// 삼항연산자도 동일
console.log(age >= 20 ? '어른 요금' : '어린이 요금');

// switch
let num1 = '1';
switch(num1) {
  case 1:
  case 2:
    console.log('num1이 1, 2일 때 실행');
    break;
  default:
    console.log('num1이 1, 2가 아닐 때 실행');
}
// num1이 1, 2가 아닐 때 실행
// switch는 일치연산자, 타입까지 비교, 동일해야 작동됨!
// switch-case indent 규칙 수정해주고 싶고만 ㅡ_ㅡ 많이 안 쓸 거니까 일단 냅두자

// 배운 김에 해보는 예제
// let password = 1234;
// let input = prompt('비밀번호를 입력하세요.');
// if(input === null)
//   alert('로그인 취소');
// else if(input == password) // Number(input) === password 가 낫다심
//   alert('로그인 성공');
// else
//   alert('비밀번호 오류');

// 검사하러 오심 ㄷㄷ
// if(input === '1234')
//   alert('로그인 성공');
// else if(input === null || input==='')
//   alert('로그인 취소');
// else
//   alert('비밀번호 오류');

// 반복문
// 자바랑 동일한데, 변수 선언 let 쓰는 것만 주의하면 될 듯
for(let i=0; i<10; i++)
  console.log(i);

let i=0;
while(i<10)
  console.log(i++);

// 반복문이 조금 더 있긴 한데, 배열이랑 object 한다음 할 거라심

for(let i=0; i<10; i++)
  console.log('hi');
// 이거 콘솔창에서 동일 내용을 반복 출력은 1번 나오고 횟수가 앞에 표시됨

// break, continue도 동일함!

// 이런 것도 있었죠... 허허.
outer:
for(i=0; i<5; i++){
  for(let j=0; j<10; j++){
    if(j===5)
      continue outer;
    console.log(i);
  }
}
// 5번씩 출력

i = 10;
do {
  console.log(i++);
} while (i < 5);

console.log('이제 함수 ==============================');
// 함수 (메서드)
// 자바스크립트에는 클래스라는 개념이 있지만 클래스 내에 함수를 구현하지 않기 때문에 기능은 똑같지만 함수라고 부름
// 함수 선언문
// function 함수이름(매개변수) {
    // 함수 관련 코드들
    // 별도로 리턴타입이 필요하지는 않고 필요하면 리턴 시키기만 하면 됨
    // return xx;
// }

// 변수 영역 설명하심, 클래스 변수, 메서드 변수
let msg = '1';
function showMsg() {
  let msg = '2';
  console.log('JS Function');
  console.log(msg); // 2
  return 1;
}
console.log(msg); // 1
console.log(showMsg());
console.log(msg); // 1

// 매개변수가 있는 함수
function showMsg2(msg) { // msg 매개변수, 타입을 쓸 필요가 없다...
  console.log(msg);
}
showMsg2('이거 보여줘!'); // '이거 보여줘!' 이건 인수라고 한다심

function add(x, y){
  return x + y;
}
console.log(add(10, 5)); // 15
// ----------------------------------------------------------------------------------------------------
// 심심하니까 만드는 예제
// function checkAge(age) {
//   if(age >= 18)
//     return true;
//   else
//     return confirm('보호자 동의가 필요함');
// }

// age = prompt('나이 입력');
// if(checkAge(age))
//   document.write('접속 성공');
// else
//   document.write('접속 실패');
// ----------------------------------------------------------------------------------------------------
// 심심하니까 만드는 예제 2
// 값 두 개를 매개변수로 받아서 더 작은 숫자를 반환해주는 min함수 구현
console.log(`함수 호이스팅 테스트 : ${min(5, 10)}`);

function min (x, y) {
  return x < y ? x : y;
}
console.log(`예제2 test : ${min(5, 10)}`);
console.log(`예제2 test : ${min(10, 5)}`);
console.log(`예제2 test : ${min('5', '10')}`); // '10'
console.log(`예제2 test : ${min('1', '05')}`); // '05' 사전순인감?ㅎ
// ----------------------------------------------------------------------------------------------------
// 함수선언문 function fn() {} 선언문으로 선언한 함수는 선언문 위에 호출해도 잘 동작함. 자바스크립트에서 우선순위로 함수선언문을 먼저 읽고 시작하기 때문
// 함수 표현식 let fn = function() { 작업할 내용 };
// 표현식은 자바의 람다식처럼 화살표함수로 쓴다심 이따가 할 거라심
// fn(); // 에러 발생됨!, 함수 표현식은 먼저 호출되면 에러를 발생시킴
let fn = function() {
  console.log('함수 표현식');
};
fn();

// 함수 호이스팅
// 호이스팅 : 코드를 선언과 할당을 분리시켜서 선언을 최상위로 올리는 것
// console.log(num2); // undefined로 뜸 ㄷㄷ, var로 선언되지 않고 let으로 선언하면 에러 발생됨
// var num2 = 10;
// 위 두 줄의 flow는 정확히 var num2; console.log(num2); num2 = 10; 이 되는 거...
// ----------------------------------------------------------------------------------------------------
// 콜백 함수 매개변수가 함수인 함수, 원래 함수를 호출하자마자 실행되어야 하는데 나중에 실행된다는 개념이라심... MATLAB에서도 잘 썼...
function ask(question, yes, no) {
  if(confirm(question))
    yes();
  else
    no();
}

function showOk() { // 보통은 이름을 동일하게 쓴다심 yes()...
  alert('확인버튼 누름');
}

function showCancel(){
  alert('취소버튼 누름');
}

// ask('컨펌창 띄움', showOk, showCancel); // 여기서 콜백함수가 showOk, showCancel이라심...
// ----------------------------------------------------------------------------------------------------
function buy(item, price, ea, callback){
  console.log(`${item}을 ${ea}개 가짐`);
  console.log('계산중임');
  setTimeout(function() {
    let total = price*ea;
    callback(total);
  }, 1000);
  // setTimeout(콜백함수, 시간 msec) 자바 sleep과 동일한 거, 지정된 일정 시간 뒤에 콜백함수 실행, 지금은 익명함수가 들어가 있는 상태, 이런 식으로 자주 쓰게 될 거라심 
  // 쓰레드처럼 실행되나봄..
}

function pay(n) {
  console.log(`총 금액 ${n}원`);
}

// buy('갤23울트라', 1500000, 5, pay);
// ----------------------------------------------------------------------------------------------------
// 즉시 실행 함수 : 익명함수처럼 만든다음 바로 실행시켜버림
(function() {
  console.log('일회성 실행 함수');
})();
// 이런 게 초기화 같은 거 넣어주는 것도 할 수 있다심
// 콜백이나 이런 거는 나중에 비동기 처리, 이벤트 같은 거 걸어줄 때 많이 볼 거라심 ㄷㄷ
// 언제 선언문 쓰고 표현식 쓰는지 정리, 보통은 선언문 선호 하고 보통 선언문을 위에 주르륵 넣어놓고 시작한다심

// 조건에 따라 함수를 다르게 만들고 싶을 때도 있겠지...
age = 10;

if(age < 18) {
  function showHi() {
    console.log('안녕');
  }
} else {
  function showHi() {
    console.log('안녕하십니까');
  }
}
showHi();
// 원칙상으로는 함수를 영역 안에 선언한 거기 때문에 에러를 발생시키는 게 맞는데,,,
// use strict 변경 모드?? 타입스크립트 처럼 엄격한 언어에서는...blah 근데 여기서는 적용 안되는 듯

// 아무튼 이럴 때 보통 표현식을 쓰고, 가독성은 선언문이 훨씬 좋다심
let showHi2;
if(age < 18) {
  showHi2 = function() {
    console.log('안녕');
  }
} else {
  showHi2 = function() {
    console.log('안녕하십니까');
  }
}
showHi2();
// ----------------------------------------------------------------------------------------------------
// 화살표 함수 ( 람다식 ) 화살표 모양이 다르다심 '=>'로 쓴다심, 자바는 '->' 였...지ㅎ
// 화살표 함수는 선언문으로 쓰기 힘들기 때문에 표현식으로 쓴다심
let sum = function(x, y) {
  return x + y;
};

let sum2 = (x, y) => x + y; // 자바에서 생략가능했던 거는 다 동일하게 생략가능한가봄
console.log(sum2(5, 10));

let sum3 = x => x + 10;
console.log(sum3(5));

let showHello = () => { // 콜백함수 쓸 때 활용도, 편의성이 높아짐... 많이 쓰게 될 거라심.. // function 철자 너무 길어 ㅡㅡㅋ
  console.log('hello');
  console.log('hello');
  console.log('hello');
};
showHello();
// ----------------------------------------------------------------------------------------------------
// 배열, 사이즈 선언할 필요 없나봄
let arr = [1, 2, 3, 4];
console.log(arr);
console.log(arr[1]);
// 동일 자료형일 필요 없이 다 들어감
arr = [1, 'asd', true];
// for(i=0; i<arr.length; i++)
//   console.log(arr[i], typeof arr[i]);

arr[3] = '새로 추가';

arr.push('맨 뒤에 추가');
console.log(arr);

arr.unshift('맨 앞에 추가');
console.log(arr);

console.log(arr.pop()); // 맨 뒤에 거 삭제되고 삭제된 값 리턴시켜줌
console.log(arr);

console.log(arr.shift()); // 맨 앞에 거 삭제되고 삭제된 값 리턴시켜줌
console.log(arr);

console.log(arr.splice(2, 3)); // 2번방부터 3개 삭제, 갯수 모자라면 모자란대로 처리하나봄
console.log(arr);

// forEach 스트림 람다식처럼 화살표 함수 넣어줌
arr.forEach(data => console.log(data));

// 향상된 for문은 조금 다른 듯 주의!
for(let data in arr) // : 가 아니라 in을 쓰면 key값 가져온다심
  console.log(arr[data]);

for(let data of arr) // of를 쓰면 value값 가져온다심
  console.log(data);
// 그래도 보통은 forEach를 많이 쓴다심
// ----------------------------------------------------------------------------------------------------
// Object
// 자료형이 object 자바의 클래스 같은 게 아니라 자바의 컬렉션 map과 유사한가봄
let user = {
  name : '홍길동', // key : value
  age : 30,
  'nick name' : '별명', // key에 띄어쓰기 쓰고 싶으면 '' 따옴표 안에 넣을 것
  arr : [1, 2, 3, 4, 5], // 배열 넣을 수 있고...
  showHi : function(){ // 함수도 넣을 수 있다심
    console.log('hi');
  },
  showBye() { // 조금 줄여서 만들자면...
    console.log('bye');
  }
};
// 배열 안에도 object 넣을 수 있음
arr = [ 1, 2, {name:'aaa', age:20}];
console.log(user);
console.log(user.name); // 홍길동
console.log(user["nick name"]); // 띄어쓰기가 있으면 . 을 못 씀. 애초에 key에 띄어쓰기 쓰지 말라심ㅎㅎ
console.log(user["name"]);
user.showBye();
const user2 = {
  name : '홍길동',
  age : 30
};

user2.name = 'aaa'; // 이거 aaa로 바뀜, 상수의 개념이 조금 달라서 {name:'', age:} 형태가 안 바뀌는 게 const 개념이라고 이해하는 게 좋다심...
// 자료형에 추가는 어떻게 하지? 걍 없는 거 잡아서 넣으면 추가됨
user2.gender = 'female'; // 요런식
// ----------------------------------------------------------------------------------------------------
// let fruit = prompt('과일 입력하셈');

// let cart = {
//   [fruit] : 5 // key 값을 유동적으로 입력가능함
// };

// console.log(cart[fruit]);
// ----------------------------------------------------------------------------------------------------
function makePerson(name, age) { // object를 벽돌처럼 찍어내는 함수 ㄷㄷ
  return {
    // name : name,
    // age : age
    // 키랑 매개변수 이름이 같으면 생략 가능
    name,
    age
  };
}

let p1 = makePerson('고길동', 40);
console.log(p1);
// 실제로 서버에서 받아서 작업한다고 치면...
let persons = [];
for(let i=0; i<10; i++)
  persons.push(makePerson('사람' + i, i + 10));
console.log(persons);
console.log(persons[1].name);

for(let key in p1)
  console.log(key, p1[key]);
for(let value of persons)
  console.log(value);
persons.forEach((k, v) => console.log(k, v));

// 키가 숫자, 숫자형 문자열인 경우는 자동으로 정렬해서 출력됨, 해당 형태가 아닌 경우 들어간 순서대로 출력됨
let codes = {
  '44' : 'a',
  '1' : 'b',
  '22' : 'c'
}
console.log(codes); // {1: 'b', 22: 'c', 44: 'a'}

// object에 함수 추가
p1.showHi = () => {
  console.log('hi');
};
console.log(p1);
p1.showHi();

function showHi3() {
  console.log('hi3');
}
p1.showHi = showHi3; // 함수선언문으로 만든 것도 그냥 넣을 수 있음, 넣을 때 괄호 같은 거 없는 거 유의
console.log(p1);
p1.showHi();

let player = {
  name : '홍길동',
  showHi : function(){
    console.log('hi');
  },
  showBye() {
    console.log(this.name + ' bye'); // 자기자신에서 참조하고 싶을 때 자바와 동일하게 this 사용, this 대신 player.name도 쓸 수 있지만 선호되는 방식은 아니라심
  }
};
player.showBye();

// this가 아닌 직접 player 쓰는 거 선호 안 하는 이유...
let p3 = player;
player = null;
p3.showBye(); // 이러면 player.name으로 썼을 때는 에러 뜸, this로 뜨면 잘 동작함. this를 쓰는 게 확실한 방법

// 이런 flow도 가능
let a2 = {
  name : 'aa'
};
function fname() {
  console.log(this.name);  
}
a2.f = fname;
a2.f();
// ----------------------------------------------------------------------------------------------------
// 예제
// read() : prompt 창을 띄워서 값을 두개 입력받음
// sum() : 입력받은 두 값의 합계를 반환
// mul() : 입력받은 두 값의 곱을 반환
let calc = {
  // 작업하시면 됨
  // num1 : 0,
  // num2 : 0, // 초기화 안 시켜도 되긴 하지만... 뭐 굳이 같은 느낌도 있긴 하지. 암튼 강사님은 함수만 구현하는 걸로 설명하심ㅎ
  read() {
    this.num1 = Number(prompt('첫번째 숫자를 입력하세요'));
    this.num2 = +prompt('두번째 숫자를 입력하세요'); // Number 안 쓰고 산술연산을 강제로 시키는 꼼수 알려주심ㅎㅎ 숫자 특성상되는 거...앞에 +는 부호
  },
  sum() {
    return this.num1 + this.num2;
  },
  mul() {
    return this.num1 * this.num2;
  }
};

calc.read();
console.log( `sum 결과 출력 : ${calc.sum()}` );
console.log( `mul 결과 출력 : ${calc.mul()}` );
// 몇개 남은 개념 더하고... HTML, CSS 조절하는 거 이제 직접 할 거라심