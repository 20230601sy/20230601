// index.js
// {/* App.js에서 만든 것을 컴포넌트(리액트 기본 단위) 일반적인 태그는 소문자, 컴포넌트는 대문자로 시작 (구별을 위한 관례 같은 거라심) */}
// {/* root가 public의 index.html div로 가게 됨 */}
// {/* 라이브러리 작업하지 않는 이상 현재 건들 일 없음 */}
// gitignore
// README.md
// App.css 여러 가지 작업이 들어있어서 모두 주석처리함
// 터미널 창에 npm start 누르면 라이브서버처럼 포트 할당돼서 자동으로 열림

import logo from './logo.svg';
import './App.css'; 
// css는 java처럼 import함
// build하게 되면 App.js만 적용되는 게 아니라 
// 한쪽에만 지정되게 처리를 하거나 클래스명을 상세하게 하거나 둘 중 하나라심
// import Body from './Body';
import Footer from './Footer'; // import Footer from './Footer.js' .js는 일반적으로 생략한다심
// 정확하게는 import Aa from './Footer'; 라고 하고 <Aa />라고 해도 됨
// 그래도 이상하니까 보통은 이름 동일하게 쓰신다심ㅎㅎ
// import는 직접 입력할 일이 없이 파일 만들어두고 export 잘 해놓으면
// 내부에서 컴포넌트 자동완성으로 넣으면 import 자동으로 입력된다심

import { Fragment, useState } from "react";
import './Body.css';

const AAA = 'test';
// 컴포넌트( component )
// 컴포넌트 이름은 대문자로 만듦
// function 컴포넌트이름 () { return ( JSX ); }
// 또는 표현식으로 const 컴포넌트이름 = () => { return ( JSX ); };
// 함수 이름 
// 원래는 컴포넌트 안에 컴포넌트 만들지 않음
// 하나의 파일 안에 1개의 컴포넌트만 만든다심
// 지금은 귀찮으니까...
function Header() {
  return (
    // return 안에는 
    // 작업할 HTML 코드 (JSX문법)
    // 알고 있는 HTML 태그 써서 하면 됨
    <header>
      <h1>Header영역</h1>
      <hr></hr> {/* HTML에서는 <hr> 썼는데 여기는 닫는 tag 없으면 error 발생됨 */}
    </header>
    // <div>aaa</div> // 형제노드 들어가면 안됨 JSX문법상 return에는 하나의 태그 트리 구조여야 함
  ); // return 괄호는 소괄호()임, 중괄호 아님 주의!
}

// 선언문 형태, 좀더 자주 쓰게 될 형태...
const Header1 = () => {
  return (
    <header>
      <h1>Header</h1>
    </header>
  );
};

