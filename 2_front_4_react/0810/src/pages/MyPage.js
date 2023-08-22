import { Container } from "react-bootstrap";
import { useSelector } from "react-redux";
import Board from "./Board";
import Notice from "./Notice";
import LoginPage from "./LoginPage";

const MyPage = () => {
  const {loginState} = useSelector(state => state);

  if(loginState==='admin')
    return <Board />;

  else if(loginState==='manager')
    return <Notice />;

  else if(loginState==='user') {
    return (
      <Container className='MyPage mt-2'>
        MyPage
      </Container>
    );
  }

  else // else if(loginState==='logout')
    return <LoginPage />;
  
}

export default MyPage;