// const Detail = ({fruit}) => {
//   return (
//     <div className="container mt-3">
//       <div className="row">
//         <div className="col-md-6">
//           <img src={process.env.PUBLIC_URL + `/images/${fruit.title}.jpg`} width="100%" />
//         </div>
//         <div className="col-md-6">
//           <h4 className="pt-5">{fruit.title}</h4>
//           <p>{fruit.content}</p>
//           <p>{fruit.price.toLocaleString()}원</p>
//           <button className="btn btn-danger">주문하기</button> 
//         </div>
//       </div>
//     </div>
//   );
// }

import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Nav from 'react-bootstrap/Nav';
import TabContent from "./06_TabContent";
import { useDispatch, useSelector } from "react-redux";
import { addItem, addRemoteItem } from "../redux/store";

// const Detail = ({fruits, items, setItems}) => {
const Detail = ({fruits}) => {
  // const i = useParams();
  // parameter에 대한 정보를 빼오는 훅, import 필요함 import { useParams } from "react-router-dom";
  // console.log(i);
  // <Route path='/detail/:id' element={<Detail fruits={fruits}/>}/>
  const {id} = useParams();
  // 이것도 구조분해할당 바로 ㄱㄱ 한 거

  // Num state 만들고 update 시킬 공사 해둔 다음....
  // const [num, setNum] = useState(0);
  // const [num2, setNum2] = useState(0);
  // useEffect(() => {
  //   console.log('hi');
  // });
  // console.log('hi2 이게 hi보다 먼저 실행됨');
  // useEffect는 html 모두 읽어온 다음에 작동되는 거, 실행 순서가 다르다는 거임!
  // hi 코드 위치는 상관없음...
  // 이런 특징을 어떻게 활용하면... 읽어오는데 시간이 오래 걸리는 코드 같은 거를 넣어두면 좋다심
  // 뭔가 실행시키고 싶은 코드가 있음
  // 실행 완료까지 걸리는 시간이 10초 걸림 이럴 때.... 이러면 사람은 페이지 다 나간다심 한국인은 2초...
  // 그런데... 서버에서 과일 정보를 받아오는 코드 같은 건 useEffect 안에 있으면 안 됨
  // 해당 페이지의 핵심 기능들은 다른 곳에 작업해야 한다심
  // 페이지와 관련이 크게 없는 기능들을 넣는 거라심
  // 그런데... 시간이 오래 걸리는 반복적인 계산이나 setTimeout이나 심지어는 서버에서 데이터를 받아오는 것도 경우에 따라 useEffect 안에 넣긴 한다심
  const [alertView, setAlertView] = useState(true);
  useEffect(() => {
    let timer = setTimeout(() => {
      setAlertView(false);
    }, 5000);

    // clean up function
    return () => {
      // clean up function 구현은 특별한 함수를 호출하는 게 아니라... ruturn Fn문 작성하는 거임...
      // console.log('clean up function');
      // 여기다 setTimeout을 clear 하면 됨...
      clearTimeout(timer);
    }
    // 재랜더링이 될 때 return이 먼저 실행된 후 useeffect 내부 함수 실행
  }, []);
  // useEffect 두번째 매개변수를 안 쓰면 단점이 update 될 때마다 작동되기 때문에 setTimeout이 resource... 불필요한 작업이 계속 실행되고 있음... 속도가 느려지거나 성능이 떨어지거나 등등...
  // useEffect의 두번째 매개변수에는 의존성 배열이 들어가는데...
  // useEffect는 mount될 때는 무조건 실행됨
  // 변경됐을 때 작동시킬 state 배열을 넣음... 다른 state가 변경됐을 때는 안 
  // useEffect(CallbackFn, )
  // 두번째 매개변수를 아무것도 안 썼을 때는 update 될때마다 실행됨
  // []를 쓰면 mount 됐을 때만 실행됨
  // [num, aa, bb] mount됐을 때와 num, aa, bb state가 변경될 때만 실행됨 다른 state 변경될 때는 실행 안 됨
  // useEffect는 여러 개 생성 가능
  // useEffect(() => {
  //   setNum2(Number(num2)+1);
  // }, [num]);
  // 그런데... 페이지 나갔을 때에도 계속 실행되고 있던 것도 문제...
  // setTimeout이라든지 이런 거 메모리에 남아 있으면 성능저하의 원인이 됨...
  // 100번 클릭했을 때 서버에서 데이터 받아오는 걸 100번 할거임?
  // 그냥 마지막에 누른 것만 실행되게 해야 하는 거 아닐까...라심
  // 서버에서 받아오는 건 실제로 좀더 다른 방식으로 한다심
  // 메모리 누수의 원흉!!!
  // 그래서 clean up function을 사용한다심
  // clean up function은 unmount 됐을 때에도 1번 작동됨! unmount될 때는 useEffect 실행 코드는 실행될 리 없는 건 당연한 거고
  // 정리하면 clean up function은 마운트 될 때는 작동 안 하고, 업데이트 될 때는 매번 useEffect 코드 실행 전 작동되고, unmount 될 때도 작동됨~
  const [tabNo, setTabNo] = useState(0);
  // const {items} = useSelector((state) => state);
  const dispatch = useDispatch();

  useEffect(() => {
    let watchedItems = JSON.parse(localStorage.getItem('watched'));
    // if(watchedItems.length === 3 && !watchedItems.includes(id))
    //   watchedItems.pop();
    watchedItems = [id, ...watchedItems];
    watchedItems = Array.from(new Set(watchedItems));
    watchedItems.splice(3, 1);
    // if(watchedItems.length === 4)
    //   watchedItems.pop();
    localStorage.setItem('watched', JSON.stringify(watchedItems));
    dispatch(addRemoteItem(watchedItems));
    
    // dispatch(addRemoteItem(id));
  // });
  }, []);

  let result = fruits.find((fruit) => fruit.id === Number(id));
  if(!result) {
    return (<div style={{marginTop:'56px', padding:'10px'}}>존재하지 않는 상품입니다.</div>);
  }

  return (
    <div>
      {/* <button className="btn btn-danger m-3" onClick={()=>{setNum(Number(num)+1);}}>num : {num}</button>  */}
      {/* <button className="btn btn-danger m-3" onClick={()=>{setNum2(Number(num2)+1);}}>num2 : {num2}</button>  */}
      <div className="container mt-3 pt-3">
        {
          alertView &&
            <div className="alert alert-danger">
              반짝 할인 상품
            </div>
        }
        <div className="row">
          <div className="col-md-6">
            {/* <img src={process.env.PUBLIC_URL + `/images/${fruits[id].title}.jpg`} width="100%" /> */}
            <img src={`https://raw.githubusercontent.com/Naessss/study/main/${fruits[id].title}.jpg`} width="100%" />
          </div>
          <div className="col-md-6">
            <h4 className="pt-5">{fruits[id].title}</h4>
            <p>{fruits[id].content}</p>
            <p>{fruits[id].price.toLocaleString()}원</p>
            <button className="btn btn-danger" onClick={()=>{
              // let isHave = false;
              // items.map((item) => {
              //   if(item.id === fruits[id].id) {
              //     item.count++;
              //     isHave = true;
              //     // setItems([...items]); // 굳이 랜더링 할 필요는 없을 것 같다만...
              //   }
              // });
              // if(!isHave) {
              //   items = [...items, {id : fruits[id].id, fruit : fruits[id].title, count : 1 }];
              //   // setItems([...items, {id : fruits[id].id, fruit : fruits[id].title, count : 1 }]);
              // }
              // // alert(items[0]);
              dispatch(addItem({id : fruits[id].id, title : fruits[id].title}));
              window.alert('장바구니 추가'); // alert이 안 뜨면!!! window.alert
            }}>주문하기</button> 
          </div>
        </div>
        <Nav className="mt-4" justify variant="tabs" defaultActiveKey="link-0">
          <Nav.Item>
            <Nav.Link eventKey="link-0" onClick={()=>{setTabNo(0)}}>상세정보</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="link-1" onClick={()=>{setTabNo(1)}}>리뷰</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="link-2" onClick={()=>{setTabNo(2)}}>반품,교환정보</Nav.Link>
          </Nav.Item>
        </Nav>
        <TabContent tabNo={tabNo}/>
      </div>
    </div>
  );
}
export default Detail;