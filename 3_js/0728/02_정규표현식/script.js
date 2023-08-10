/* 정규 표현식 regular expression
  정규식
  모든 언어에 해당하는 내용임
  주로 자바스크립트 파이썬이 많이 쓰는 데 아무튼
  아이디는 세글자 이상일 때만 등록가능하게 한다든지 같은 거
  /3글자만 입력받는 정규식/
  내가 만든 틀로만 입력가능하게 하는 거
  틀이 정규표현식
  
  정규식에 해당하는지 확인해주는 메서드가 있다심
  전화번호 000-0000-0000
  /전화번호형식 정규식/
  이것저것 많아서...
*/

// const regex = /정규식/; 
const regex = /\d{3}-\d{4}-\d{3}/;

let phone1 = '010-1234-5678';
let phone2 = '02-123-4567';

let result = regex.test(phone1); // 정규식에 맞냐 아니냐는 test 함수를 사용
console.log(result);
console.log(regex.test(phone2));

// \d 정수 숫자하나 {3} 3자리

if(regex.test(phone2)){
  console.log('올바른 번호');
} else {
  console.log('전화번호 형식이 일치하지 않습니다.');
}

// 이런 거를 이벤트리스너에 넣어주는 거... change event 설정
const phone = document.querySelector('.phone');
phone.addEventListener('keyup', (e)=>{
  if(regex.test(e.target.value)) {
    console.log('올바른 번호');
  } else {
    console.log('전화번호 형식이 일치하지 않습니다.');
  }
});

// 정규식 객체처럼 선언하는 다양한 방식
const regex1 = /정규식/; 
const regex2 = new RegExp('정규식');
const regex3 = new RegExp(/정규식/);
//  /정규식/플래그 까지 쓸 수 있는데 플래그는 옵션 같은 거 설정 걸어주는 거임

// 정규식 관련 함수
// 문자열.match(정규식) : 문자열에서 정규식에 해당하는 항목들을 배열로 리턴 (뭉태기), 플래그 g를 붙여야 다 나옴...
// 문자열.replace(정규식, 대체문자열) : 문자열에서 정규식에 해당하는 문자를 대체문자열로 교체
// 문자열.split(정규식) : 문자열에서 정규식에 해당하는 항목을 쪼개서 배열로 리턴 (match와 거의 유사한데 다른 점은 한글자한글자 쪼개서 리턴한다심)
// 정규식.test(문자열) : 문자열이 정규식에 해당하면 true, 아니면 false 리턴
// 정규식.exec(문자열) : match랑 동일함(단, 첫번째 항목만 리턴시킴)
// 주로 test를 쓰고 그외에는 match 정도 쓴다심...

const regex4 = /abc/;
let text = '가나다 abc 123 베베베 abc';
console.log('match', text.match(regex4));
console.log('replace', text.replace(regex4, 'bcd'));
console.log('split', text.split(regex4));
console.log('test', regex4.test(text));
console.log('exec', regex4.exec(text));
const regex5 = /abc/g;
console.log('match', text.match(regex5));
console.log('replace', text.replace(regex5, 'bcd'));

// flag 정규식에 해당하는 옵션
// g : 전역검색 (해당하는 모든 텍스트를 검색) 공백이 있는 문자열이면 전역검색을 붙이는 게 좋다심
// i : 대소문자 구별 안함
const regex6 = /abc/ig; // 플래그는 옵션이라 여러개 붙여쓸 수 있다심
// m : 문자열의 행이 바뀌어도 계속 처리함
// u : 유니코드 지원

// 정규식을 구성하는 각종 기호들
// 입력한 그대로를 걸러주는 것
// 알파벳 : 알파벳
// a-z : a부터 z까지
// A-Z : A부터 Z까지
// ㄱ-ㅎ
// 가-힣
// 0-9

// \d : 숫자
// \D : 숫자 아닌 거
// \w : 알파벳, 숫자, 밑줄
// \W : w 아닌 거
// \s : 공백(space)
// \S : s 아닌 거
// \특수문자 eg \/, \* \^, \[ 정규식에 사용되는 기호 앞에는 \를 붙여서 쓴다고 보면 된다심

// | : or 역할을 함, 쓸 때는 정규식1 | 정규식2 : 정규식 1을 만족하거나 정규식 2를 만족하면 true 뭐 요런 식
// [정규식1정규식2] 이런 식으로 쓰기도 한다심 보통 이렇게 쓰는 걸로 봤던 듯
// [^문자] : 해당 문자 제외, 제외시키는 것은 무조건 [] 괄호 안에 있어야 한다심
// ^문자 : 해당 문자로 시작
// 문자$ : 해당 문자로 끝나는
// ? : 없거나 한개만 (eg. /abc?/ 이면 abc이거나 abcd, abce abc0 abc* 등등) 한글자를 담을 수 있는 만능문자라고 생각하면 된다심...
// * : 없거나 있거나.. 있을 때 글자수 제한 없이 ( /abc*/ ) abcadfafeafwdsafalgae 이런 것도 된다는 거라심
// + : 최소 1개 무조건 1개는 있어야 함 /abc+/이면 abc는 포함 안됨
// {n} : n개
// {n, m} : n~m개 // 범위지정도 가능함

// https://regexr.com/ 정규식을 연습할 수 있는 페이지
// [a-z]
// [0-9] 
// [^0-9]
// [^a-z]
// [a-zA-Z0-9]
// [\s]
// [\w]
// community patterns에 가서 복붙해서 쓰면 된다심ㅋㅋㅋ