import './App.css';
import { Route, Routes } from 'react-router-dom';
// import { getEmotionImgById } from './utilities/util';
import Home from './pages/Home';
import Diary from './pages/Diary';
import Edit from './pages/Edit';
import New from './pages/New';
import { createContext, useEffect, useReducer, useRef, useState } from 'react';

const mockData = [
  {
    id : 'm1',
    // date : new Date().getTime(),
    date : 1691476236804,
    content : '임시데이터 1',
    emotionId : 1
  },
  {
    id : 'm2',
    // date : new Date().getTime(),
    date : 1691476236805,
    content : '임시데이터 2',
    emotionId : 2
  },
  {
    id : 'm3',
    // date : new Date().getTime(),
    date : 1691476236806,
    content : '임시데이터 3',
    emotionId : 4
  }
];

{/* ----------------------------------------------------------------------------------------------------
    리액트 내장 리덕스 사용
  ---------------------------------------------------------------------------------------------------- */}
function reducer(state, action) {
  switch(action.type) {
    case 'CREATE':
      // return [action.data, ...state];
      const createState = [action.data, ...state];
      localStorage.setItem('diary', JSON.stringify(createState));
      return createState;
    case 'UPDATE':
      // return state.map(data => String(data.id) === String(action.data.id) ? {...action.data} : data);
      const updateState = state.map(data => String(data.id) === String(action.data.id) ? {...action.data} : data);
      localStorage.setItem('diary', JSON.stringify(updateState));
      return updateState;
    case 'DELETE':
      // return state.filter(data => String(data.id) !== String(action.targetId));
      const deleteState = state.filter(data => String(data.id) !== String(action.targetId));
      localStorage.setItem('diary', JSON.stringify(deleteState));
      return deleteState;
    case 'INIT':
      return action.data;
    default:
      return state;
  }
  return state;
}

export const DiaryStateContext = createContext();
export const DiaryDispatchContext = createContext();

function App() {
  const [state, dispatch] = useReducer(reducer, []);
  // const [state, dispatch] = useReducer(reducer, mockData);
  // reducer 자리는 state 변경함수, [] 자리는 초기값
  const idRef = useRef(0);
  // useState 변수는 해당 컴포넌트의 생명주기에 따라 변경, 랜더링할 때라든지 그럴 때마다 바뀜, 내가 그전에 해놓은 값이 바뀜
  // useRef 컴포넌트의 생명주기와 관계없이, 변하거나 초기화 되지 않은 값을 만들어주는 훅!

  const onCreate = (date, emotionId, content) => {
    // dispatch(action) 형식
    dispatch({
      type : 'CREATE',
      data : {
        id : idRef.current,
        date : new Date(date).getTime(),
        emotionId,
        content
      }
    });
    idRef.current += 1;
  }

  const onUpdate = (targetId, date, emotionId, content) => {
    dispatch({
      type : 'UPDATE',
      data : {
        id : targetId,
        date : new Date(date).getTime(),
        emotionId,
        content
      }
    });
  }

  const onDelete = (targetId) => {
    dispatch({
      type : 'DELETE',
      // data : {
      //   targetId
      // }
      targetId // 하나만 보낼 꺼니까 data에 담을 필요없이 바로 보내버림
    })
  }
  const [isDataLoad, setIsDataLoad] = useState(false);

  useEffect(() => {
    const rawData = localStorage.getItem('diary');
    if(!rawData){
      setIsDataLoad(true);
      return;
    }
    const localData = JSON.parse(rawData);
    if(localData.length === 0) {
      setIsDataLoad(true);
      return;
    }

    idRef.current = localData[0].id + 1; // 새로고침할 때 다시 0으로 시작하는 것 방지!
    dispatch({
      type : 'INIT',
      // data : mockData
      data : localData
    });
    setIsDataLoad(true);
  }, [])

  if(!isDataLoad)
    return <div>로딩중입니다.</div>;

  return (
    <DiaryStateContext.Provider value={state}>
      <DiaryDispatchContext.Provider value={{onCreate, onDelete, onUpdate}}>
        <div className="App">
          {/* <img src={getEmotionImgById(1)} alt="" /> */}
          <Routes>
            {/* ----------------------------------------------------------------------------------------------------
                페이지 4개
              ---------------------------------------------------------------------------------------------------- */}
            <Route path='/' element={<Home />} />
            <Route path='/new' element={<New />} />
            <Route path='/diary/:id' element={<Diary />} />
            <Route path='/edit/:id' element={<Edit />} />
            <Route path='*' element={<div>404 Page Not Found</div>}/>
          </Routes>
        </div>
      </DiaryDispatchContext.Provider>
    </DiaryStateContext.Provider>
  );
}

export default App;
