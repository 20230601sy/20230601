const Child = ({state, setState}) => {
  return (
    <div>
      <h4>나이는 {(state.age%2)? '홀수':'짝수'}</h4>
      <button onClick={(e)=>{
        state.age = Number(state.age) + 1;
        setState({...state});
        // e.target.parentElement.previousSibling.previousSibling.previousSibling.value = state.age;
        // 이거 대신에 input tag에서 value 넣어 주심
      }}>나이 증가</button>
    </div>
  );
};

export default Child;