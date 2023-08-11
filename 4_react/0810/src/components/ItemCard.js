import Card from 'react-bootstrap/Card';

const ItemCard = () => {
  return (
    <div className='justify-content-center m-2'>ItemCard
      <Card style={{ width: '18rem' }}>
        <Card.Img variant="top" src="https://via.placeholder.com/300x300?text=Item Image" />
        <Card.Body>
          <Card.Title>Card Title</Card.Title>
          <Card.Text>Some quick example text</Card.Text>
        </Card.Body>
      </Card>      
    </div>
  );
}

export default ItemCard;