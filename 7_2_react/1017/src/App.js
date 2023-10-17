import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Header from './Header';
import { Route, Routes } from 'react-router-dom';
import Signup from './Signup';
import Login from './Login';

function App() {
  // const [test, setTest] = useState();
  // const [vo, setVO] = useState({
  //   id:'',
  //   pw:'',
  //   age:''
  // });

  // useEffect(()=>{
  //   axios.get(`${process.env.REACT_APP_SERVER_URL}/test`)
  //     .then(response => {
  //       // console.log(response.data);
  //       setTest(response.data);
  //     })
  //     .catch(error => {
  //       console.log(error);
  //   })
  // }, [])
  return (
    <div className="App">
      <Header/>

      <Routes>
        <Route path='/' element={<h1>인덱스페이지</h1>}/>
        <Route path='/login' element={<Login />}/>
        <Route path='/signup' element={<Signup />}/>
      </Routes>
      {/* <h1>{test}</h1>

      <button onClick={()=> axios.get(`${process.env.REACT_APP_SERVER_URL}/test2`)
      .then(response => {
        // console.log(response.data);
        setVO(response.data);
      })
      .catch(error => {
        console.log(error);
    })}>TestVO 받기</button>
    <p>id : {vo.id}</p>
    <p>pw : {vo.pw}</p>
    <p>age : {vo.age}</p>

    <button onClick={()=> axios.post(`${process.env.REACT_APP_SERVER_URL}/test/5`, 
                                      {
                                        "id":"qwer",
                                        "pw":"1234",
                                        "age":30
                                      },
                                      {
                                        params : {
                                          "msg" : "/test/5?msg=아아아 이런 식으로 쿼리스트링으로 보내도 되지만 post니까 좀 그래 이렇게 보내도록"
                                        }
                                      })
      .then(response => {
      })
      .catch(error => {
        console.log(error);
    })}>보내기</button> */}
    </div>
  );
}

export default App;
