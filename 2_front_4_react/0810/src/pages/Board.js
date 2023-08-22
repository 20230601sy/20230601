import { Container } from "react-bootstrap";

const Board = () => {
  return (
    <Container className='Board mt-2'>
      Board

<pre className="text-start">
<br/>
// ====================================================================================================
<br/>
1. 기능 → 페이지 구성<br/>
<br/>
2. 개인 목표<br/>
   -. 전체 구성 잡기 (환경설정/폴더 구성/기본 정보)<br/>
   -. Layout, mobile, Bootstrap 공부<br/>
   -. Kakao Navi Map OpenAPI<br/>
   -. 그래프 그리기<br/>
<br/>
3. 보완점<br/>
   -. 중복 작업<br/>
   -. hook, 생명주기 고려<br/>
   -. 이름 정하기<br/>
<br/>
<br/>
<br/>
// ====================================================================================================
<br/>
1.1 환경 설정<br/>
cd D:\Y\front\4_react\; npx create-react-app 0810; cd 0810;<br/>
npm install react-router-dom@6; npm install axios; npm install @reduxjs/toolkit react-redux; <br/>
npm install -g firebase-tools; firebase init<br/>
npm start<br/>
<br/>
1.2 public 폴더<br/>
favicon.ico, logo192.png, logo512.png, thumbnail.png 교체하기<br/>
index.html title 수정 및 og태그, fontawesome, bootstrap 추가<br/>
<br/>
1.3 src 폴더 관리<br/>
<a href="https://velog.io/@sisofiy626/React-%EB%A6%AC%EC%95%A1%ED%8A%B8%EC%9D%98-%ED%8F%B4%EB%8D%94-%EA%B5%AC%EC%A1%B0">폴더 구조 참고</a><br/>
assets, components, pages, redux, styles, utils 폴더 추가<br/>
src/assets logo.png 파일 추가<br/>
index.js 파일 수정 + route, redux<br/>
app.css 파일 수정<br/>
index.css 파일 수정, font 추가<br/>
<br/>
2. pages, components 파일 기본 .js 생성 + export<br/>
<br/>
3. 기능을 담은 css는 App.css에 넣기, 기능을 의미하는 className 지정<br/>
특정컴포넌트 위치 → Bootstrap 대체<br/>
</pre>
    </Container>
  );
}

export default Board;