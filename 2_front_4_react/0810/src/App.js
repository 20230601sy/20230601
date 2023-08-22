import { Suspense, useEffect, useMemo } from 'react';
import axios from 'axios';
import { setTotalItems, setShowItems, setCartItems } from './redux/store';
import { Route, Routes } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { useResizeDetector } from 'react-resize-detector';

import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';

import Items from './pages/Items';
import Detail from './pages/Detail';
import About from './pages/About';

import LoginPage from './pages/LoginPage';
import Join from './pages/Join';
import MyPage from './pages/MyPage';
import Cart from './pages/Cart';

import './App.css';

const URL = 'https://20230601sy.github.io/0810/src/assets/items.json';
const URL12 = 'https://20230601sy.github.io/0810/src/assets/first12items.json';

function App() {
  const dispatch = useDispatch();

  useMemo(() => {
    axios.get(URL12)
      .then(result => dispatch(setShowItems(result.data)))
      .catch(error => console.log(error));
  }, []);

  useEffect(() => {
    axios.get(URL)
      .then(result => {
        dispatch(setTotalItems(result.data));
        dispatch(setShowItems(result.data));
      })
      .catch(error => console.log(error));

    dispatch(setCartItems());
  }, []);
  
  const { width, height, ref } = useResizeDetector();

  return (
    <div className="App" ref={ref}>

      <Header />

      <div className='wrap py-2'>
        <Suspense fallback={<div>로딩중</div>}>
          <Routes>
            <Route path='/' element={<Home />}/>
            <Route path='/items' element={<Items />}/>
            <Route path='/detail/:id' element={<Detail />}/>

            <Route path='/login' element={<LoginPage />}/>
            <Route path='/join' element={<Join />}/>
            <Route path='/mypage' element={<MyPage />}/>
            {/* <Route path='/notice' element={<Notice />}/> */}
            {/* <Route path='/board' element={<Board />}/> */}
            <Route path='/cart' element={<Cart width={width}/>}/>
            {/* <Route path='/chart' element={<Chart width={width}/>}/> */}

            <Route path='/about' element={<About />}/>

            <Route path='*' element={<Home />}/>
          </Routes>
        </Suspense>
      </div>

      <Footer />

    </div>
  );
}

export default App;