// HTML에서 div로 쪼개던 거를 작업단위별로 컴포넌트로 나눠서 작업하게 될 거라심
// 너무 원자단위로 세밀하게 쪼개면 힘들어지니 적당하게 작업단위별로 하는 게 좋다심
function App() {
  const name = '고길동';
  const age = 20;
  const person = {
    name, age
  };

  const clickEvent = () => {
    alert('app 함수');
  };

  console.log('부모컴포너트임, state 변경되어도 재랜더링되지 않음');

  return (
    <div className="App">
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
        Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
        className="App-link"
        href="https://reactjs.org"
        target="_blank"
        rel="noopener noreferrer"
        >
        Learn React
        </a>
      </header> */}

      {/* <Header></Header>  */}
      {/* 우리가 만든 컴포넌트를 화면에 출력하게 하려면 태그 쓰듯이 하면 되는데 대문자로 시작하기 때문에 컴포넌트임을 추정할 수 있음 */}
      {/* return안에는 무조건 닫는 tag가 있어야 한다심 */}
      <Header />
      {/* 열고 닫고 한 번에 하는 걸 줄여서 위에 <Header />처럼 씀, 컴포넌트 불러올 때는 사이에 뭘 넣을 일은 없으므로... */}
      {/* 이제 이렇게 하면 부모 컴포넌트는 App, 자식 컴포넌트는 Header */}
      <h1>hello react</h1>
      {/* 이렇게 하면 내부적으로 리액트가 랜더링(화면을 만드는 과정)을 자동으로 구축하는 것 */}
      {/* footer는 새 파일 만들어서 해보신다심
          componet, page 폴더 관리 하는데 지금은 또 그냥 하시겠다심... ㅋㅋㅋ
          Footer.js, F 대문자, 파일 생성 */}
      <Footer />
      {/* 옛날에는 컴포넌트를 클래스형으로 만들었다심 16버전까지... 16.8버전부터 함수형 컴포넌트로 만든다심 지금은 다 함수형... */}
      
      <Body />
      {/* JSX - Java Script XML */}
      {/* HTML과 js */}
      {/* 파일 형식은 .js이지만 js 문법을 모두 다 쓸 수 있는 것은 아니라심... 대표적으로 if 같은 게 안 된다심 */}
      {/* body component에 작업 좀 하면서 보자심... */}

      {/* Props */}
      <Props name={name} age={age} person={person}/>
      {/* Props, property의 약자, 컴포넌트에 값을 전달할 때 사용하는 오브젝트라심 */}
      {/* Body.js에서 생성한 obj를 사용하게 하고 싶을 경우 */}
      {/* 리액트 데이터 흐름이 단방향, Props로 값을 전달할 때도 한 방향으로만 전달 가능 */}
      {/* 부모컴포넌트 - 자식컴포넌트 */}
      {/* 쉬운 예로 App.js App - Header 에서 본다심 */}
      {/* <Header 보낼 이름 = 보낼 값/>  */}
      {/* <Header aa={name}/>  */}
      {/* <Header name={name} age={age} person={person}/>  */}
      {/* 기본적으로 컴포넌트끼리 변수 공유 안됨, 리덕스 같은 거 공부하면 공유해서 쓸 수는 있긴 하다심 */}
      {/* 보낼 컴포넌트 태그 속성에 작업 */}
      {/* ex) Header 컴포넌트에 값을 보낸다고 가정 */}
      {/* <Header 보낼이름 = 보낼값 /> */}
      {/* 값을 받는 Header 컴포넌트 */}
      {/* const Header = (props) => {
        props.받은 이름
      } */}
      {/* 혹은 function Header(props) {} 형태로 쓰면 된다심 */}
      {/* { 보낼이름key : 보낼값value} 오브젝트 형태로 묶어서 보낸다고 하심*/}
      {/* 여러 개 보내고 싶으면 컴포넌트이름 뒤에 쭉 이어서 쓰면 됨 <Header name={name} age={age}/> */}
      {/* 보내고 싶은 거 다 보낼 수 있다심, 배열, obj, 나중에 배울 state?? 등등 다 보낼 수 있다심 */}
      {/* props로 compoent로 보낼 수 있는데 그거는 태그 안에 들어가는 건 아니고... 시작태그와 종료태그 사이에 넣는데 그건 나중에 다시 보여준다심 잘 안 쓰기도 하고 나중에 다시 보여준다심 */}
      {/* <Header>
        <Body /> ????????????
      </Header> */}
      <Props2 name={name} age={age} person={person}/>
      {/* Props를 보낼 수 있는 방향 단방향이라는 의미가...무조건 부모 컴포넌트에 있는 것을 자식 컴포넌트에만 보낼 수 있음 */}
      {/* 기본적으로 다른 도움없이는 자식에서 부모도 안되고, 손자도 바로도 안됨 이건 2단계 거쳐야 하고... 당연히 형제들끼리도 주고 받을 수도 없음 */}
      {/* 그래서 어디서 변수 작업을 할 것인지 잘 정하는 것도 하나의 기술적인 설계인가봄... */}
      {/* function Props2({name, age, person, number}) */}
      {/* 안 보낸 값을 undefined가 아닌 기본 값 설정도 가능하다심 */}
      {/* 컴포넌트 바깥쪽 영역에 따로 작업해야 한다심, 설정 위치 참조 */}
      {/* Props2.defaultProps = { number : 100 }; */}

      {/* Event */}
      <Event clickEvent={clickEvent}/>
      {/* 이벤트 걸어주는 것은 js랑 별다를 게 없다심.. */}
      {/* document 뭐 이런 거 안 해도 되는 것 정도... */}

      {/* State */}
      {/* React Hook → React에 내장되어 있는 함수 같은 거라고 하심, 뭔가를 간편하게 해주는 기능이 있는 것. use로 시작한다심 useXXXX */}
      {/* 정적인 데이터로는 일반 변수 사용하듯이 const나 let을 사용해서 구현하면 되는데... */}
      {/* 리액트는 데이터가 변하면 랜더링이 자동으로 실행되는데 그때는 동적인 데이터, 리액트 훅 중 하나인 state 형태로 해주어야 함 */}
      <State /> 
      {/* 버튼을 클릭해도 내부적으로 값 바뀌지만 새로고침(랜더링)이 안됨 */}
      <TestState />
      {/* useState(리액트의 훅 중 하나)를 사용하여 State 변수 생성 */}
      <TestState2 />
      {/* State를 배열이나 obj형태로 생성하게 될 경우 달라지는 점이 있다심... */}
      {/* Info 컴포넌트를 생성
          사람의 정보를 저장하는 state를 생성, state에는 이름, 나이, 성별이 object로 저장
          화면에 입력한 내용이 state에 반영되고 반영된 정보를 출력하도록 구현
          이름 : xxx
          나이 : xxx
          성별 : xxx
          입력은 input, select 태그 활용
          Info에 자식 컴포넌트인 ChildInfo 컴포넌트 생성
          Info 컴포넌트의 state를 받아 나이가 홀수인지 짝수인지 출력하도록 구현 그리고 버튼을 클릭할 때마다 나이가 1씩 증가되도록 구현
          ChildInfo컴포넌트는 Info 컴포넌트 하단에 출력되도록
        */}
      <Info/>
    </div>
  );
}

