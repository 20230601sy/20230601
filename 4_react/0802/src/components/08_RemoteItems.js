import { Button } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from 'react-router-dom';
import { addRemoteItem } from "../redux/store";

const RemoteItems = ({fruits}) => {
  const remoteIds = useSelector(state => state.remoteItems);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  return (
    <div style={{background : 'rgba(0, 0, 0, 0.5', width : '110px', padding:'5px 5px 0 5px', borderRadius:'7px', position:'fixed', top:'30%', right:'5px', zIndex:'2'}}>
      <p style={{textAlign:'center', color:'white', fontSize : '16px', marginBottom:'5px'}}>최근 본 상품</p>
      {
        remoteIds.map((id) => {
          return (
            <Button variant="light" style={{padding : '5px', marginBottom : '5px'}} onClick={() => {
                let watchedItems = JSON.parse(localStorage.getItem('watched'));
                watchedItems = [id, ...watchedItems];
                watchedItems = Array.from(new Set(watchedItems));
                watchedItems.splice(3, 1);
                localStorage.setItem('watched', JSON.stringify(watchedItems));
                dispatch(addRemoteItem(watchedItems));
                navigate(`/detail/${id}`);
              }}>
              <img src={`https://raw.githubusercontent.com/Naessss/study/main/${fruits[id].title}.jpg`} width="100%" style ={{borderRadius:'5px'}}/>
              <p style={{margin:'0'}}>{fruits[id].title}</p>
            </Button>
          );
        })
      }
    </div>
  );
}
export default RemoteItems;