import { useContext, useEffect, useState } from "react";
import { DiaryStateContext } from "../App";
import { useNavigate, useParams } from "react-router-dom";

const useDiary = (id) => {
  {/* ----------------------------------------------------------------------------------------------------
      custom Hook 
      react hook의 경우 component 영역 안에서만 동작하는 제약이 있음
      생성 규칙
      이름 useXXX use로 시작
      구현 내장 Hook을 이용하여 구현...
      구조는 함수와 동일한데 일반 함수 구현은 바닐라js이기 때문에 리액트 훅 사용 불가...
      결국 리액트 훅 사용하는 함수가 custom Hook이라고 볼 수 있음... 결국 그게 그거...
      폴더에 몰아서 관리함

      해당 diary 선택하면 선택한 diary만 반환시키고 잘못된 url로 접근하면 알려주고 main으로 가는 훅을 만들거라심

      Diary 컴포넌트 마운트
      useDiary 훅 호출
      훅에서 return 일단 먼저 처리
      비어있는 diary 반환 시 문제 생길 수 있음... Diary에 관련 작업...까지 항상 보수적으로 작업할 것!
    ---------------------------------------------------------------------------------------------------- */}
  const data = useContext(DiaryStateContext);
  const [diary, setDiary] = useState();
  const navigate = useNavigate();

  useEffect(() => {
    const matchDiary = data.find((d) => String(d.id) === String(id));

    if(matchDiary)
      setDiary(matchDiary);
    else {
      alert('해당하는 내역이 없습니다.');
      // navigate('/');
      navigate('/', {replace:true}); // 뒤로가기 안되게 하기!
    }
  }, [id, diary])
  return diary;
}

export default useDiary;