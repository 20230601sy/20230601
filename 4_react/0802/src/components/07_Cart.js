import { Table } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
// import { changeNumber, increase, decrease, incCnt, delItem } from "../redux/store";
import { incCnt, decCnt, delItem } from "../redux/store";
import { memo, useMemo, useState } from "react";

// const Cart = ({items, setItems}) => {
const Cart = () => {
  // store.js에 저장한 state를 가져오는 여러 가지 방식
  // const test = useSelector((state) => {
  //   return state;
  // })
  // console.log(test);
  // alert(test.test + test.test2);
  // const {test, test2} = useSelector((state) => { // 구조분해할당 가능...
  //   return state;
  // })
  // const items = useSelector((state) => {
  //   return state.items;
  // })
  // const {items} = useSelector((state) => {
  //   return state;
  // });

  // const num = useSelector((state) => state.num);
  // 함수 사용하려면 useDispatch hook 사용 필요함
  const dispatch = useDispatch();
  // props와는 작동 방식이 다르다심
  // 컴포넌트에서 함수 실행시켜라가 아니라...
  // store.js로 가서 해당 함수 실행시켜라라는 거임... 실행 위치가 다름
  // dispatch는 그냥 경로의 의미...가 더 강함
  const items = useSelector((state) => state.items);

  // 메모이제이션 테스트
  const [num, setNum] = useState(0);
  const Test = memo(({num}) => {
    console.log('test 컴포넌트');
    return (
      <div>
        <h1>{num}</h1>
        메모이제이션 테스트중
      </div>
    );
  })

  const fibo = n => {
    if(n<=1)
      return n;
    return fibo(n-1) + fibo(n-2); // 재귀함수... 자바할 때 안 하셨다심 ㅋㅋㅋ
  }

  const fact = n => {
    let s=0;
    for(let i=1; i<1000000; i++) // 오래 걸리는 거 일부러 넣어두기 ㄷㄷ
      s = s + i;
    if(n<=1){
      console.log('함수 호출');
      return n;
    }
    return n*fact(n-1);
  }
  const [n, setN] = useState(10);

  // const result = fact(n);
  const result = useMemo(()=>{
    return (
      fact(n)
    );
  }, [n])
  // }, [])
  return (
    <>
      <Test num={num}/>
      {num}
      <br/>
      <input type="number" value={n} onChange={(e)=>{setN(e.target.value)}}/>
      {result}
      <button onClick={() => setNum(num+1)}>버튼</button>
      <div className="p-5 pt-4">
        {/* <button onClick={() => {
          // dispatch(changeNumber());
          // dispatch(increase(num));
          // dispatch(increase());
          dispatch(decrease(1)); // 매개변수 전달, 매개변수는 기본적으로 1개만 가능함...여러 개 보내고 싶으면 배열이나 obj형태로 보내면 됨
          // dispatch();
        }}>number : {num}</button> */}
        <Table style={{textAlign : 'center'}}>
          <thead>
            <tr>
              <th scope="col">번호</th>
              <th scope="col">상품명</th>
              <th scope="col">수량</th>
              {/* <th scope="col">변경</th> */}
              <th scope="col">삭제</th>
            </tr>
          </thead>
          <tbody>
            {
              items.map((item, i)=> {
                return (
                  <tr key={i}>
                    <td>{item.id}</td>
                    <td>{item.title}</td>
                    <td>
                      <button className="btn" onClick={()=>dispatch(decCnt(item.id))}>─</button>
                      &nbsp;&nbsp;{item.count}&nbsp;&nbsp;
                      <button className="btn" onClick={()=>dispatch(incCnt(i))}>┼</button>
                    </td>
                    {/* <td> <button className="btn btn-primary" onClick={()=>dispatch(incCnt(i))}>수량추가</button> </td> */}
                    <td>
                      <button className="btn btn-danger" onClick={()=>{dispatch(delItem(item.id))}}>상품삭제</button> 
                    </td>
                  </tr>
                );
              })
            }
          </tbody>
        </Table>
      </div>
    </>
  );
};

export default Cart;