// JSX 문법 설명
const Body = () => {
  // 변수 생성은 동일, 그러나 return문 밖에
  const number = 1;
  const str1 = 'hello';
  const str2 = 'react';
  const str3 = true;
  const str4 = false;
  const obj = {
    name : '홍길동',
    age : 20
  };

  if(obj.age >= 20) {
    return (
      <div>
        <h1>Body영역</h1>
        <h2>{number + 10 }</h2>
        {/* { } 중괄호 안에 변수명이나 계산식을 넣어야 계산된 결과가 나옴*/}
        <h2>{ str1 + str2 }</h2>
        <h2>{ str3 || str4 }</h2> {/* 아무것도 출력 안됨 */}
        {/* boolean은 랜더링할 때 화면상에 출력안됨, 굳이보고 싶다면 형변환하면 됨 */}
        <h2>{ String(str3 || str4) }</h2>
        {/* 원시데이터는 이런 식으로 다 출력되는데 obj형이나 배열은 그냥 출력은 js처럼 나오는 거 안된다심 */}
        {/* 정확하게 배열방이나 키값을 넣어서 단일값만 출력 가능한가봄 toString처럼 나오는 거 정말 편했는데ㅠ 애쉽ㅠ */}
        {/* <h2>{ obj }</h2> */} {/* error */}
        <h2>{ obj.name }</h2>
  
        {/* JSX 문법상 닫는 Tag 반드시 있어야 한다심.. HTML 같은 경우는 닫는 태그 없어도... 잘 출력해줬음... 집에 가서 확인해보라심ㅋㅋㅋ */}
        {/* 최상위 Tag는 반드시 1개만! */}
        {/* css가 적용되어 div로 묶기 애매한 경우 */}
        {/* 그래서 아무런 의미없는 Tag <></>를 최상위 태그로 사용하기도 한다심 */}
        <></>
        {/* 개발자도구 열어서 보면 <></>는 Elements에도 안 보임 */}
        {/* 리액트 자체에서 동일한 의미의 컴포넌트 <Fragment></Fragment> 도 있는데, 이거 쓰려면 반드시 import { Fragment } from "react"; 해야 한다심 */}
        {/* <Fragment></Fragment> 쓸바에야... 그냥 빈태그 쓰는 게 좋지 않냐심... */}
  
        <h2>
          {
            // if(obj.age >= 20)
            //   '성인'
            // else
            //   '청소년'
            // return 바깥이면 js 쓸 수 있는데, return 안쪽은 if, for 예약어 관련된 것은 못쓴다심 그래서 if는 삼항 연산자 쓴다심, 반복문은 다른 거 쓴다심
            obj.name + (obj.age >=20 ? '성인' : '청소년')
            
          }
        </h2>
        <h2>{obj.age >=20 ? null : '청소년'}</h2> {/* null을 넣으면 조건에 만족하면 출력 안됨 */}
        <h2>{obj.age >=20 && '성인'}</h2> {/* 이런 식으로도 쓸 수 있음, JS 특성상 내용이 있으면 true니까... 앞에가 true이면 뒤에 값을 출력해줌 */}
        {/* 진짜 굳이 if를 쓰고 싶다면 return을 if 경우로 나누어서 작성하면 된다심... */}
        <div style={ { color : 'blue', fontSize : '30px', backgroundColor : 'skyblue' }}>스타일 직접 설정 시 JSX문법</div>
        {/* {{}} 중괄호 2개 있어야 하고,, 하이픈(-)을 빼기로 인식하기 때문에 Carmel Case 해서 이름 쓴다고 보면 된다심 font-size 이러면 fontSize 이런 식... */}
        {/* 보통은 이렇게 직접 지정하지 않고 css 파일 만들어서 쓴다심 */}
        {/* css 파일 만들기! */}
        {/* Body.css 파일 import 시켜야 함 import './Body.css'; */}
        {/* 근데 나머지 Header나 Footer도 다 적용되어 버림 */}
        {/* 나머지 적용안되게 하는 건 나중에 보고 클래스를 상세하게 지정하는 방식으로 하자심 */}
        {/* 리액트에서는 클래스 예약어가 따로 있어서 className로 써야 한다심 */}
        <div className="body">{obj.age >=20 && '성인'}</div>
      </div>
    );
  }
  else {
    // return 한줄이면 ()괄호 생략 가능
    return <div><h2>청소년</h2></div>;
  }
};

