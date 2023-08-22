import { useNavigate } from 'react-router-dom';
import '../css/DiaryItem.css'
import Button from './Button';
import getEmotionImgById from '../utilities/util';
import { getFormattedDate } from '../utilities/getFormattedDate';
import { memo } from 'react';
const DiaryItem = ({id, date, emotionId, content}) => {
  const navigate = useNavigate();
  const goDiary = () => navigate(`/diary/${id}`);
  const goEdit = (e) => {
    e.stopPropagation();
    navigate(`/edit/${id}`);
  }
  return(
    <div className='DiaryItem' onClick={goDiary}>
      <div className={`img_section img_section_${emotionId}`}>
        <img src={getEmotionImgById(emotionId)} alt={emotionId}/>
      </div>
      <div className="info_section">
        {/* <div className="date_wrapper">{getFormattedDate(new Date(date))}</div> */}
        {/* <div className="date_wrapper">{new Date(date).toLocaleTimeString()}</div> */}
        <div className="date_wrapper">{new Date(date).toLocaleDateString('ko-KR')}</div>
        {/* locale... 지역코드 */}
        {/* <div className="date_wrapper">{new Date(date).toLocaleDateString('fr-FR')}</div> */}
        <div className="content_wrapper">{content.slice(0, 40)}</div>
      </div>
      <div className="button_section">
        <Button text='수정하기' clickHandler={goEdit} />
      </div>
    </div>
  );
}

export default memo(DiaryItem);