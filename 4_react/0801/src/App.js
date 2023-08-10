import logo from './logo.svg';
import './App.css';
import Info from './components/01_Ex_State_1_Info';
// import Board from './components/02_Ex_Board_1';
// import Board from './components/02_Ex_Board_3_loop';
import Board from './components/02_Ex_Board_4_sort_fixed';

function App() {
  return (
    <div className="App">
      {/* ----------------------------------------------------------------------------------------------------
          01_Ex_State
          Info 컴포넌트를 생성
          사람의 정보를 저장하는 state를 생성, state에는 이름, 나이, 성별이 object로 저장
          화면에 입력한 내용이 state에 반영되고 반영된 정보를 출력하도록 구현
          이름 : xxx
          나이 : xxx
          성별 : xxx
          입력은 input, select 태그 활용
          Info에 자식 컴포넌트인 Child 컴포넌트 생성
          Info 컴포넌트의 state를 받아 나이가 홀수인지 짝수인지 출력하도록 구현 그리고 버튼을 클릭할 때마다 나이가 1씩 증가되도록 구현
          Child컴포넌트는 Info 컴포넌트 하단에 출력되도록
        ---------------------------------------------------------------------------------------------------- */}
      <Info/>
      {/* ----------------------------------------------------------------------------------------------------
          게시판 만들기
          데이터 바인딩
          JSX 반복문 map!
        ---------------------------------------------------------------------------------------------------- */}
      <Board />
    </div>
  );
}

export default App;