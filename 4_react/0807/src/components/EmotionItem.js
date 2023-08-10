import '../css/EmotionItem.css';
import { memo } from 'react';

const EmotionItem = ({ id, img, name, onClick, isSelected }) => {
  const onClickHandler = () => {
    onClick(id);
  };

  return (
    <div className={"EmotionItem EmotionItem_"+(isSelected ? `on_${id}` : 'off')} onClick={onClickHandler}>
      <img src={img} alt={`emotion${id}`} />
      <span>{name}</span>
    </div>
  );
};

export default memo(EmotionItem);