import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axiosInstance from "./axiosInstance";

function BoardDetail({userInfo}) {
  const {id} = useParams();
  const [board, setBoard] = useState();
  const [isLoading, setIsLoading] = useState(true);
  const navigate = useNavigate();
  useEffect(()=>{
    axiosInstance.get(`/board/${id}`)
                .then(response => {
                  setBoard(response.data);
                  setIsLoading(false);
                })
                .catch(error => console.log(error));
  }, []);
  if(isLoading)
    return <div>로딩중...</div>
  return (
    <div>
      <div>제목 : {board.title}</div>
      <div>내용 : {board.content}</div>
      <div>작성자 : {board.writer}</div>
      <button onClick={()=>{
        if(userInfo.username != board.writer) {
          alert('작성자만 삭제가능');
          return;
        }
        axiosInstance.delete('/board', { params : {'id' : board.id} })
                  .then(response => {
                            alert(response.data);
                            navigate('/');
                  })
                  .catch(error => console.log(error));
      }}>삭제</button>
    </div>
  );
}

export default BoardDetail;