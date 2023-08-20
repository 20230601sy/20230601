import { ButtonGroup, Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { CATEGORIES } from '../constants/categoryList'; // 이 정도는 알고 있는 걸로 하자 ㅡ_ㅡ
import { setShowItems } from '../redux/store';

const Category = ({color}) => {
  const {totalItems} = useSelector(state => state);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  return (
    <ButtonGroup vertical className={'Category d-flex justify-content-center'} style={{background:'none'}}>
      {
        CATEGORIES.map(category => {
          return (
            <Button className='Category-Button' style={{...color, color:'rgba(255, 255, 255, 0.55)', fontSize:'16px', height:'42px', border:'none'}} size="lg" key={category.id} onClick={() => {
              dispatch(setShowItems(totalItems.filter(item => item.category === category.category)));
              navigate('/items');
            }}>
              {category.content}
            </Button>
          );
        })
      }
    </ButtonGroup>
  );
}

export default Category;