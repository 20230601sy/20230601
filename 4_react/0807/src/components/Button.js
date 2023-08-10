import '../css/Button.css'
const Button = ({text, type, clickHandler}) => {
  // default : 일반 버튼 - 회색
  // positive : 긍정 버튼 - 초록
  // negative : 부정 버튼 - 빨강
  const btnType = ['positive', 'negative'].includes(type) ? type : 'default';

  return(
    <button className={`Button Button_${btnType}`} onClick={clickHandler}>
      {text}
    </button>
  );
}

Button.defaultProps = {
  type : 'default'
}
export default Button;

{/* <Button text='일반'/> */}
{/* <Button text='등록' type='positive' clickHandler={()=>alert('등록')}/> */}
{/* <Button text='취소' type='negative' clickHandler={()=>alert('취소')}/> */}