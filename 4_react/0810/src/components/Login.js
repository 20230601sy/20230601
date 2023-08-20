import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { AUTHORITIES } from '../constants/authList';
import { setLoginState } from '../redux/store';
import '../styles/Login.css'

const Login = () => {
  const { loginState } = useSelector(state=>state);
  let target = AUTHORITIES.find(auth => auth.loginState === loginState);
  if (!target)
    target = AUTHORITIES[0];

  const dispatch = useDispatch();
  const navigate = useNavigate();

  return (
    <div className={`login login-${target.loginState}`}>
      <i className='fa-solid fa-power-off' onClick={()=>{ 
        if(target.loginState==='logout')
          navigate('/login')
        else {
          dispatch(setLoginState('logout'));
          navigate('/');
        }
        }}>
      </i>
      {
        target.icons.map((icon, i) => <i key={i} className={`fa-solid ${icon.className}`} onClick={()=>navigate(`${icon.navTarget}`)}></i>)
      }
    </div>
  );
}

export default Login;