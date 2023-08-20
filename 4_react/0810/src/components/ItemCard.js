import { Card, Badge } from 'react-bootstrap';
import { IMG_PATH } from '../constants/path';
import { useNavigate } from 'react-router-dom';

const ItemCard = ({item}) => {
  const navigate = useNavigate();
  return (
    <Card style={{ width: '18rem' }} onClick={()=>navigate(`/detail/${item.id}`)} className="position-relative">
      <Card.Img variant="top" src={`${IMG_PATH}${item.img}`} style={{ width: '16rem', aspectRatio: '1', margin: '1rem'}} />
      <h5><Badge pill className="position-absolute" style={{top:'2.5%', left:'4%'}}>{item.new}</Badge></h5>
      <h5><Badge pill className="position-absolute" bg='info' style={{top:'2.5%', right:'4%'}}>{item.event}</Badge></h5>
      <Card.Body>
        <Card.Title>{item.title}</Card.Title>
        <Card.Text>{Number(item.price).toLocaleString()}원</Card.Text>
      </Card.Body>
    </Card>
  );
}

export default ItemCard;