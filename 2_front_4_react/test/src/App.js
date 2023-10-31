import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';
import DaumMap from './DaumMap';

function App() {
  const [address, setAddress] = useState('');
  
  return (
    <div className="App">
      <DaumMap setAddress={setAddress} />
      <input type="text" placeholder="주소" value={address}/>
      <input type="text" placeholder="상세주소" />
    </div>
  );
}

export default App;
