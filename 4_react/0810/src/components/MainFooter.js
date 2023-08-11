import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const MainFooter = () => {
  return (
    <div>MainFooter
      <Container>
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
    </div>
  );
}

export default MainFooter;