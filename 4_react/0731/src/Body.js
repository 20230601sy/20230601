// 서술 순서상 App.js로 옮김

// import { Fragment } from "react";
// import './Body.css';

// const Body = () => {
//   // 변수 생성은 동일, 그러나 return문 밖에
//   const number = 1;
//   const str1 = 'hello';
//   const str2 = 'react';
//   const str3 = true;
//   const str4 = false;
//   const obj = {
//     name : '홍길동',
//     age : 20
//   };

//   if(obj.age >= 20) {
//     return (
//       <div>
//         <h1>Body영역</h1>
//         <h2>{number + 10 }</h2>
//         {/* { } 중괄호 안에 변수명이나 계산식을 넣어야 계산된 결과가 나옴*/}
//         <h2>{ str1 + str2 }</h2>
//         <h2>{ str3 || str4 }</h2> {/* 아무것도 출력 안됨 */}
//         {/* boolean은 랜더링할 때 화면상에 출력안됨, 굳이보고 싶다면 형변환하면 됨 */}
//         <h2>{ String(str3 || str4) }</h2>
//         {/* 원시데이터는 이런 식으로 다 출력되는데 obj형이나 배열은 그냥 출력은 js처럼 나오는 거 안된다심 */}
//         {/* 정확하게 배열방이나 키값을 넣어서 단일 값만 출력 가능한가봄 */}
//         {/* <h2>{ obj }</h2> */} {/* error */}
//         <h2>{ obj.name }</h2>
  
//         {/* JSX 문법상 닫는 Tag 반드시 있어야 한다심.. HTML 같은 경우는 닫는 태그 없어도... 잘 출력해줬음... */}
//         {/* 최상위 Tag는 반드시 1개만! */}
//         {/* css가 적용되어 div로 묶기 애매한 경우 */}
//         {/* 그래서 아무런 의미없는 Tag <></>를 최상위 태그로 사용하기도 한다심 */}
//         <></>
//         {/* 개발자도구 열어서 보면 <></>는 안 보임 */}
//         {/* 리액트 자체에서 동일한 의미의 컴포넌트 <Fragment></Fragment> 도 있는데, 이거 쓰려면 반드시 import { Fragment } from "react"; 해야 한다심 */}
//         {/* <Fragment></Fragment> 쓸바에야... 그냥 빈태그 쓰는 게 좋지 않냐심... */}
  
//         <h2>
//           {
//             // if(obj.age >= 20)
//             //   '성인'
//             // else
//             //   '청소년'
//             // return 바깥이면 js 쓸 수 있는데, return 안쪽은 if, for 예약어 관련된 것은 못쓴다심 그래서 if는 삼항 연산자 쓴다심, 반복문은 다른 거 쓴다심
//             obj.name + (obj.age >=20 ? '성인' : '청소년')
            
//           }
//         </h2>
//         <h2>{obj.age >=20 ? null : '청소년'}</h2> {/* null을 넣으면 조건에 만족하면 출력 안됨 */}
//         <h2>{obj.age >=20 && '성인'}</h2> {/* 이런 식으로도 쓸 수 있음, JS 특성상 내용이 있으면 true니까... 앞에가 true이면 뒤에 값을 출력해줌 */}
//         {/* 진짜 굳이 if를 쓰고 싶다면 return을 if 경우로 나누어서 작성하면 된다심... */}
//         <div style={ { color : 'blue', fontSize : '30px', backgroundColor : 'skyblue' }}>스타일 직접 설정 시 JSX문법</div>
//         {/* {{}} 중괄호 2개 있어야 하고,, 하이픈(-)을 빼기로 인식하기 때문에 Carmel Case 해서 이름 쓴다고 보면 된다심 font-size 이러면 fontSize 이런 식... */}
//         {/* 보통은 이렇게 직접 지정하지 않고 css 파일 만들어서 쓴다심 */}
//         {/* css 파일 만들기! */}
//         {/* Body.css 파일 import 시켜야 함 import './Body.css'; */}
//         {/* 근데 나머지 Header나 Footer도 다 적용되어 버림 */}
//         {/* 나머지 적용안되게 하는 건 나중에 보고 클래스를 상세하게 지정하는 방식으로 하자심 */}
//         {/* 리액트에서는 클래스 예약어가 따로 있어서 className로 써야 한다심 */}
//         <div className="body">{obj.age >=20 && '성인'}</div>
//       </div>
//     );
//   }
//   else {
//     // return 한줄이면 ()괄호 생략 가능
//     return <div><h2>청소년</h2></div>;
//   }
// };

// export default Body;