import { Container, Nav, Navbar } from 'react-bootstrap';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import Category from './Category';
import { BG_COLOR_SECOND } from '../constants/color';
import { ABOUT_LISTS } from '../constants/aboutList';
import '../styles/Footer.css';

const Footer = () => {
  const [showMobileDropdown, setShowMobileDropdown] = useState(false);
  const navigate = useNavigate();

  return (
    <div className='Footer'>

      <div className="pc-footer-container d-none d-md-block" style={{...BG_COLOR_SECOND}}>
          <Navbar data-bs-theme="dark" className='py-0'>
            <Container>
              <Nav className="me-auto">            
                {
                  [0, 1, 2].map(num => <Nav.Link key={num} onClick={()=>navigate(`${ABOUT_LISTS[num].destination}`)}>{ABOUT_LISTS[num].title}</Nav.Link>)
                }
              </Nav>
            </Container>
          </Navbar>
          <Navbar data-bs-theme="dark" className='py-0'>
            <Container>
              <Nav className="me-auto">            
                {
                  [3, 4, 5, 6].map(num => <Nav.Link key={num} onClick={()=>navigate(`${ABOUT_LISTS[num].destination}`)}>{ABOUT_LISTS[num].title}</Nav.Link>)
                }
              </Nav>
            </Container>
          </Navbar>
      </div>
      
      <Navbar className='mobile-footer d-md-none p-0 fixed-bottom'>
        <Nav className="me-auto">
          <Nav.Link className='position-relative'
                    onClick={()=>setShowMobileDropdown(!showMobileDropdown)}
                    onMouseMove={()=>setShowMobileDropdown(true)}
                    onMouseLeave={()=>setShowMobileDropdown(false)}>

            <div className='position-absolute' style={{width:'100px', left: '5px', bottom:'65px', background:'none'}} >
              {
                showMobileDropdown &&
                <Category color={{background: 'lightgrey'}} />
              }
            </div>

            <div><i className="fa-solid fa-bars"></i></div>
            <div>카테고리</div>
          </Nav.Link>

          {
            [
              {id:0, title:'픽업 안내',  targetNav:'/about', icon:'fa-solid fa-bell'},
              {id:1, title:'홈',         targetNav:'/',      icon:'fa-solid fa-house'},
              {id:2, title:'마이페이지', targetNav:'/mypage', icon:'fa-solid fa-user'},
              {id:3, title:'장바구니',   targetNav:'/cart',   icon:'fa-solid fa-cart-shopping'}
            ].map(menu => {
              return(
                <Nav.Link key={menu.id} onClick={()=>navigate(menu.targetNav)}>
                  <div><i className={menu.icon}></i></div>
                  <div>{menu.title}</div>
                </Nav.Link>
              );})
          }
        </Nav>
      </Navbar>
    </div>
  );
}

export default Footer;