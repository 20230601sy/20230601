import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Search from './Search';
import Login from './Login';
import Navbars from './Navbars'
import '../styles/Header.css'

const Header = () => {
  return (
    <div className='Header'>
      <Container>
        <Row className='column-direction-on-mobile'>
          <Col className="col-align" xs="auto">
            <img src="https://via.placeholder.com/200x50?text=logo"/>
          </Col>
          <Col>
            <Search />
          </Col>
          <Col className="col-align" xs="auto">
            <div className="none-display-on-mobile">
              <Login />
            </div>
          </Col>
        </Row>
      </Container>
      <Navbars />
    </div>
  );
}

export default Header;