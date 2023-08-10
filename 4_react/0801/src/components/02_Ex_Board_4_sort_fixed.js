import { useState } from "react";
import './02_Ex_Board_1.css'
import './02_Ex_Board_2_Modal.css';

let mkState = (title, like, date) => {return {title, like, date};};
let compareTo = (a, b) => a.title.localeCompare(b.title);
const Board = () => {
  const [num, setNum] = useState(0);
  const [modal, setModal] = useState([false, 0]);
  let [states, setState] = useState([mkState('Java', 0, '2023-06-01'), mkState('HTML', 0, '2023-07-01'), mkState('React', 0, '2023-08-01')]);
  const [newTitle, setNewTitle] = useState('');
  return (
    <div>
      <div className='black-nav'>
        <h3>게시판</h3>
      </div>
      <hr></hr>
      <button onClick={() => {
        states[0].title = 'JS';
        setState([...states]);
      }}>첫번째 제목 변경 버튼</button>
      &nbsp;
      <button onClick={() => {
        // https://sisiblog.tistory.com/344
        // setState(states.toSorted((a, b) => a.title.localeCompare(b.title)));
        setState(states.toSorted(compareTo));
      }}>오름차순</button>
      &nbsp;
      <button onClick={() => {
        // setState(states.toReversed((a, b) => a.title.localeCompare(b.title)));
        setState(states.toReversed(compareTo));
      }}>내림차순</button>
      &nbsp;
      <button onClick={() => {
        setState(num%2 ? states.toSorted(compareTo) : states.toReversed(compareTo));
        setNum(num+1);
      }}>정렬 toggle</button>
      {
        states.map((data, i) => {
          return (
            <div className='list' onClick={() => {
              modal[0] = modal[1] === i ? !modal[0] : true;
              modal[1] = i;
              setModal([...modal]);
            }} key={i}>
              <h4>
                {data.title}&nbsp;
                <button className="" onClick={(e) => {
                  e.stopPropagation();
                  data.like++;
                  setState([...states]);
                }}>👍</button>&nbsp;{data.like}
              </h4>
              <p>
                작성일 : {data.date}
                &nbsp;&nbsp;
                <button onClick={(e) => {
                  e.stopPropagation();
                  let _title = prompt('수정할 제목을 입력하세요.');
                  if(_title) { // if(_title != null && _title != '') { 를 줄일 수 있음
                    states[i].title = _title;
                    let cdate = new Date();
                    states[i].date = `${cdate.getFullYear()}-${String(cdate.getMonth()+1).padStart(2, 0)}-${String(cdate.getDate()).padStart(2,0)}`;
                    setState([...states]);
                  }
                }}>수정</button>
                &nbsp;&nbsp;
                <button onClick={(e) => {
                  e.stopPropagation();
                  states.splice(i, 1); // 이거 리턴 값이 삭제된 값임! 주의! 삭제하려면 그냥 실행만!
                  setState([...states]); // 해당 states 제외하고 setState 하기~
                  if(modal[1] === i)
                    setModal([false, 0]);
                }}>삭제</button>
              </p>
            </div>
          );
        })
      }
      
      <div style={{marginTop : '10px'}}>
        <input type="text" value={newTitle} onChange={(e) => {
          setNewTitle(e.target.value);
        }}/>
        &nbsp;
        <button onClick={() => {
          // 배열 추가 unshift (0번방 추가하는 함수) 사용하셔서 설명하심
          // let copy = [...title];
          // copy.unshift(newTitle);
          // setTitle(copy);
          if(newTitle !== '') { // 함수의 영역은 if 쓸 수 있음 ㅡ_ㅡ 좋아해야 함 ㅋㅋㅋ
            let cdate = new Date();
            let dateString = `${cdate.getFullYear()}-${String(cdate.getMonth()+1).padStart(2, 0)}-${String(cdate.getDate()).padStart(2,0)}`;
            setState([mkState(newTitle, 0, dateString), ...states]);
            modal[1]++;
            setModal([...modal]);
            setNewTitle('');
          } else {
            alert('제목을 입력하세요');
          }
        }}>등록</button>
      </div>

      {modal[0] ? <Modal states={states} setState={setState} index={modal[1]}/> : null}
    </div>
  );
};

const Modal = ({states, setState, index}) => {
  return (
    <div className="Modal">
      <h4>
        {states[index].title} &nbsp;
        <button onClick={()=> {
          states[index].title = 'JS';
          setState([...states]);
        }}>변경</button>
      </h4>
      <p>작성일 : {states[index].date}</p>
      <p>내용</p>
    </div>
  );
};

export default Board;