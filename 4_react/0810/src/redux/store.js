import { configureStore, createSlice } from "@reduxjs/toolkit"

const items = createSlice({
  name : 'items',
  initialState : [],
  reducers: {
    incCnt(state, action){
      state[action.payload].count++;
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

export default configureStore({
  reducer : {
    items : items.reducer,
  }
})


export const { incCnt, decCnt, addItem, delItem } = items.actions;
