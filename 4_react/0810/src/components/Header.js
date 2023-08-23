import { Container, Row, Col, Nav, Navbar } from 'react-bootstrap';

import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { setShowItems } from '../redux/store';

import Search from './Search';
import Login from './Login';
import Category from './Category';

import { IMG_PATH } from '../constants/path';
import { BG_COLOR } from '../constants/color';
import { ITEM_LISTS } from '../constants/itemLists';

const Header = () => {
  const {totalItems} = useSelector(state => state);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [showCategory, setShowCategory] = useState(false);

  return (
    <div className='Header fixed-top' style={{background : 'white'}}>
      
      <Container>
        <Row className='flex-column flex-md-row align-items-center'>
          <Col className='text-start' xs="auto">
            <img src={`${IMG_PATH}logo.png`} alt='logo' className='py-1' style={{cursor:'pointer'}} onClick={()=>navigate('/')}/>
          </Col>
          <Col>
            <Search />
          </Col>
          <Col className="d-none d-md-block" xs="auto">
            <Login />
          </Col>
        </Row>
      </Container>

      <Navbar data-bs-theme="dark" style={{...BG_COLOR}}>
        <Container>
          <Nav className="me-auto">

            <Nav.Link className='d-none d-md-block position-relative' onMouseMove={()=>setShowCategory(true)} onMouseLeave={()=>setShowCategory(false)} onClick={()=>setShowCategory(!showCategory)}>
              <i className="fa-solid fa-bars"></i>&nbsp;&nbsp;카테고리&nbsp;<i className="fa-solid fa-caret-down"></i>
              <div style={{width:'150px', height:0}}>
                {
                  showCategory &&
                  <Category color={BG_COLOR} />
                }
              </div>
            </Nav.Link>

            {/* 신상품 세일중 자주 구매 베스트 */}
            {
              ITEM_LISTS.map(itemlist => {
                return (
                  <Nav.Link key={itemlist.id} className='text-nowrap' onClick={()=>{
                    dispatch(setShowItems(totalItems.filter(item => item[itemlist.compareTarget])));
                    navigate('/items');
                  }}>
                    {itemlist.title}
                  </Nav.Link>
                );
              })
            }

          </Nav>
        </Container>
      </Navbar>
    </div>
  );
}

export default Header;