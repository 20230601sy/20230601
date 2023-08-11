import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
const Navbars = () => {
  return (
    <div>Navbars
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Nav className="me-auto">
            <NavDropdown NavDropdown id="nav-dropdown-dark-example" title={<i class="fa-solid fa-bars">&nbsp;&nbsp;카테고리</i>} menuVariant="dark" className='none-display-on-mobile'>
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
            </NavDropdown>
            <Nav.Link href="#home">신상품</Nav.Link>
            <Nav.Link href="#features">세일중</Nav.Link>
            <Nav.Link href="#pricing">자주 구매</Nav.Link>
            <Nav.Link href="#pricing">베스트</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </div>
  );
}

export default Navbars;