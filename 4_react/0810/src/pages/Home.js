import EventCarousel from '../components/EventCarousel';
import ItemList from '../components/ItemList';
import MainFooter from '../components/MainFooter';

const Home = () => {
  return (
    <div>Home
      {/* <EventCarousel /> */}
      <EventCarousel />
      <ItemList />
      <MainFooter />
    </div>
  );
}

export default Home;