function Props(props) {
  console.log(props);
  console.log(props.name);
  const name = props.name;
  // 자주 쓰게 될 경우 변수에 저장해두거나...destructuring 문법 활용하는 방법이 있음 → Props2
  return (
    <div>
      <h4>{'Props'}</h4>
      <h4>{props.name + ' : ' + props.age}</h4>
      <h4>{`${props.name} : ${props.age}`}</h4>
      <h4>{props.person.name + ' : ' + props.person.age}</h4>
    </div>
  );
}

// name={name} age={age} person={person}
function Props2({name, age, person, number}) {
  // JS destructuring 문법 활용 (리액트가 아니라 애초에 js에서 쓸 수 있는 거라심)
  // let [a, b] = [10, 20];
  // 이게 a = 10, b = 20, 구조 분해 할당
  // {...props}
  // 이게 더 많이 쓰는 방식이라심
  // 이러면 props. 매번 안 써도 되고 어떤 거 받아올지 명시적으로 보여주니까 코드 이해하기도 편하다심
  // 구조 분해 할당 key 이름은 동일하게 해야 함! 없는 값을 가져오려면 undefined 뜸 주의!
  // 구조 분해 할당 시 괄호는 쪼갤 대상의 구조에 맞게 배열일 때는 [] 대괄호, obj형태일 때는 {} 중괄호로 써야 함!
  // 같은 방식으로 obj인 person도 쪼갤 수 있음
  const {pName, pAge} = person;
  return (
    <div>
      <h4>{'Props2'}</h4>
      <h4>{name + ' : ' + age}</h4>
      <h4>{person.name + ' : ' + person.age}</h4>
      <h4>{'기본값 출력 확인 : ' + number}</h4>
    </div>
  );
}

Props2.defaultProps = {
  number : 100
};

