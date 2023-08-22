import { Container, Carousel } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { IMG_PATH } from '../constants/path';
import { EVENT_LISTS } from '../constants/eventList';
import { setShowItems } from '../redux/store';

const EventCarousel = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  return (
    <Container className='my-2'>
      <Carousel>
        {
          EVENT_LISTS.map(event => 
            <Carousel.Item key={event.id}>
              <img src={`${IMG_PATH}${event.img}`} alt=""
                    style={{width: '800px', aspectRatio:'8/3'}}
                    className='img-fluid'
                    onClick={() => {
                      dispatch(setShowItems(event.eventItems));
                      navigate('/items');
                    }}
              />
            </Carousel.Item>
          )
        }
      </Carousel>
    </Container>
  );
}

export default EventCarousel;