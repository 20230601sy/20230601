import Button from "./Button";
import '../css/DiaryList.css';
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import DiaryItem from "./DiaryItem";

const sortOptionList = [
  { value : 'latest', name : '최신순'},
  { value : 'oldest', name : '오래된순'}
]

const DiaryList = ({filterData}) => {
  const [sortType, setSortType] = useState('latest');
  const [sortData, setSortData] = useState([]);
  const changeSortTypeHandler = (e) => {
    setSortType(e.target.value);
  };
  const navigate = useNavigate();

  useEffect(() => {
    const compare = (a, b) => {
      if(sortType === 'latest')
        return Number(b.date)-Number(a.date);
      else
        return Number(a.date)-Number(b.date);
    }
    const copyList = [...filterData];
    copyList.sort(compare);
    setSortData(copyList);
  }, [filterData, sortType]);
  return(
    <div className="DiaryList">
      <div className="menu_wrapper">
        <div className="left_col">
          <select value={sortType} onChange={changeSortTypeHandler}>
            {
              sortOptionList.map((data, i) => <option key={i} value={data.value}>{data.name}</option>)
            }
          </select>
        </div>
        <div className="right_col">
          <Button text={'새 다이어리 작성'} type={'positive'} clickHandler={() => navigate('/new')}/>
        </div>
      </div>
      <div className="list_wrapper">
        {
          // sortData.map((data, i) => <DiaryItem key={i} {...data}/>)
          sortData.map((data) => <DiaryItem key={data.id} {...data}/>)
        }
      </div>
    </div>
  );
}

export default DiaryList;