// function Event() {
// function Event(props) {
function Event({clickEvent}) {
  const clickHandler = () => {
    alert('버튼2 클릭 이벤트');
  };

  const clickHandler2 = (e) => {
    alert(e.target.innerText);
  };

  // const clickHandler3 = (e) => {
  //   // 전역변수 test 해봄...
  //   alert(AAA);
  // };

  return (
    <div>
      <button onClick={()=>{
        alert('버튼 클릭 이벤트');
      }}>버튼</button>

      {/* 자주 사용하는...재사용할 것 같은 핸들러는 함수로 만드는 것이 편하다심 */}
      <button onClick={clickHandler}>버튼2</button>

      {/* 당연한 얘기지만 이벤트 객체 사용 가능 */}
      <button onClick={clickHandler2}>버튼2-2</button>
      
      {/* 별도로 전역변수 테스트해봄, 출력은 잘 됨...이렇게는 잘 안 쓰는지... 데이터흐름 형식에 맞지 않을지도... */}
      {/* <button onClick={clickHandler3}>버튼2-3</button> */}

      {/* props로 함수도 전달 가능하니까!!! App에서 만든 함수도 실행 가능함~~~ */}
      {/* <button onClick={props.clickEvent}>App에서 만든 함수 실행</button> */}
      <button onClick={clickEvent}>App에서 만든 함수 실행</button>
    </div>
    // HTML은 대소문자 구분 안 했지만, 여기 JSX에서는 대소문자를 철저히 지켜야 한다심 onClick만 됨 onclick 안됨!
  );
}

function State() {
  let number = 10;
  return(
    <div>
      <button onClick={()=>{
        console.log({number});
        number += 10;
      }}>{number}</button>
    </div>
  );
}

const TestState = () => {
  // const [변수명, state변경함수명] = useState(초기값);
  // const 변수명 = 초기값; 변수명 = 바꿀 거; 이런 식으로 하면 리액트가 변수가 값이 바뀌었는지 인식하지 못함
  // useState(초기값) 을 실행한 결과는 [초기값, 함수]의 배열로 나옴... 변수명 = 초기값, 변경
  // 변경함수는 set변수명으로 관례처럼 작명한다심...
  // 자동완성 기능 사용해야 import { useState } from "react"; 자동 import됨
  const [number, setNumber ] = useState(0); // const로 해도 number 값 변경되는 거 재설명하심... const가 구조변경이 안된다는 의미로 쓰이는 거... 이전에 함 설명해주셨음.
  console.log(number); // 2번 출력되는 이유는 변경된 컴포넌트를 인지하는 순간 랜더링을 다시하기 때문에 2번 출력되는 것임
  // 변경된 컴포넌트와 자식 컴포넌트만 랜더링함(최적화할 때 그런 걸 제외시키거나 그런 거 해야 할 수도 있다심) 상관없는 컴포넌트는 랜더링 안함 (마운트 얘기가 여기 였던가 아무튼 훅 마운트 랜더링 얘기 언급하신 적 있는디... 메모 누락된 듯...)
  // console 찍는 거 여러군데 넣어보면 알 것임...
  // 일반변수, HTML은 동적인 것 못함. 하려면 JS를 썼지...
  // 헷갈리거나 모르겠으면 걍 State로 만들어서 쓰라심
  return (
    <div>
      <h1>state 확인 컴포넌트 : <span>{number}</span></h1>
      <button onClick={()=>{
        // number++; // state 변수는 일반변수처럼 연산처리하면 에러 발생됨
        // setNumber(10); // 여러번 클릭하면 1번 이후에는 console 출력이 안되넹ㅎ 0 0/10 10/10 10 출력 후에는 아무리 클릭해도 출력되지 않음 신기하당ㅎ
        setNumber(number+10);
      }}>number 증가</button>
      {/* 자식 컴포넌트는 재랜더링됨 부모 컴포넌트는 재랜더링되지 않음 */}
      {/* <Child /> */}
      {/* 클릭할 때마다 콘솔에 자식컴포너트임, 재랜더링 출력됨 */}
      <Child number={number} setNumber={setNumber}/>
      {/* State도 props로 보낼 수 있음 */}
    </div>
  );
}

// const Child = ()=>{
const Child = ({number, setNumber})=>{
  console.log('자식컴포너트임, 부모컴포넌트의 state가 변경될 때마다 재랜더링됨');
  return (
    <div>
      <p>자식컴포넌트 : {number}</p>
      <button onClick={()=>{
        setNumber(number-1);
      }}>number 감소</button>
    </div>
  );
}

