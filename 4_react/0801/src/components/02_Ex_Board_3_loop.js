import { useState } from "react";
import './02_Ex_Board_1.css'
import './02_Ex_Board_2_Modal.css';

const Board = () => {
  let [title, setTitle] = useState(['Java', 'HTML', 'React']);
  const [like, setLike] = useState([0, 0, 0]);
  const [num, setNum] = useState(0);
  const [modal, setModal] = useState([false, 0]);
  const [newTitle, setNewTitle] = useState('');

  return (
    <div>
      <div className='black-nav'>
        <h3>게시판</h3>
      </div>
      <hr></hr>
      <button onClick={() => {
        title[0]= 'JS';
        setTitle([...title]);
      }}>첫번째 제목 변경 버튼</button>
      &nbsp;
      <button onClick={() => {
        // setTitle([...title.sort()]);
        setTitle(title.toSorted()); // toSorted는 원본 손실 없이 정렬한 배열 return 해주나봄
      }}>오름차순</button>
      &nbsp;
      <button onClick={() => {
        // setTitle([...title.reverse()]);
        setTitle(title.toReversed()); // toReverse는 원본 손실 없이 내림차순정렬한 배열 return 해주나봄
      }}>내림차순</button>
      &nbsp;
      <button onClick={() => {
        title = num%2 ? title.sort() : title.reverse();
        setTitle([...title]);
        setNum(num+1);
      }}>정렬 toggle</button>
      {/* title로 sort 했을 때 like도 바뀌어야 하는데... */}
      {
        title.map((data, i) => {
          return (
            // <div className='list'> 반복문 이용해서 태그를 생성할 경우 리액트 내부적인 처리해주는 것 때문에 key설정이 필요함, 보통 인덱스로 설정, 안해도 상관 없으나 콘솔에 무수한 warning...
            <div className='list' onClick={() => {
              modal[0] = modal[1] === i ? !modal[0] : true;
              modal[1] = i;
              setModal([...modal]);
            }} key={i}>
            <h4>
              {data}&nbsp;
              <button className="" onClick={(e) => {
                e.stopPropagation(); // modal 창 열리지 않게 하기
                like[i]++;
                setLike([...like]);
              }}>👍</button>&nbsp;{like[i]}
              </h4> 
              <p>작성일 : 2023-08-01</p>
            </div>
          );
        })
      }
      {/* 반복문을 통해서 구현함으로써 title 갯수가 늘어도 코드를 수정할 필요가 없어짐 */}
      <div style={{marginTop : '10px'}}>
        <input type="text" onChange={(e) => {
          setNewTitle(e.target.value);
          console.log(newTitle);
        }}/>
        &nbsp;
        <button onClick={() => {
          setTitle([newTitle, ...title]);
          setLike([0, ...like]);
          modal[1]++;
          setModal([...modal]);
        }}>등록</button>
      </div>
      
      {/* {modal[0] ? <Modal title={title[modal[1]]} /> : null} */}
      {modal[0] ? <Modal title={title} setTitle={setTitle} index={modal[1]}/> : null}
    </div>
  );
};

// const Modal = ({title}) => {
//   return (
//     <div className="Modal">
//       <h4>{title}</h4>
//       <p>작성일</p>
//       <p>내용</p>
//     </div>
//   );
// };
// ㅡ-ㅡ 연습 할겸 변경 버튼 추가... 진짜 추가할 때마다 500원 받아야 함ㅋㅋㅋ
const Modal = ({title, setTitle, index}) => {
  return (
    <div className="Modal">
      <h4>{title[index]}</h4>
      <p>작성일</p>
      <p>내용</p>
      <button onClick={()=> {
        title[index] = 'JS';
        setTitle([...title]);
      }}>변경</button>
    </div>
  );
};

export default Board;