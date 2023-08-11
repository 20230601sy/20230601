import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import '../styles/MainFooter.css'

const MainFooter = () => {
  return (
    <div>MainFooter
      <Container className='none-display-on-mobile'>
        <Row md="auto">
          <Col>공지사항</Col>
          <Col>점포안내</Col>
          <Col>(주문)픽업위치</Col>
        </Row>
        <Row md="auto">
          <Col>회사 소개</Col>
          <Col>개인정보처리방침</Col>
          <Col>이용약관</Col>
          <Col>연락처</Col>
        </Row>
      </Container>

      <Container className='main-footer-mobile display-on-mobile none-padding'>
        <Navbar fixed="bottom">
          <Nav className="me-auto">
            <Nav.Link href="#home">
              <div><i class="fa-solid fa-bars"></i></div>
              <div>카테고리</div>
            </Nav.Link>
            <Nav.Link href="#features">
              <div><i class="fa-regular fa-bell"></i></div>
              <div>픽업 안내</div>
            </Nav.Link>
            <Nav.Link href="#pricing">
              <div><i class="fa-solid fa-house"></i></div>
              <div>홈</div>
            </Nav.Link>
            <Nav.Link href="#pricing">
            <div><i class="fa-regular fa-user"></i></div>
            <div>마이페이지</div>
            </Nav.Link>
            <Nav.Link href="#pricing">
              <div><i class="fa-regular fa-star"></i></div>
              <div>자주 구매</div>
            </Nav.Link>
          </Nav>
        </Navbar>
        {/* <Row>
          <Col className='none-padding'>
            <div><i class="fa-regular fa-star"></i></div>
            <div>자주 구매</div>
          </Col>
        </Row> */}
      </Container>
    </div>
  );
}

export default MainFooter;