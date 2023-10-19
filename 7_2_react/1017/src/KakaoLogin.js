import axios from "axios";
import { useNavigate } from "react-router-dom";
function KakaoLogin({setAuth}) {
  const navigate = useNavigate();
  const URL = window.location.href;
  const match = /code=([^&]+)/.exec(URL);
  if(match) {
    const code = decodeURIComponent(match[1]);
    axios.post(`${process.env.REACT_APP_SERVER_URL}/oauth/kakao`, {code : code})
      .then(response => {
        const jwt = response.headers.authorization;
        if(jwt) {
          sessionStorage.setItem('jwt', jwt);
          setAuth(true);
          alert('로그인 성공');
          navigate('/');
        }
      })
      .catch(error => {
        alert('로그인 실패');
        console.log(error);
      });
  } else {
    console.log('엑세스토큰 오류');
  }
  return (
    <>
      <h1>로그인 처리 중입니다.</h1>
    </>
  );
}

export default KakaoLogin;