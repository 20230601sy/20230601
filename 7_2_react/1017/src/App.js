import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Header from './Header';
import { Route, Routes } from 'react-router-dom';
import Signup from './Signup';
import Login from './Login';
import GoogleLogin from './GoogleLogin';
import KakaoLogin from './KakaoLogin';
import axiosInstance from './axiosInstance';
import WriteBoard from './WriteBoard';
import BoardList from './BoardList';
import BoardDetail from './BoardDetail';
import LoginMsg from './LoginMsg';

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
  
  const [isAuth, setAuth] = useState(false);
  const [userInfo, setUserInfo] = useState({
    username : ''
  });
  

  useEffect(()=>{
    // setIsLoading(false);
    if(isAuth) {
      axiosInstance.get('/userInfo')
                  .then(response => {setUserInfo(response.data);})
                  .catch(error => console.log(error));
      // console.log(userInfo);
      // console.log(userInfo.username);
    }
  }, [isAuth])

  // if(isLoading)
  //   return <div>로딩중...</div>
  return (
    <div className="App">
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
      
      <Header isAuth={isAuth} setAuth={setAuth} userInfo={userInfo} setUserInfo={setUserInfo}/>
      
      <Routes>
        <Route path='/'             element={<BoardList />}/>
        <Route path='/login'        element={<Login setAuth={setAuth}/>}/>
        <Route path='/signup'       element={<Signup />}/>
        <Route path='/oauth/google' element={<GoogleLogin setAuth={setAuth} />}/>
        <Route path='/oauth/kakao'  element={<KakaoLogin setAuth={setAuth} />}/>
        <Route path='/write'        element={<WriteBoard userInfo={userInfo} />}/>
        <Route path='/board/:id'    element={isAuth ? <BoardDetail userInfo={userInfo} /> : <LoginMsg/>}/>
      </Routes>

      {/* <button onClick={()=>{
        axiosInstance.get('/aa')
                      .then(response => console.log(response.data))
                      .catch(error => {
                        alert('로그인 후 사용 가능');
                        console.log(error);
                      });
      }}>테스트</button> */}
    </div>
  );
}

export default App;
