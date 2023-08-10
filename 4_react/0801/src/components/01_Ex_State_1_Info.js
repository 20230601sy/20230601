import { useState } from "react";
import Child from "./01_Ex_State_2_Child";

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
    <div>
      <h1>Ex_Info</h1>
      <input name='name' type='text' onChange={changeState} style={{marginRight : '10px'}}/>
      <input name='age' type='number' value={state.age} onChange={changeState} style={{marginRight : '10px'}}/> {/* 외부적으로도 값이 바뀔 때 같이 수정되게 */}
      <select name='gender' onChange={changeState}>
        <option>남자</option>
        <option>여자</option>
      </select>
      <h4>이름 : {state.name} (성별 : {state.gender}, 나이 : {state.age})</h4>
      <Child state={state} setState={setState}/>
      {/* const Child = ({state, setState}) => { */}

      {/* <Child {...state} setState={setState}/> 이것도 가능! */}
      {/* const Child = ({name, age, gender, setState}) => {} 그러면 이렇게 받기 가능! */}

    </div>
  );
};

export default Info;