import { useDispatch, useSelector } from 'react-redux';
import { setShowItems } from '../redux/store';
import EventCarousel from '../components/EventCarousel';
import Items from './Items';

const Home = () => {
  const {totalItems} = useSelector(state=>state);
  const dispatch = useDispatch();
  dispatch(setShowItems(totalItems));

  return (
    <div className='Home'>
      <EventCarousel />
      <Items />
    </div>
  );
}

export default Home;