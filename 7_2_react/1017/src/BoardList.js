import { useEffect, useState } from "react";
import axiosInstance from "./axiosInstance";
import { Link } from "react-router-dom";

function BoardList() {
  const [boards, setBoards] = useState();
  const [isLoading, setIsLoading] = useState(true);
  useEffect(()=>{
    axiosInstance.get(`/board`)
                .then(response => {
                  setBoards(response.data);
                  setIsLoading(false);
                })
                .catch(error => console.log(error));
  }, []);
  if(isLoading)
    return <div>로딩중...</div>
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody>
          {
            boards.map(board => {
              return (
                <tr key={board.id}>
                  <td>{board.id}</td>
                  <td><Link to={`/board/${board.id}`}>{board.title}</Link></td>
                  <td>{board.writer}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  );
}
export default BoardList;