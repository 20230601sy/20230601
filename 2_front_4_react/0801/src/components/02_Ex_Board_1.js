import { useState } from "react";
import './02_Ex_Board_1.css'
import Modal from "./02_Ex_Board_2_Modal";

// const title = 'Hello React!!'; // 변수가 랜더링될 때마다 바뀌어야 할 경우 컴포넌트 안에 있는 게 좋지만 바뀌지 않는 데이터를 보관하는 변수는 처음 랜더링할 때 외에는 코드 한 줄을 읽는 시간을 절약할 수 있으니 전역변수처럼 컴포넌트 바깥에 저장하는 것이 좋음
// 물론 지금 처음부터 최적화를 생각할 필요는 없고 돌아가는 흐름을 정확하게 알아야 최적화가 가능하니... 나중에 최적화 기법도 배울 거라심...

const Board = () => {
  let [title, setTitle] = useState(['Java', 'HTML', 'React']);
  const [like, setLike] = useState(0);
  const [num, setNum] = useState(0);
  const [modal, setModal] = useState(false);

  // JSX에서는 for문이 안됨 forEach처럼 map이라는 것을 쓸 거임 거의 유사한 듯. 반복대상.map(콜백함수); 형태임
  let arr = [1, 2, 3, 4, 5];
  arr.map(()=>console.log('Hi')); // 2번씩 나오는 거는 디버깅, 배포할 때는 삭제한다심 index.html에서 React.StrictMode tag 삭제하면 됨
  arr.map((data)=>console.log(data));
  arr.map((data, index)=>console.log(data, index));
  let arr2 = arr.map((data, i)=>data+i); // return도 가능함~
  console.log('arr2', arr2);
  return (
    <div>
      <div className='black-nav'>
        <h3>게시판</h3>
      </div>
      {/* <h4>게시판 제목 같은 거 넣음</h4> */}
      {/* <h4>{title}</h4> */}
      {/* 변수로 해놓고 얹어주는 걸 (데이터) 바인딩이라고 한다심 */}
      {/* 변수로 해놓고 넣는 거가 조금 더 나을 수도 있는 거는 나중에 코드가 복잡해졌을 때 위치를 찾기가 수월해짐... */}
      {/* 바인딩 되는 거는 어디든 다 된다심 예를 들어 <div className={title}> */}
      <hr></hr>
      <button onClick={() => {
        title[0]= 'JS';
        setTitle([...title]);
      }}>첫번째 제목 변경 버튼</button>
      &nbsp;
      <button onClick={() => {
        setTitle([...title.sort()]);
      }}>오름차순</button>
      &nbsp;
      <button onClick={() => {
        setTitle([...title.reverse()]);
      }}>내림차순</button>
      &nbsp;
      <button onClick={() => {
        title = num%2 ? title.sort() : title.reverse();
        setTitle([...title]);
        setNum(num+1);
      }}>정렬 toggle</button>
      <div className='list'>
        <h4>
          {title[0]}&nbsp;
          <button className="" onClick={() => setLike(like+1)}>👍</button>&nbsp;{like}
        </h4> 
        {/* <h4>{title}</h4> 이러면 JavaHTMLReact 배열 전체 출력됨 */}
        <p>작성일 : 2023-08-01</p>
      </div>
      <div className='list'>
        <h4>{title[1]}</h4>
        <p>작성일 : 2023-08-01</p>
      </div>
      <div className='list' onClick={() => setModal(!modal)}>
        <h4>{title[2]}</h4>
        <p>작성일 : 2023-08-01</p>
      </div>
      {modal ? <Modal title={title} /> : null}
      {/* {
        arr.map(() => {
          return (
            <div>출력</div>
          );
        })
      } */}
    </div>
  );
};

export default Board;