const TestState2 = () => {
  const [text, setText ] = useState('');

  const [text2, setText2 ] = useState('');
  const changeHandler = (e)=>{
    setText2(e.target.value);
  };

  const [name, setName ] = useState('고길동');
  const [gender, setGender ] = useState('남자');
  const [birth, setBirth ] = useState('1960-01-01');
  const [info, setInfo ] = useState('둘리 이놈!');

  const changeName = (e) => setName(e.target.value);
  const changeGender = (e) => setGender(e.target.value);
  const changeBirth = (e) => setBirth(e.target.value);
  const changeInfo = (e) => setInfo(e.target.value);

  const [person, setPerson ] = useState({
    name : '홍길동',
    gender : '남자',
    birth : '2023-07-01',
    info : '하아아암'
  });

  const changePerson = (e) => {
    console.log(e.target.name, e.target.value);
    person[e.target.name] = e.target.value; // 내용이 바뀐다고 person이 바뀌었다고 인식하지 못함, 주소값이 변경되어야 변경되었다고 인식해서 랜더링함
    // let copy = person; // 이런다고 새로운 주소값을 가지지 않음... 그냥 주소값을 복사하게 됨...
    // let copy = {...person}; // 이럴 때 이걸 쓰는 거임!!!!! 오오.
    // setPerson(copy);
    setPerson({...person});

    // 위에 두 줄을 줄이면...도 같은 거... obj key가 중복되지 않고, 마지막 값을 반영된다는 특성을 이용한 거ㅎ
    // setPerson({
    //   ...person,
    //   [e.target.name] : e.target.value
    // });
  };
  console.log(person);

  return (
    <div>
      <h1>state 연습용 컴포넌트</h1>
      {/* <input type='text' onChange={(e)=>{ */}
      <input type='date' onChange={(e)=>{
        // console.log(e.target.value);
        setText(e.target.value);
        console.log(text);
      }}/>
      <h3>{text}</h3>

      {/* 콤보상자 */}
      <select onChange={changeHandler}>
        <option>1번</option>
        <option>2번</option>
        <option>3번</option>
      </select>
      <h3>{text2}</h3>

      <hr></hr>
      <input type='text' onChange={changeName}></input> <br />
      <select onChange={changeGender}>
        <option>남자</option>
        <option>여자</option>
      </select> <br />
      <input type='date' onChange={changeBirth}></input> <br />
      <textarea onChange={changeInfo}></textarea> <br />
      <h3>{`${name}(${gender}, ${birth}) : ${info}`}</h3>

      <hr></hr>
      <input name='name' type='text' onChange={changePerson}></input> <br />
      <select name='gender' onChange={changePerson}>
        <option>남자</option>
        <option>여자</option>
      </select> <br />
      <input name='birth' type='date' onChange={changePerson}></input> <br />
      <textarea name='info' onChange={changePerson}></textarea> <br />
      <h3>{`${person.name}(${person.gender}, ${person.birth}) : ${person.info}`}</h3>
    </div>
  );
}

const Info = () => {
  const [state, setState] = useState({
    name : 'xxx',
    age : 0,
    gender : '남자'
  });
  const changeState = (e) => {
    setState({...state, [e.target.name] : e.target.value})
  };

  return (
    <>
      <hr></hr>
      <h1>Info Ex</h1>
      <hr></hr>
      <input name='name' type='text' onChange={changeState} style={{marginRight : '10px'}}/>
      <input name='age' type='number' onChange={changeState} style={{marginRight : '10px'}}/>
      <select name='gender' onChange={changeState}>
        <option>남자</option>
        <option>여자</option>
      </select>
      <h1>{`${state.name} (${state.gender}, ${state.age})`}</h1>
      <ChildInfo state={state} setState={setState}/>
    </>
  );
};

const ChildInfo = ({state, setState}) => {
  return (
    <div>
      <h1>{`나이는 ${(state.age%2)? '홀수':'짝수'}`}</h1>
      <button onClick={(e)=>{
        state.age = Number(state.age) + 1;
        setState({...state});
        // console.log(e.target.parentElement.previousSibling.previousSibling.previousSibling);
        // 뭐야 이게 ㅋㅋㅋ document 안 써도 되는 거 알려주셔야 함...
        e.target.parentElement.previousSibling.previousSibling.previousSibling.value = state.age;
        // e.target.
      }}>나이 증가</button>
    </div>
  );
};


export default App;
// export default Header; // 이거를 두 개 하지 못하기 때문에 하나씩 만드나봄