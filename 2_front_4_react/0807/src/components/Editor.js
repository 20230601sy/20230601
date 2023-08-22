import '../css/Editor.css';
import { useCallback, useEffect, useState } from 'react';
import { getFormattedDate } from '../utilities/getFormattedDate'
import Button from './Button';
import { useNavigate } from "react-router-dom";
import { emotionList } from '../utilities/emotionList';
import EmotionItem from './EmotionItem';

const Editor = ({ initData, onSubmit }) => {
  const [state, setState] = useState({
    // date: '',
    date: getFormattedDate(new Date()),
    emotionId: 3,
    content: ''
  });

  useEffect(() => {
    if(initData)
      setState({
        ...initData,
        date : getFormattedDate(new Date(Number(initData.date)))
      });
  }, [initData]);

  const changeHandler = (e) => {
    // state[e.target.type] = e.target.value;
    // state[e.target.name] = e.target.value;
    // setState({...state});
    // setState({...state, date: e.target.value});
    setState({...state, [e.target.name]: e.target.value});
  }

  const changeEmotionHandler = useCallback((emotionId) => {
    // setState({...state, emotionId});
    setState(state => ({...state, emotionId}));
  }, [])
  const navigate = useNavigate();

  const submitHandler = () => {
    // 수정 시 완료
    // 새글 작성 시 완료...
    // 두 가지 기능을 담기는 그렇...다
    // onSubmit에서 받아오는 걸로...
    onSubmit(state);
    navigate('/');
  }

  const cancelHandler = () => {
    navigate(-1);
  }

  return (
    <div className='Editor'>
      <div className='editor_section'>
        <h4>오늘의 날짜</h4>
        <div className='input_wrapper'>
          {/* <input type='date' value={state.date} onChange={changeHandler}/> */}
          <input type='date' name='date' value={state.date} onChange={changeHandler}/>
        </div>
      </div>
      <div className='editor_section'>
        <h4>오늘의 기분</h4>
        <div className='input_wrapper emotion_list_wrapper'>
          {
            emotionList.map((data) => {
              return (
                <EmotionItem key={data.id} {...data} onClick={changeEmotionHandler} isSelected={state.emotionId===data.id}/>
              );
            })
          }
        </div>
      </div>
      <div className='editor_section'>
        <h4>오늘의 내용</h4>
        <textarea placeholder='기록하고 싶은 내용을 입력하세요' name='content' value={state.content} onChange={changeHandler}/>
      </div>
      <div className='editor_section bottom_section'>
        <Button text='취소하기' type='negative' clickHandler={cancelHandler}/>
        <Button text='작성완료' type='positive' clickHandler={submitHandler}/>
      </div>
    </div>
  );
}

export default Editor;