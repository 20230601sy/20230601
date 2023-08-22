import '../css/Header.css'
const Header = ({title, leftChild, rightChild}) => {
  return(
    <div className="Header">
      <div className="header-left">{leftChild}</div>
      <div className="header-title">{title}</div>
      <div className="header-right">{rightChild}</div>
    </div>
  );
}
export default Header;

{/* <Header title={'Home'} */}
  // leftChild={<Button text={'확인'} type={'positive'} />}
  // rightChild={<Button text={'취소'} type={'negative'} />} />