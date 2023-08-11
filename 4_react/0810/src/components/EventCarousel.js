import { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';

const EventCarousel = () => {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <div>EventCarousel
      <Carousel onSelect={handleSelect}>
        {
          [1, 2, 3].map((num)=>
            <Carousel.Item key={num}>
              <img src={`https://via.placeholder.com/800x200?text=Event Image ${num}`} alt="" className='full-width-on-mobile'/>
              {/* <ExampleCarouselImage text="First slide" /> */}
              {/* <Carousel.Caption> */}
                {/* <h3>First slide label</h3> */}
                {/* <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> */}
              {/* </Carousel.Caption> */}
            </Carousel.Item>
          )
        }
      </Carousel>
    </div>
  );
}

export default EventCarousel;