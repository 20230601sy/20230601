import { useContext, useEffect, useState } from "react";
import Button from "../components/Button";
import Editor from "../components/Editor";
import Header from "../components/Header";
import { DiaryStateContext } from "../App";
import { getMonthRangeByDate } from "../utilities/getMonthRangeByDate";
import DiaryList from "../components/DiaryList";
import { setPageTitle } from "../utilities/setPageTitle";

const Home = () => {
  const [pivotDate, setPivotDate] = useState(new Date());
  const headerTitle = `${pivotDate.getFullYear()}년 ${String(pivotDate.getMonth()+1).padStart(2, 0)}월`;

  const onIncreaseMonth = () => setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()+1)); // new Date(2023, 3) 2023년 4월 1일 날짜 생성됨, month 0-11 넘어가면 year 자동 수정되나봄
  const onDecreaseMonth = () => setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()-1));

  const data = useContext(DiaryStateContext); // useContext 훅을 사용하면 state를 data로 불러오게 됨
  const [filterData, setFilterData] = useState([]);

  useEffect(() => {
    setPageTitle('Diary');
  }, [])
  useEffect(() => {
    if(data.length > 0) {
      const {startTimeStamp, endTimeStamp} = getMonthRangeByDate(pivotDate);
      setFilterData(
        data.filter((d) => startTimeStamp <= d.date && d.date < endTimeStamp)
      )
    }
  }, [data, pivotDate])
  return(
    <div>
      {/* <Header title={'Home'}
        leftChild={<Button text={'확인'} type={'positive'} />}
        rightChild={<Button text={'취소'} type={'negative'} />} /> */}
      {/* <Editor initData={''} onSubmit={()=>alert('hi')}/> */}
      {/* <Editor initData={{date : new Date(). getTime(), emotionId: 5, content: '임시작성 데이터'}} onSubmit={()=>alert('hi')}/> */}
      {/* <Editor initData={{date : 1680000000000, emotionId: 5, content: '임시작성 데이터'}} onSubmit={()=>alert('hi')}/> */}
      <Header title={headerTitle}
              leftChild={<Button text={'<'} clickHandler={onDecreaseMonth}/>}
              rightChild={<Button text={'>'} clickHandler={onIncreaseMonth}/>} />
      
      <DiaryList filterData={filterData}/>
    </div>
  );
}
export default Home;