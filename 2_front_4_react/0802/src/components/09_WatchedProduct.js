import bg from '../images/bg.jpg';

function WatchedProduct() {
  // 임시 상품 데이터
  const recentItems = [
    { id: 1, name: '상품1', image: bg },
    { id: 2, name: '상품2', image: bg },
    { id: 3, name: '상품3', image: bg },
  ];

  return (
    <div className="recent-container">
      <div className="cards">
      <p>최근 본 상품</p>
        {recentItems.map((item) => (
          <div className="card" key={item.id}>
            <img src={item.image} alt={item.name} />
            <p>{item.name}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default WatchedProduct;