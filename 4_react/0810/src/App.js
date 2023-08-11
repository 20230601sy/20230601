import './App.css';
import { Suspense, lazy, useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Home from './pages/Home';
import ItemListPage from './pages/ItemListPage';
import Detail from './pages/Detail';
import About from './pages/About';

function App() {
  return (
    <div className="App">
      <Header />

      <Suspense fallback={<div>로딩중</div>}>
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path='/itemlist/:listID' element={<ItemListPage />}/>
          <Route path='/detail/:id' element={<Detail />}/>
          <Route path='/about' element={<About />}/>
        </Routes>
      </Suspense>
    </div>
  );
}

export default App;