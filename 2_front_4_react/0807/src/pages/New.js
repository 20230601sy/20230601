import Header from "../components/Header";
import Button from '../components/Button';
import Editor from "../components/Editor";
import { useNavigate } from "react-router-dom";
import { useContext, useEffect } from "react";
import { DiaryDispatchContext } from "../App";
import { setPageTitle } from "../utilities/setPageTitle";

const New = () => {
  const navigate = useNavigate();
  const {onCreate} = useContext(DiaryDispatchContext);
  useEffect(() => {
    setPageTitle('New');
  }, [])
  const onSubmit = (state) => {
    onCreate(state.date, state.emotionId, state.content);
    alert('다이어리 작성 완료');
  }
  return(
    <div>
      <Header title='새 다이어리 작성'
              leftChild={<Button text={'<뒤로가기'} clickHandler={()=>navigate(-1)}/>} />
      <Editor onSubmit={onSubmit}/>
    </div>
  );
}
export default New;