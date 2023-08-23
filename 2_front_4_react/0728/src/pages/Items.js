import Container from 'react-bootstrap/Container';
import { useSelector } from 'react-redux';
import { useState } from 'react';
import ItemCard from '../components/ItemCard';
import '../styles/Items.css';

const Items = () => {
  const {showItems} = useSelector(state => state);
  const [numShowItems, setNumShowItems] = useState(12);

  const handleScroll = (e) => {
    const isNearBottom = e.target.scrollHeight - e.target.scrollTop - e.target.clientHeight < 5;
    if (isNearBottom)
      setNumShowItems(showItems.length > numShowItems+12 ? numShowItems+12 : showItems.length);
  }

  if(!showItems.length)
    return (<Container className='d-flex justify-content-center mt-2'>검색 결과가 없습니다.</Container>);
    
  return (
    <div className="Items">
      <Container className='d-flex justify-content-center'  onScroll={handleScroll}  style={{overflowY: 'scroll', maxHeight: 'calc(100vh - 120px - 80px)'}}>
        <div className="item-list-container">
          {
            showItems.slice(0, numShowItems.num).map((item)=>item && <div key={item.id}><ItemCard item={item}/></div>)
          }
        </div>
      </Container>
    </div>
  );
}

export default Items;