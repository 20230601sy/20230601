import Header from "../components/Header";
import Button from '../components/Button';
import Editor from "../components/Editor";
import useDiary from "../hooks/useDiary";
import { useParams, useNavigate } from "react-router-dom";
import { useContext, useEffect } from "react";
import { DiaryDispatchContext } from "../App";
import { setPageTitle } from "../utilities/setPageTitle";

const Edit = () => {
  const {id} = useParams();
  const initData = useDiary(id);

  const navigate = useNavigate();
  const {onUpdate, onDelete} = useContext(DiaryDispatchContext);
  const onSubmit = (state) => {
    onUpdate(id, state.date, state.emotionId, state.content);
    alert('다이어리 수정 완료');
  }
  const deleteHandler = () => {
    if(window.confirm('정말 삭제하시겠습니까?')){
      onDelete(id);
      navigate('/');
    }
  }
  useEffect(() => {
    setPageTitle(`Edit : ${id}`);
  }, [])
  if(!initData)
    return <div>로딩중...</div>
  return(
    <div>
      <Header title={'다이어리 수정'}
              leftChild={<Button text={'<뒤로가기'} clickHandler={()=>navigate(-1)}/>}
              rightChild={<Button text={'삭제하기'} type='negative' clickHandler={deleteHandler}/>} />
      <Editor initData={initData} onSubmit={onSubmit}/>
    </div>
  );
}
export default Edit;