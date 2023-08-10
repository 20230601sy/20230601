import { useState } from 'react';
import bg from '../images/bg.jpg';
import Card from './01_Card';

const Main = ({fruits}) => {
  const [viewCount, setViewCount] = useState(3);

  return (
    <>
      <div className='main-bg' style={{backgroundImage: `url(${bg}`}}></div>
      <div className="container mt-4">
        <div className="row">
          {/* { fruits.map( (fruit, i) => <Card fruit={fruit} key={i}/> ) } */}
          {/* { fruits.map((fruit, i) => (i < viewCount) && <Card fruit={fruit} key={i}/>) } */}
          { fruits.slice(0, viewCount).map( (fruit, i) => <Card fruit={fruit} key={i}/> ) }
        </div>
      </div>
      <div style={{textAlign:'center'}}>
        {
          fruits.length < viewCount
          ? <div className="alert alert-danger">더 가져올 상품이 없습니다.</div>
          : <button className="btn btn-secondary m-2" onClick={() => {
              setViewCount(viewCount+3);
            }}>더보기</button>
        }

      </div>
    </>
  );
};

export default Main;