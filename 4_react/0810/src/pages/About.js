import { useEffect } from "react";
import { Container } from "react-bootstrap";
const { kakao } = window;
const LATITUDE = 37.5412952;
const LONGITUDE = 126.8381811;
// const POSITION_ID = 1576534967;
const POSITION_URL = 'https://map.kakao.com/link/to/1576534967';

const About = () => {
  
  useEffect(() => {
    const maps =['', ''];

    //지도를 생성할 때 필요한 기본 옵션
    const options = { 
      center: new kakao.maps.LatLng(LATITUDE, LONGITUDE), //지도의 중심좌표.
      level: 2 //지도의 레벨(확대, 축소 정도)
    };
    
    // 마커를 생성합니다
    const markerPosition  = new kakao.maps.LatLng(LATITUDE, LONGITUDE); 
    const marker = new kakao.maps.Marker({
      position: markerPosition
    });
    const zoomControl = new kakao.maps.ZoomControl();

    // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    const iwContent = `<div style="padding:10px; margin-left: calc(75px - 64.17px / 2);">
                        <a href=${POSITION_URL} target="_blank">길찾기</a>
                      </div>`,
    iwPosition = new kakao.maps.LatLng(LATITUDE, LONGITUDE); //인포윈도우 표시 위치입니다
    // 인포윈도우를 생성합니다
    const infowindow = new kakao.maps.InfoWindow({
      position : iwPosition, 
      content : iwContent 
    });
    
    const containers = document.getElementsByClassName('kakao-map'); //지도를 담을 영역의 DOM 레퍼런스

    [0, 1].map(idx => {
      maps[idx] = new kakao.maps.Map(containers[idx], options);
      marker.setMap(maps[idx]); // 마커가 지도 위에 표시되도록 설정합니다
      maps[idx].addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
      infowindow.open(maps[idx], marker); // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
    })
  }, [])

  return (
    <Container className='About my-2'>
      <div className='kakao-map d-block d-md-none' style={{height:'calc(100vh - 173.33px - 65px - 2rem)'}}></div>
      <div className='kakao-map d-none d-md-block' style={{height:'calc(100vh - 120px - 80px - 2rem)'}}></div>
    </Container>
  );
}

export default About;