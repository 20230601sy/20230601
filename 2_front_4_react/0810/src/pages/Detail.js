import { useParams } from "react-router-dom";
import useDetail from "../hooks/useDetail";
import { Container, Row, Col, Badge, Button } from "react-bootstrap";
import { IMG_PATH } from '../constants/path';
import { useDispatch } from "react-redux";
import { addItemToCart } from "../redux/store";

const Detail = () => {
  const {id} = useParams();
  const item = useDetail(id);
  const dispatch = useDispatch();
  
  if(!item)
    return <div>데이터를 읽어오는 중입니다...</div>;
  
  // const {title, img, price, new, event} = item; new 가 안돼! 허얼...

  return (
    <Container className="Detail mt-2">
      <Row>
        <Col xs={12} md={6}>
          <div className="position-relative">
            <img src={`${IMG_PATH}${item.img}`} style={{ width: '100%', aspectRatio: '1'}} alt="item-img"/>
            <h5><Badge className="position-absolute" style={{top:'5%', right:'20%', transform: 'rotate(-20deg)'}}>{item.new}</Badge></h5>
            <h5><Badge className="position-absolute" bg='info' style={{top:'10%', right:'10%', transform: 'rotate(-20deg)'}}>{item.event}</Badge></h5>
          </div>
        </Col>
        <Col xs={12} md={4} className="align-self-center">
          <h4>{item.title}</h4>
          <h4>{Number(item.price).toLocaleString()}원</h4>
          <Button onClick={()=>{
            dispatch(addItemToCart({id : item.id, title : item.title, price : item.price}))
            // dispatch(addItem({id : fruits[id].id, title : fruits[id].title}));
            window.alert('장바구니 추가');
          }}>카트담기</Button>
        </Col>
        <Col xs={12} md={2} style={{height:'80px'}}/>
      </Row>
    </Container>
  );
}

export default Detail;