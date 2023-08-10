import './02_Ex_Board_2_Modal.css';

const Modal = ({title}) => {
  return (
    <div className="Modal"> {/* Modal의 M 대문자... */}
      {/* <h4>제목</h4> */}
      <h4>{title[0]}</h4>
      <p>작성일</p>
      <p>내용</p>
    </div>
  );
};

export default Modal;