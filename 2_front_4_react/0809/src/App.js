import logo from './logo.svg';
import './App.css';
import { useState, useTransition, useDeferredValue } from "react";
let a = Array(10000).fill(0);
// 지금 에러는 걍 무시하고 새로고침하라심

function App() {
  const [data, setData] = useState('');
  const [isPending, startTransition] = useTransition();
  const deferedState = useDeferredValue(data);
  return (
    <div className="App">
      {data}
      <input onChange={(e) => {
        // startTransition(() => {
          setData(e.target.value);
        // })
      }} />
      {
        // isPending ? '로딩중임' :
        a.map(() => {
          return(
            // <div>{data}</div>
            <div>{deferedState}</div>
          )
        })
      }
      {/* 애초에 만개 찍는 거를 쪼개 넣는 게 좋다심 페이지별로 나눠서 처리하거나 하는 게 제일 베스트라심 */}
      {/* 이상황에서 조금이라도 빠르게 해주고 싶다면 useTransition 훅 사용 */}
      {/* 근본적으로 처리되는 속도는 결국 동일한데, 느려지는 것에 대한 처리를 나중으로 미뤄버리는 것이기 때문 대신 사용자는 뭔가 되는 것같이 보이기 때문에... */}
      {/* startTransition을 처리하는 중에는 isPending이 true, 그러니까 로딩중임을 이걸 활용해서 표시할 수도 있음 */}
      {/* 임시방편... 아까 말했듯이 애초에 이렇게 만들지 말라심 */}
      {/* useDeferredValue도 비슷한 기능인데 useTransition은 영역을 지정해줘야 했다면 이거는 변수명만 매개변수로 저장해놓으면 됨 */}
      {/* data를 늦게 처리한 결과를 deferredState에 저장함 */}
    </div>
  );
}

export default App;
