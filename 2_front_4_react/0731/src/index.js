import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// import Footer from './Footer';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    {/* App.js에서 만든 것을 컴포넌트(리액트 기본 단위) 일반적인 태그는 소문자, 컴포넌트는 대문자로 시작 (구별을 위한 관례 같은 거라심) */}
    {/* root가 public의 index.html div로 가게 됨 */}
    {/* 라이브러리 작업하지 않는 이상 현재 건들 일 없음 */}
    {/* <Header />, <Header></Header> 그냥 이런 식은 안되나봄 ㄷㄷ */}
    {/* export, import 안 했기 때문이었군... ㄷㄷ */}
    {/* <Footer /> */}
    {/* 자동 불러오기 안 되니까 어째 좀 귀찮은 거 같기도... */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
