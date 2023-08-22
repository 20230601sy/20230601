import { createSlice } from "@reduxjs/toolkit";

const info = createSlice({
  name: 'info',
  initialState: {
    name : '홍길동',
    age : 20,
    gender : 'm'
  },
  reducers : {
    setAge(state) {
      state.age = 30
    },
    changeGender(state) {
      state.gender = 'f'
    }
  }
})

export default info;
export const { setAge, changeGender } = info.actions;