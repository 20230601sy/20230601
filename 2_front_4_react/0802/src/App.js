import './App.css';
// import Button from 'react-bootstrap/Button';
import data from './mockData';
import { memo, Suspense, lazy, useEffect, useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/02_Header';
import Main from './components/03_Main';
// import Detail from './components/04_Detail';
// import About from './components/05_About';
// import { styled } from 'styled-components';
import axios from 'axios';
// import Cart from './components/07_Cart';
import RemoteItems from './components/08_RemoteItems';
import WatchedProduct from './components/09_WatchedProduct';
const URL = 'https://raw.githubusercontent.com/Naessss/study/main/fruit.json';
// const Btn = styled.button`
//   background : ${props => props.background};
//   color : ${props => props.background === 'skyblue' ? 'blue' : 'black'};
//   border : 1px solid blue;
//   cursor : pointer;
//   margin : 10px;
// `
// const NewBtn = styled(Btn)`
//   width : 200px;
// `

const Detail = lazy(() => import('./components/04_Detail'));
const About = lazy(() => import('./components/05_About'));
const Cart = lazy(() => import('./components/07_Cart'));
// 페이지에 갔을 때 다운 받게 하는 작업해줘야 함...
// import { Suspense } from 'react';
// <Suspense fallback={<div>로딩중</div>}></Suspense> 로 감싸주는 거 해줘야 함...

// 불필요한 랜더링 제거
// import { memo } from "react";
// 메모이제이션 테스트
const Test = memo(() => {
  console.log('test 컴포넌트');
  return (
    <div>메모이제이션 테스트중</div>
  );
})
// memo로 감싸면 되는데
// 이거랑 기능은 비슷한데 useMemo 라는 훅도 있다심
// 작동 방식은 다르다심..
// 오래걸리는 작업을 매번 랜더링할 때마다 호출을 하면 시간이 오래 걸리니까...
// eg. 계산을 하는 함수가 5초가 걸리는데,,, 한번 계산해두면 변경은 안된다고 가정을 하면...
// 또 Cart 가서 fibo 함수 만드심 ㅋㅋㅋ
// 실행은 랜더링하면서 실행됨, useEffect랑 실행 순서가 차이 있음

function App() {
  const [fruits, setFruits] = useState(data);
  // const [fruits, setFruits] = useState();
  // const [items, setItems] = useState([]);
  // const [items, setItems] = useState({});
  // const [items, setItems] = useState({fruit : 'apple', num : 1 });
  
  useEffect(()=>{
    axios.get(URL)
      .then((result)=>{
        setFruits(result.data);
      })
      .catch((error)=>{
        console.log(error);
      })
  }, [])

  useEffect(()=>{
    localStorage.setItem('watched', JSON.stringify([]));
  }, [])

  return (
    <div className="App">
      {/* ----------------------------------------------------------------------------------------------------
          과일가게 쇼핑몰 만들기
          SPA 개념 본다심
          https://naessss.github.io/ 더보기 등등
          링크 클릭했을 때 페이지 새로 고침 없이 바로바로 넘어가짐
          레이아웃 부트스트랩으로 하셨다심
          그냥 부트스트랩이랑 리액트 부트스트랩은 다름
          컴포넌트로 이뤄져야 함 그래서 설치해야 한다심
          해당 폴더에 npm install react-bootstrap bootstrap 터미널 입력해서 설치
          https://react-bootstrap.netlify.app/docs/getting-started/introduction
          설치만 된 거지 index.css에 import는 해야지 쓸 수 있음...
          똑같은 거지만 뭔가가 귀찮아서 index.html에 link로 하는 걸로 하신다심
          <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
            crossorigin="anonymous"
          />
          컴포넌트 가져다 쓸 때에는 import 해야 하는데 자동완성할 때 react-bootstrap 가져다 쓰게끔 해야 함
          import Button from 'react-bootstrap/Button';
          <Button variant="secondary">Secondary</Button>{' '}
          variant가 props임 전송해서 이거 구현해달라고 하는 거라심...
        ---------------------------------------------------------------------------------------------------- */}
      {/* <Component /> */}
      {/* <Button variant="secondary">Secondary</Button>{' '} */}
      {/* <Navbar bg="dark" data-bs-theme="dark"> */}
        {/* <Container> */}
          {/* <Navbar.Brand href={`/`}>Navbar</Navbar.Brand> */}
          {/* <Nav className="me-auto"> */}
            {/* <Nav.Link href={`/`}>Home</Nav.Link> */}
            {/* <Nav.Link href={`/detail`}>detail</Nav.Link> */}
            {/* <Nav.Link href={`/cart`}>cart</Nav.Link> */}
            {/* href를 쓰면 reload하기 때문에 route를 쓰는 의미가 없어짐... Link 쓰면 import 해야 함 import { Link } from 'react-router-dom'; */}
            {/* reloading 된다는 의미는 관련 html, css, js를 다운받는다는 의미이기 때문에 매번 다운받아야 하는 거는... 어제 함 해주신 얘기 */}
            {/* 이렇게 했을 때의 장점은 한 번 들어간다음 인터넷이 끊겼을 때... 사실 애초에 인터넷이 끊기면... 들어가기 어렵... 퍽퍽ㅋㅋㅋ */}
            {/* <Link to='/'>메인페이지</Link> */}
            {/* <Link to='/detail'>메인페이지</Link> */}
          {/* </Nav> */}
        {/* </Container> */}
      {/* </Navbar> */}
      {/* 결국 뒤늦게 컴포넌트 분리작업 하심 ㅡ_ㅡ */}
      <Header />

      {/* <div className='main-bg'></div> */}
      {/* <div className='main-bg' style={{backgroundImage:'url(./images/bg.jpg)'}}></div> 난 왜 되징?ㅠㅋ 뭔가 버전이 다른가 ㄷㄷ */}
      {/* img를 import 해서 사용, import bg from './images/bg.jpg'; */}
      {/* <div className='main-bg' style={{backgroundImage: `url(${bg}`}}></div> */}
      {/* <img src={bg} /> 이런 거도 된다는 거... */}

      {/* 아래 코드는 그냥 부트스트랩 쓰는 거... className으로 지정해서 한 거 */}
      {/* 반응형으로 구현되어 있어서 브라우저 사이즈에 따라서 보이는 것이 달라짐ㅎ */}
      {/* <div className="container mt-4"> */}
        {/* <div className="row"> */}
          {/* <div className="col-md-4"> */}
            {/* <img src='images/apple.jpg' style={{width : '90%'}} /> */}
            {/* img는 안 바뀔 예정이면 public 폴더에 넣는 것이 권장되는데, 그것은 개발 완료 후 배포 전 빌드할 때 src 같은 거는 압축을 하는데 public 폴더는 압축을 안 하기 때문이라심 */}
            {/* public 폴더에 있는 img는 그냥 경로를 편하게 쓸 수 있지만 나중에 배포할 때 문제가 생길 수 있어서 권장은 안 한다심 */}
            {/* shopping.com/detail 등 기본 shopping.com 경로 외에도 사용할 수 있기 때문에 배포했을 때 화면에 안 나오기 때문에... */}
            {/* react에서도 권장안한다는 것이 문서에도 나와 있다심... 어딘가라면서 못 찾으심... */}
            {/* https://create-react-app.dev/docs/using-the-public-folder/ 찾아주심ㅋㅋㅋ  */}
            {/* <link rel="icon" href="%PUBLIC_URL%/favicon.ico" /> */}
            {/* <img src={process.env.PUBLIC_URL + '/img/logo.png'} /> */}
            {/* public 폴더의 img를 불러 올 때는 꼭 process.env.PUBLIC_URL + 이걸 붙여줘야 함을 기억할 것! */}
            {/* <img src={process.env.PUBLIC_URL + 'images/' + fruit[0].title + '.jpg'} style={{width : '90%'}} /> */}
            {/* <h4>{fruit[0].title}</h4> */}
            {/* <p>{fruit[0].price}</p> */}
          {/* </div> */}
          {/* <div className="col-md-4"> */}
            {/* <img src={process.env.PUBLIC_URL + 'images/strawberry.jpg'} style={{width : '90%'}} /> */}
            {/* <h4>strawberry</h4> */}
            {/* <p>10000</p> */}
          {/* </div> */}
          {/* <div className="col-md-4"> */}
            {/* <img src={process.env.PUBLIC_URL + 'images/watermelon.jpg'} style={{width : '90%'}} /> */}
            {/* <h4>watermelon</h4> */}
            {/* <p>20000</p> */}
          {/* </div> */}
          {/* 지금은 data가 없어서 임시데이터를 만들어서 할 거라심 보통은 서버에서 받아오지만... */}
          {/* 이런 임시데이터를 mock이라고 한다심 mockData.js 생성한 후 import함 */}
          {/* 상품 3개 set 컴포넌트화 시킴 */}
          {/* <Card fruits={fruits} setFruits={setFruits}/> */}
          {/* 다들 map을 card.js에 해서 ... App.js에서 반복시키시겠다고 하심ㅡㅡ */}
          {/* { fruits.map( (fruit, i) => <Card fruit={fruit} key={i}/> ) } */}
          {/* {
            fruits.map((fruit, i) => {
              return (
                <Card fruit={fruit} key={i}/> // key라는 속성값을 가지고 리액트가 랜더링을 결정함
              );
            })
          } */}

      {/* ----------------------------------------------------------------------------------------------------
          이제 페이지 만들 거라심
          라우팅
          라우터를 사용할 건데 이건 직접 구현하기 힘드니 라이브러리를 가져다 쓸 거라심
          페이지이동이 된 것처럼 느껴지는 거는 실제로는 컴포넌트를 교체하는 형태
          url로 페이지 분리하는 거를 리액트 라우터를 가져다 쓴다심
          react router dom
          https://reactrouter.com/en/main
          이전 버전 걸로 설치할 수 있으니 터미널에 npm install react-router-dom@6 치고 설치하라심 @6은 6버전이라는 의미
          셋팅
          index.js 에
          import { BrowserRouter } from 'react-router-dom'
          <BrowserRouter>
            <App />
          </BrowserRouter>
          잘 셋팅 되었는지 확인
        ---------------------------------------------------------------------------------------------------- */}
        <Suspense fallback={<div>로딩중</div>}>
          <Routes>
            {/* 페이지 설정할 것을 넣는 공간 */}
            {/* <Route path='/' element={<div>메인페이지</div>}/> */}
            {/* path는 page url '/'는 기본 url, element는 해당 페이지에 보여줄 내용 입력 */}
            {/* <Route path='/detail' element={<div>상세페이지</div>}/> */}
            {/* <Route path='/aaa/bbb' element={<div>이런 것도 됨</div>}/> */}

            <Route path='/' element={
              // 위에 있던 내용 여기로 이동해옴 (상세페이지에는 안 보이게 하고 싶으므로....)
              // <>
              //   <div className='main-bg' style={{backgroundImage: `url(${bg}`}}></div>
              //   <div className="container mt-4">
              //     <div className="row">
              //       { fruits.map( (fruit, i) => <Card fruit={fruit} key={i}/> ) }
              //     </div>
              //   </div>
              // </>
              // 결국 뒤늦게 컴포넌트 분리작업 하심 ㅡ_ㅡ
              // Route 작업 하는 것은 pages 폴더에 만든다심 지금은 그냥 한다심...
              <Main fruits={fruits}/>
            }/>
            {/* <Route path='/about' element={<About />}/> */}
            {/* 하위 페이지 만들기 */}
            <Route path='/about' element={<About />}>
              {/* 하위 페이지는 /about까지는 안 써도 됨 */}
              <Route path='introduce' element={<div>회사소개</div>}/>
              <Route path='history' element={<div>연혁</div>}/>
              <Route path='location' element={<div>오시는 길</div>}/>
              {/* 여기까지만 설정하면 element를 어디에 넣을 건지 설정해줘야 함... 아니면 부모라우트 내용만 보임 */}
              {/* About.js에 Outlet Component 넣어줘야 함 */}
              {/* import { Outlet } from "react-router-dom"; */}
              {/* <Outlet /> */}
            </Route>

            {/* <Route path='/detail' element={<div>상세페이지</div>}/> */}
            {/* <Route path='/detail' element={<Detail />}/> */}
            {/* path 경로는 소문자로... 대문자 잘 안 쓴다심 */}
            {/* <Route path='/detail' element={<Detail fruit={fruits[0]}/>}> */}
            {/* <Route path='/detail' element={<Detail fruits={fruits}/>}> */}
            {/* <Route path='/detail/:id' element={<Detail fruits={fruits}/>}/> */}
            {/* <Route path='/detail/:id' element={<Detail fruits={fruits} items={items} setItems={setItems}/>}/> */}
            <Route path='/detail/:id' element={<Detail fruits={fruits} />}/>
            {/* url에 정보를 더 담을 수 있는데 그 방법이... */}
            {/* URL 파라미터 */}
            {/* 쿼리스트링 */}
            {/* 쿼리스트링은 날씨 OpenAPI할 때 했지 ?뒤에 있는 거 */}
            {/* 이번에는 URL 파라미터를 붙여서 보낼 거라심 */}
            {/* https://naessss.github.io/detail/0 */}
            {/* id라고 굳이 정한 이유는 mockData에 key로 id를 심어놨기 때문임... */}

            {/* 없는 페이지 404 페이지 생성은 페이지 다 만들고 제일 끝에 넣어줘야 함 */}
            {/* path에 *를 했다는 것은 위에 있는 페이지를 제외한 모든 페이지... */}
            {/* 뒤로가기 버튼 만들어 준다든지 setTimeout 활용하면 자동 뒤로가기하게 해준다든지 같은 친절함은... 나중에... */}
            {/* <Route path='/cart' element={<Cart items={items} setItems={setItems}/>}/> */}
            <Route path='/cart' element={<Cart />}/>
            <Route path='*' element={<div>404 Page Not Found</div>}/>
          </Routes>
        </Suspense>
      {/* ----------------------------------------------------------------------------------------------------
          https://styled-components.com/
          CSS-in-JS 라이브러리
          이걸 계속이나 주로 쓰지는 않을 거지만 JS에 바로 CSS를 넣는 가장 많이 쓰는 라이브러리라심
          이 라이브러리를 쓰면 
          css가 적용된 컴포넌트를 만든다고 보면 되고, .css 파일이 필요 없다는 거임...
          import { styled } from 'styled-components';
          형식
          const 컴포넌트이름 = styled.태그명`
            css 속성 설정
          `
          위에 const Btn 해놓았음... 사용하려면 그냥 component 사용하듯이 쓰면 됨...
          <Btn background='skyblue'>CSS-in-JS 스타일이 적용된 버튼</Btn>
          .css 가 관리하기 힘들어서 만들어진건데 그걸 다시 합친다는 게 아이러니 하기도 함...
          componet에 css를 넣을 수 있는 것과...
          App.css 처럼 다른 파일에 적용을 받지 않게 할 수 있다는 것이 약간 장점...
          그리고 이렇게 하면 페이지로딩 속도가 더 빨라진다심
          태그에 직접 속성 넣어서 처리하기 때문에 임의의 class="sc-eDvSBu frcMJN" 같이... 넣어주면서 빨라짐
          그리고 이것도 props 전송 가능함 어차피 변수에 저장된 거니까...
          다른 파일로 만들려고 하면... export 해야 함
          export const Btn = styled.button`
            background : ${props => props.background}; // 이런 식으로 props 사용
            color : ${props => props.background === 'skyblue' ? 'blue' : 'black'}; // 나름 언어이므로 프로그래밍도 가능함! 이거 안 할 거면 걍 css 파일 만들어서 쓰라심ㅋㅋㅋ
            border : 1px solid blue;
            cursor : pointer;
            margin : 10px;
          `
          혹은 export {Btn}
          프레임워크 내가 만들어둔 범위 내에서 알아서 쓰세요. 라이브러리 내가 이렇게 만들어뒀으니 이렇게 쓰세요. 요런 식??
          styled 이거 재사용 가능하다심
          const NewBtn = styled(Btn)`
            width : 100px; // 기존 Btn 속성 다 상속 받은 다음 추가할 속성 지정
          `
          <NewBtn>NewBtn</NewBtn>
          App.css를 styled-components 쓰기는 싫고 다른 파일에 적용하기 싫고 해당 컴포넌트에만 적용하게 하려면
          파일이름을 App.module.css로 만들면 됨...
          프론트 쪽 구인은 라이브러리를 써본 사람 등등...이라 라이브러리를 많이 써보는 걸 권장한다심
        ---------------------------------------------------------------------------------------------------- */}
      {/* <Btn background='skyblue'>CSS-in-JS 스타일이 적용된 버튼</Btn> */}
      {/* <NewBtn>NewBtn</NewBtn> */}
      {/* ----------------------------------------------------------------------------------------------------
        *컴포넌트의 생명주기 (Life Cycle)
        컴포넌트 만들면 태어나고... 자라고... 죽어요... 갑분ㅠㅠ
        태어나는 걸?ㅋㅋㅋ 생성하는 걸 mount 한다고 한다심
        재랜더링 update
        쓸모가 없는 거... 삭제되는 건 delete...가 아니라! unmount라고 한다심
        내부적으로 계속 이렇게 돌아간다심
        코드를 썼다고 해서 만들어지는 게 아니라
        랜더링 됐을 때 나타났을 때 mount된 거임...
        지금 만든 root 페이지 딱 접속했을 때 Header, Main
        /about으로 넘어간 순간 Main은 unmount 된 거임
        내부적으로 state가 있으면 값이 변경되었을 때 update 된 거임
        생명주기를 알고 있으면 중간중간에 뭔가를 낑겨넣을 수 있는데...
        예를 들어 mount되면 xxxx해주세요라든지 update되면 xxxx해주세요라든지 unmount되면 xxxx해주세요 같은거
        그래서 언제 mount, unmount, update 되는지 정확히 파악하고 그 중간에 해야 할 것들 지정할 수 있음...
        update될 때 하고 싶은 거는 component 안에 넣어주면 되는데... unmount됐을 때라든지 재mount시켰을 때도 실행하고 싶은 경우에는 코드에 작성하긴 어려움...
        그래서 또 useEffect라는 리액트 훅이 필요하다심. Detail 에서 작업해보겠다심
        useEffect(콜백함수); mount됐을 때나 update될때마다 매번 콜백함수 실행됨
        import { useEffect } from "react"; import 해야 함
      ---------------------------------------------------------------------------------------------------- */}

      {/* ----------------------------------------------------------------------------------------------------
        이제 서버에 데이터를 주고 받는 거 할 거라심
        js 할 때 서버 통신 3가지 했었음
        1. 옛날부터 쓰던 역사와 전통의 고전 방식 XMLhttpRequest
        2. 버전 업방식 fetch
        3. jQuery 방식 ajax (명령어가 ajax라서 그냥 ajax라고 쓴 건데...)
        애초에 1, 2, 3은 모두 ajax 방식이라고 함
        Ajax : 페이지 새로 고침 없이 데이터를 주고 받는 방식
        따지고 보면 jQuery도 라이브러리...
        리액트에서는 axios 라이브러리를 쓴다심
        fetch에서 json 변환 과정이 빠지니 그게 편한...

        front 단 / backend 단 / DB 단
        F가 B에게 과일 데이터 요청
        B에는 데이터를 가지고 있지 않음
        B가 DB에 접근하여 데이터 가져옴, 실제는 데이터를 가져오는 코드들이 구현되어 있는 거임
        F에게 전달

        axios library 설치
        터미널 창에서 npm install axios
        사용 형식
        get 요청 axios.get() post 요청은 axios.post()...
        axios.get(요청URL)
              .then((response) => {
                응답받은 데이터 처리
        })
              .catch((error) => {
                에러 시 처리할 코드
        })
        보통은 처음 접속했을 때 한다심
        import axios from 'axios';
      ---------------------------------------------------------------------------------------------------- */}
      {/* <button className="btn btn-dark m-2" onClick={() => {
        axios.get('https://raw.githubusercontent.com/Naessss/study/main/fru.json')
          .then((result)=>{
            console.log(result);
            console.log(result.data);
          })
          .catch((error)=>{
            console.log(error);
          })
      }}>서버요청</button>

      <button className="btn btn-danger m-2" onClick={() => {
        fetch('https://raw.githubusercontent.com/Naessss/study/main/fru.json')
          .then((response) => {
            return response.json();
          })
          .then((result) => {
            console.log(result);
          })
          .catch((error)=>{
            console.log(error);
          })
      }}>fetch요청</button> */}
      {/* <div style={{textAlign:'center'}}>
        <button className="btn btn-secondary m-2" onClick={() => {
          axios.get('https://raw.githubusercontent.com/Naessss/study/main/fru.json')
            .then((result)=>{
              setFruits([...fruits, ...result.data]);
            })
            .catch((error)=>{
              console.log(error);
            })
        }}>더보기</button>
      </div> */}
      {/* ----------------------------------------------------------------------------------------------------
          장바구니 구현
          redux tool kit 이용할 거라심
          장바구니에 저장시키는 기능 구현은 Detail에 있어야 하니...
          최소한 Detail 컴포넌트에 장바구니 저장 state 필요한데...
          Cart에서는 장바구니에 저장된 목록을 표시할 것이기 때문에
          여러 component에서 state를 사용하고 싶을 때...
          리액트 기본 기능에도 있지만 redux 라이브러리를 사용한다심
          이렇게 만든 거를 store에 저장하고 여기 저기 부모 자식 관계에 상관 없이 사용하는 거...
          규모가 큰 회사에서는 redux 요건 포함된다고 봄..
          모든 state를 다 redux에 때려넣는다심
          npm install @reduxjs/toolkit react-redux
          셋팅
          redux 관련 폴더 - store.js 파일 생성 (파일명을 보통 store로 하는 것도 관례라심)
          import { configureStore } from "@reduxjs/toolkit"
          export default configureStore({
            reducer : {
              // 작업은 여기에...
            }
          })
          index.js에서...
          import { Provider } from 'react-redux';
          import store from './redux/store';
          <Provider store={store}>
            <BrowserRouter>
              <App />
            </BrowserRouter>
          </Provider>
          리덕스 사용하면 장점
          state를 component 관계에 상관 없이 접근 가능
          state 값에 대한 문제 확인 됐을 때, 함수를 store에서 확인하면 되므로 보수 측면에서도 유리하다심
          useState로 생성한 state와 달리 구조분해할당...및 setState 같은 거 할 필요 없이 해당 값만 업데이트하면 되니까... 주소값 변경할 필요가 없어서 편함
          *주의해야 할 점은 원시데이터는 직접적으로 바꿀 수 없으므로 원시데이터도 일부러 obj 형태로 저장하기도 한다심... 이게 여러 모로 편할 듯
          slice가 여러 개이면 관리가 어려우니...
          여러 파일로 만들기도 하는데 그거는 slice 폴더를 가지고 관리, 내부 생성한 다음
          store.js에 몽땅 불러와서 관리하는 거라심
          infoSlice.js ...
          데이터만 가져옴 함수는 안가져옴 관련해서 export 빼먹지 말고 해야 하고
          store.js에는 configureStore에 해당 slice를 추가해야 함
        ---------------------------------------------------------------------------------------------------- */}
      <RemoteItems fruits={fruits}/>
      {/* <WatchedProduct /> */}
    </div>
  );
}

export default App;