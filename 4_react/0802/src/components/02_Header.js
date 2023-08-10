import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import { Container, Nav, Navbar } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const Header = () => {
  // 페이지 이동 관련된 내장함수 사용! 이것도 react hook 이라 use 뭐시기
  const navigate = useNavigate();
  const userInfoQuery = useQuery(['userInfo'], () => {
    return (
      axios.get('https://raw.githubusercontent.com/Naessss/study/main/userinfo.json')
      .then((result) => {
        // console.log(result);
        // console.log('name', result.data.name);
        // alert(result.data);
        return result.data;
      })
      .catch((error, i) => {
        // console.log(error);
        console.log(i);
      })
    );}
    // , 
    // {
    //   // staleTime : 5000 // refetch 간격 5번
    //   // staleTime : Infinity // refetch 안함
    // }
  )
  return (
    <Navbar bg="dark" data-bs-theme="dark" style={{position : 'fixed', top : '0', width:'100%'}}>
      <Container>
        {/* <Navbar.Brand href={`/`}>Navbar</Navbar.Brand> */}
        <Navbar.Brand onClick={() => {navigate('/')}}>Navbar</Navbar.Brand>
        <Nav className="me-auto">
          {/* <Nav.Link href={`/`}>Home</Nav.Link> */}
          {/* / 는 root 페이지 또는 index 페이지라고 한다심 */}
          {/* <Nav.Link href={`/detail`}>detail</Nav.Link> */}
          {/* <Nav.Link href={`/cart`}>cart</Nav.Link> */}
          {/* href를 쓰면 reload하기 때문에 route를 쓰는 의미가 없어짐... Link 쓰면 import 해야 함 import { Link } from 'react-router-dom'; */}
          {/* reloading 된다는 의미는 관련 html, css, js를 다운받는다는 의미이기 때문에 매번 다운받아야 하는 거는... 어제 함 해주신 얘기 */}
          {/* 이렇게 했을 때의 장점은 한 번 들어간다음 인터넷이 끊겼을 때... 사실 애초에 인터넷이 끊기면... 들어가기 어렵... 퍽퍽ㅋㅋㅋ */}
          
          {/* <Link to='/' className='list-group-item text-bg-dark'>메인페이지</Link>
          <Link to='/detail' className='list-group-item text-bg-dark'>상세페이지</Link> */}
          {/* <Nav.Link><Link to='/'>Home</Link></Nav.Link> */}

          {/* 안예쁘니까 Nav로 쓸거라심 */}
          <Nav.Link onClick={() => {navigate('/')}}>Home</Nav.Link>
          <Nav.Link onClick={() => {navigate('/detail')}}>detail</Nav.Link>
          <Nav.Link onClick={() => {navigate('/cart')}}>cart</Nav.Link>
          <Nav.Link onClick={() => {navigate('/about')}}>about</Nav.Link>
          {/* 참고로 이런 것도 된다심 */}
          {/* <Nav.Link onClick={() => {navigate(-2)}}>두번뒤로가기</Nav.Link> */}
          {/* <Nav.Link onClick={() => {navigate(-1)}}>뒤로가기</Nav.Link> */}
          {/* <Nav.Link onClick={() => {navigate(1)}}>앞으로가기</Nav.Link> */}
          {/* <Nav.Link onClick={() => {navigate(2)}}>두번앞으로가기</Nav.Link> */}
        </Nav>
        <Nav style={{color:'white'}}>
          {/* 로그인한 사람 정보 출력 */}
          {userInfoQuery.isLoading && '로딩중'}
          {/* 새로고침 막 눌러보면 로딩중은 보임 ㄷㄷ 주소를 잘못 써놓으면 초기에 로딩중이다가 오류로 바뀜, 리액트 쿼리가 state처럼 작동되나봄 */}
          {/* 리액트쿼리를 쓰면 또 장점인 게 딴 데 왔다갔다 했을 때 자동으로 재요청을 함 refetch 라고 한다심, 리패치 기능을 막을 수도 있고 간격 조정도 할 수 있음 */}
          {userInfoQuery.isError && '오류'}
          {userInfoQuery.data && userInfoQuery.data[0].name}
        </Nav>
      </Container>
    </Navbar>
  );
};

export default Header;