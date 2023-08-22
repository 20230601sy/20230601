// Current weather data
// https://openweathermap.org/current   API doc 문서
// subscribe free email 인증
// 키 발급 : 84b14d23ddd4bfd0cedeaa0a68dd4956
// 키 발급이 오래 걸리는 곳은 하루 정도 걸릴 수 있으니 API 쓸 때는 키 발급부터 준비하라심!

// API call
// https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
// https://api.openweathermap.org/data/2.5/weather?lat=37.5666791&lon=126.9782914&appid=84b14d23ddd4bfd0cedeaa0a68dd4956

// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%84%9C%EC%9A%B8+%EA%B2%BD%EB%8F%84+%EC%9C%84%EB%8F%84
// 쿼리스트링 where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%84%9C%EC%9A%B8+%EA%B2%BD%EB%8F%84+%EC%9C%84%EB%8F%84
// 요청정보

// http://api.openweathermap.org/geo/1.0/direct?q=Seoul&limit=5&appid=84b14d23ddd4bfd0cedeaa0a68dd4956

// 우리나라에서 제공하는 api 오픈 API https://www.data.go.kr/
// 미세먼지 https://www.data.go.kr/data/15073885/openapi.do

// 자바스크립트 안에 위치 정보를 알려주는 객체가 따로 있다심
// navigator.geolocation.getCurrentPosition(함수, 함수)
// navigator.geolocation.getCurrentPosition(위치를 허용했을 때 실행할 함수, 위치를 차단했을 때 실행할 함수)
// geolocation이라는 데는 국내 회사인걸로 알고 있고 주기적으로 업데이트 많이 사용하는 중이라심
// let lat;
// let lon;
function connect(position) {
  // alert('위치 허용함');
  // console.log(position);
  // console.log(position.coords);
  // accuracy: 1428.5927270792643
  // altitude: null
  // altitudeAccuracy: null
  // heading: null
  // latitude: 37.5441552
  // longitude: 126.8367073
  // console.log('lat:', position.coords.latitude, 'lon:', position.coords.longitude);
  let lat = position.coords.latitude;
  let lon = position.coords.longitude;
  const API_KEY = `84b14d23ddd4bfd0cedeaa0a68dd4956`;
  const URL = `https://api.openweathermap.org/data/2.5/weather?`
                + `lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
  // console.log(URL);
  // 클릭하면 안 예쁘게 일자로 보여주는 데... 크롬확장프로그램 설치하면 됨 JSON 검색 후 viewer 아무거나 설치하면 되는데
  // JSON Viewer 확장프로그램 추가해줬음 새로고침하면 계층 형태로 보여줌...
  // 온도가 켈빈단위여서 섭씨로 보이게 url에 &units=metric 붙여줌
  fetch(URL)
    .then((response) => response.json())
    .then((data) =>{
      // console.log(data);
      // console.log('weather main : ', data.weather[0].main);
      // console.log('main temp : ', data.main.temp);
      const p = document.createElement('p');
      p.innerHTML = `${data.name}의 날씨 : ${data.weather[0].main}, 온도 : ${data.main.temp}`;
      document.querySelector('.content').append(p);
    })
    .catch(() => console.log('요청실패'));
  
}
function error() {
  // alert('위치 차단함');
}
navigator.geolocation.getCurrentPosition(connect, error);
// 이건 좌표값알려고 하는 거였지 특별히 API 사용한 건 아님
// 허용하면 위치정보가 position으로 들어감

// https://api.openweathermap.org/data/2.5/weather?lat=37.5441552&lon=126.8367073&appid=84b14d23ddd4bfd0cedeaa0a68dd4956
// 실제로는 url에 정보를 담아서 보내지는 않는다고 하심...
// 클라이언트는 위도, 경도, API키를 요청 보내야함 
// 서버는 클라이언트가 보낸 위도, 경도, API키를 이용해서 날씨정보를 처리해서 다시 클라이언트에게 응답
// 흐름은 request reponse 의 기본 구조임
// 어떤 식으로 요청을 날려야 처리를 해줄 거다라고 하는 기준이라는 게 API doc 문서에 정리되어 있는 거...
// base url?lat=보낼 값&lon=보낼 값&appid=보낼 값 ... option도 추가해서 보낼 수 있음 &mode=보낼 값... 같은 거 양식에 맞게만 추가해서 보내면 됨...
// 서버 측 구현은 아마도 ... 요청 받으면 처리할 메서드(lat, lon, appid) { 처리할 코드 return } 요런 식일 거라심...