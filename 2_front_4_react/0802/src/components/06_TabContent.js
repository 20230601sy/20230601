import { useEffect, useState } from "react";

const TabContent = ({tabNo}) => {
  const [fade, setFade] = useState(null); 
  // useEffect(() => {
  //   setFade('end');
  //   return () => {
  //     setFade(null);
  //   }
  // }, [tabNo]);
  // 위 코드는 리액트 18버전부터 리액트 특성인 automatic 배칭? 때문에 안된다고 함
  // state는 모두 비동기처리함
  // queue에 쌓인 거를 일괄처리해주기 때문에 똑같은 state는 마지막에 처리된 거 한 게만 나오게 되는 거...
  // 정확하게는 마지막 변경 작업 끝난 후 랜더링된다고 생각하면 된다심
  useEffect(() => {
    let timer = setTimeout(() => {
      setFade('end');
    }, 10);
    return () => {
      clearTimeout(timer);
      setFade(null);
    }
  }, [tabNo]);
  // 임시로 이렇게 시간텀을 줘서 구현할 수는 있지만... 애초에 useEffect에는 state를 안 넣는 게 좋다심...
  return <div className={"start " + fade} style={{textAlign:'center'}}>{['상세정보', '리뷰', '반품, 교환정보'][tabNo]}</div>;
};

export default TabContent;