import { Link } from "react-router-dom";

function Header({isAuth, setAuth}) {
  return (
    <div>
      {
        isAuth ? <Link onClick={()=>{
          sessionStorage.removeItem('jwt');
          setAuth(false);
        }}>로그아웃</Link>
               : <Link to="/login">로그인</Link>
      }
      &nbsp;
      <Link to="/signup">회원가입</Link>
    </div>
  );
}

export default Header;