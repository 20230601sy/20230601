import { configureStore, createSlice } from "@reduxjs/toolkit"

const totalItems = createSlice({
  name : 'totalItems',
  initialState : [],
  reducers: {
    setTotalItems(state, action) {
      return action.payload;
    }
  }
})

const showItems = createSlice({
  name : 'showItems',
  initialState : [],
  reducers: {
    setShowItems(state, action) {
      return action.payload;
    }
  }
})

const detailItem = createSlice({
  name : 'detailItem',
  initialState : [],
  reducers: {
    setDetailItem(state, action) {
      return action.payload;
    }
  }
})

const loginState = createSlice({
  name : 'loginState',
  initialState : 'logout',
  reducers: {
    setLoginState(state, action) {
      return action.payload;
    }
  }
})

const cartItems = createSlice({
  name : 'cartItems',
  initialState : [],
  reducers: {
    setCartItems() {
      return localStorage.getItem('cartItems') ? JSON.parse(localStorage.getItem('cartItems')) : [];
    },
    incCnt(state, action){
      let index = state.findIndex(item => item.id===parseInt(action.payload));
      state[index].count++;
      localStorage.setItem('cartItems', JSON.stringify(state));
    },
    decCnt(state, action){
      let index = state.findIndex(item => item.id===parseInt(action.payload));
      if(state[index].count > 0)
        state[index].count--;
      localStorage.setItem('cartItems', JSON.stringify(state));
    },
    addItemToCart(state, action) {
      const {id, title, price} = action.payload;
      let item = state.find(item => item.id===Number(id));
      if(item)
        item.count++;
      else
        state.push({ id : id, title : title, price : price, count : 1 });
      localStorage.setItem('cartItems', JSON.stringify(state));
    },
    deleteItemFromCart(state, action) {
      let index = state.findIndex(item => item.id===parseInt(action.payload));
      state.splice(index, 1);
      localStorage.setItem('cartItems', JSON.stringify(state));
    }
  }
})

export default configureStore({
  reducer : {
    totalItems : totalItems.reducer,
    showItems : showItems.reducer,
    detailItem : detailItem.reducer,
    loginState : loginState.reducer,
    cartItems : cartItems.reducer
  }
})

export const { setTotalItems } = totalItems.actions;
export const { setShowItems } = showItems.actions;
export const { setDetailItem } = detailItem.actions;
export const { setLoginState } = loginState.actions;
export const { setCartItems, incCnt, decCnt, addItemToCart, deleteItemFromCart } = cartItems.actions;