import Button from "../components/Button";
import Header from "../components/Header";
import useDiary from "../hooks/useDiary";
import { useNavigate, useParams } from "react-router-dom";
import { getFormattedDate } from "../utilities/getFormattedDate";
import Viewer from "../components/Viewer";
import { useEffect } from "react";
import { setPageTitle } from "../utilities/setPageTitle";

const Diary = () => {
  const {id} = useParams();
  const data = useDiary(id);
  const navigate = useNavigate();

  useEffect(() => {
    setPageTitle(`Diary : ${id}`);
  }, [])
  if(!data)
    return <div>데이터를 읽어오는 중입니다...</div>;
  
  const {date, emotionId, content} = data;
  const title = `${getFormattedDate(new Date(date))} 다이어리`;
  return(
    <div>
      <Header title={title}
              leftChild={<Button text={'<뒤로가기'} clickHandler={()=>navigate(-1)}/>}
              rightChild={<Button text={'수정하기'} type='positive' clickHandler={()=>navigate(`/edit/${id}`)}/>} />
      <Viewer emotionId={emotionId} content={content}/>
    </div>
  );
}
export default Diary;