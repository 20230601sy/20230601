import { configureStore, createSlice } from "@reduxjs/toolkit"
import info from "../slices/infoSlice";

// const test = createSlice({
//   name : 'test',
//   initialState : 'hello'
// })
// const test의 test는 그냥 변수.. name에 있는 test가 state이름, hello가 초기값
// 리듀서에 내보내야 함...등록은 (const) test 변수를 사용 
// 리액트 기본 기능보다 tool kit 사용하는 게 선녀라심ㅋㅋㅋ
// const test2 = createSlice({
//   name : 'test2',
//   initialState : 'hello2'
// })

// const num = createSlice({
//   name : 'num',
//   initialState : 1,
//   reducers: { // s 붙어야 함 오타주의~
//     // 변경하는 함수 구현
//     // 이런 걸 action이라고 한다심
//     changeNumber() {
//       return 10;
//     },
//     increase(state){ // 함수 여러 개 만들 수 있음
//       // 매개변수 첫번째 매개변수는 기존 state의 값을 가져와 줌, 호출할 때 매개변수가 필요 없음...
//       return ++state;
//     },
//     decrease(state, action){ 
//       // 인자 전달 받은 값은 .payload로 들어감
//       // 정보들이 추가되서 보내짐
//       console.log(action);
//       console.log(action.payload);
//       return state - action.payload;
//     }
//   }
// })

const items = createSlice({
  name : 'items',
  // initialState : [{ id : 0, title : 'apple', count : 1 }, { id : 4, title : 'peach', count : 6 }],
  initialState : [],
  reducers: {
    incCnt(state, action){
      state[action.payload].count++;
      // 이렇게 까지만 하면 나중에 버그 생길 수 있다심 이따가 얘기해주신다심
      // 보통 원본데이터는 남겨두는데... 정렬같은 거 구현할 경우...
      // 정렬한 데이터는 보통 다른 state에 가지고 있다심...
      // 그니껜 그냥 id로 비교하는 걸로 하라궁! 같은 느낌인 거 같은데...맞나부네 ㅡㅡ
      // findIndex 사용하셔서 설명하시넹, 그러면 보낼 때도 id로 보내야 함...cart.js도 수정 필요
      // decCnt를 그렇게 구현하도록 하자...
    },
    decCnt(state, action){
      let index = state.findIndex(item => item.id===parseInt(action.payload));
      if(state[index].count > 0)
        state[index].count--;
    },
    addItem(state, action){
      const {id, title} = action.payload;
      let item = state.find(item => item.id===Number(id));
      if(item)
        item.count++;
      else
        state.push({ id : id, title : title, count : 1 });
      state.sort((a, b) => Number(a.id)-Number(b.id));
    },
    delItem(state, action){
      let index = state.findIndex(item => item.id===parseInt(action.payload));
      state.splice(index, 1);
    }
  }
})

const remoteItems = createSlice({
  name : 'remoteItems',
  initialState : [],
  reducers: {
    addRemoteItem(state, action){
      // let watchedItems = JSON.parse(localStorage.getItem('watched'));
      // watchedItems = [action.payload, ...watchedItems];
      // watchedItems = Array.from(new Set(watchedItems));
      // watchedItems.splice(3, 1);
      // localStorage.setItem('watched', JSON.stringify(watchedItems));
      // state = watchedItems;
      return action.payload;
    }
  }
})

export default configureStore({
  reducer : {
    // 작업은 여기에...
    // test : test.reducer,
    // 다른 컴포넌트에서 블러다 쓸 때 쓸 이름 : state 정보를 담고 있는 변수.reducer 이 변수에 있는 걸 좀 내보내주세요...
    // 이것도 obj형식, key, value
    // 이름은 헷갈리긴 하지만 정확하게는 다 다른 용도이고....뭐 어쨌든 그냥 다 같은 이름 쓰라심
    // test2 : test2.reducer,
    // num : num.reducer,
    // info : info.reducer, // 내보낸 것은 가져오려면 import 되어 있어야 함
    items : items.reducer,
    remoteItems : remoteItems.reducer
  }
})

// 함수도 내보내기 해야 사용 가능
// export const { changeNumber, increase, decrease } = num.actions;
// 형식이 조금 다른데... 위에 있는 것을 풀어 쓰면 
// const actions = num.actions;
// export default actions.increase;

export const { incCnt, decCnt, addItem, delItem } = items.actions;
export const { addRemoteItem } = remoteItems.actions;