import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ItemCard from './ItemCard';

const ItemList = () => {
  return (
    <div>ItemList
      <Container>
        <Row>
          {
            [1, 2, 3,
            4, 5, 6, 7, 8].map((num)=><Col key={num}><ItemCard /></Col>)
          }
        </Row>
        {/* {
          [1, 2].map((data)=>
            <Row key={data}>
              {
                [1, 2, 3].map((num)=><Col key={num}><ItemCard /></Col>)
              }
            </Row>)
        } */}
      </Container>
    </div>
  );
}

export default ItemList;