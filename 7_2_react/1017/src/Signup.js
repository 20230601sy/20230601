import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Signup() {
  const navigate = useNavigate();

  const [user, setUser] = useState({
    username:'',
    password:'',
    email:''
  });

  const changeHandler = (e) => {
    setUser({
      ...user,
      [e.target.name] : e.target.value
    })
  };
  return (
    <div>
      <h1>회원가입 페이지</h1>
      아이디 : <input name="username" onChange={changeHandler}/><br/>
      비밀번호 : <input name="password" onChange={changeHandler}/><br/>
      이메일 : <input name="email" onChange={changeHandler}/><br/>
      <button onClick={()=> {
        axios.post(`${process.env.REACT_APP_SERVER_URL}/signup`, user)
        .then(response => {
          // console.log(response.data);
          alert(response.data);
          navigate('/');
        })
        .catch(error => {
          console.log(error);
        });
      }}>회원가입</button>
    </div>
  );
}

export default Signup;