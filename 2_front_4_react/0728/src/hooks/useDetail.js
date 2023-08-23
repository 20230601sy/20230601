import { useDispatch, useSelector } from "react-redux";
import { setDetailItem } from "../redux/store";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const useDetail = (id) => {
  const {totalItems, detailItem} = useSelector(state=>state);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  useEffect(() => {
    const targetItem = totalItems.find(item => Number(item.id) === Number(id));
    if(targetItem)
      dispatch(setDetailItem(targetItem));
    else 
      navigate('/');
  }, [id, detailItem]);
  return detailItem;
}

export default useDetail;