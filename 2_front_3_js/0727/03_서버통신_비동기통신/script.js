// 비동기 통신
// 서버랑 통신한다고 유투브 못 보고 그러면 안 되니깐...setTimeout에서 했던 거 같은 비동기 방식이 사용되어야 함
// 여러 라이브러리 이용하는 것도 있는데
// 여기서는 3가지 다룰 거라심
// 1. 옛날부터 쓰던 역사와 전통의 고전 방식
// 2. 버전 업방식
// 3. jQuery 방식

// // 1.
// // XMLhttpRequest 객체 사용
// // http는 프로토콜 통신 규약
// // 과거에는 XML로만 주고 받았음
// const xhr = new XMLHttpRequest();
// // xhr.open('get', 'naver.com'); // 요청방식, 서버주소
// xhr.open('get', 'https://jsonplaceholder.typicode.com/posts');
// // form 처럼 get, post 그리고 put이나 delete 2개 더 있는데 나중에 볼거고, 주로 get, post 쓴다심
// // 뭔가 포함해서 보낼 때, 보통은 헤더와 바디를 날려주는데... 
// // 헤더는 실제 눈에 보이지 않는 기본적인 정보들 언제 보낸 건지, 보낼 정보 형식 등등
// // 바디는 실제 보내려는 정보들 넣어주면 됨
// xhr.setRequestHeader('content-type', 'application/json');
//                                       // 텍스트 보낼 때는 'text/plain', 여러 개 파일 보낼 때는 multipart/formdata??? 요새 이 방식이 너무 힘들고 귀찮아서 잘 안 쓴다고 쓰기 전에 지워짐ㅠㅠ
// let data = {
//   id: 1,
//   name: '홍길동',
//   age: 20
// };
// // 여기까지가 보내기 전 세팅 과정

// // xhr.send(); // 보낼 data가 없을 때
// xhr.send(JSON.stringify(data)); // 보낼 데이터는 직렬화?해서...

// // 지금 서버가 딱히 없으니까
// // 남들이 만들어둔 서버 가져다 쓰자심
// // 임시이미지처럼 jsonplaceholder라는 것도 있다심
// // jsonplaceholder 검색 후 https://jsonplaceholder.typicode.com/ 진입해보면...
// // Routes 
// // All HTTP methods are supported. You can use http or https for your requests.
// // GET	/posts
// // GET	/posts/1
// // GET	/posts/1/comments
// // GET	/comments?postId=1
// // POST	/posts
// // PUT	/posts/1
// // PATCH	/posts/1
// // DELETE	/posts/1
// // get요청을 날릴 수 있는 주소 https://jsonplaceholder.typicode.com/posts 를 골라서 아까 서버 주소에 넣음
// // resources 에 응답 내용 정리되어 있음
// // /posts 클릭하면...
// // [
// //   {
// //     "userId": 1,
// //     "id": 1,
// //     "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
// //     "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
// //   },
// //   {
// //     "userId": 1,
// //     "id": 2,
// //     "title": "qui est esse",
// //     "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
// //   },

// // 응답해주면 그 데이터를 처리하는 작업도 해야 함
// xhr.onload = ()=>{
//   // status 값의 종류도 많은데, 성공은 200, 400라인들은 잘못된거 404 같은 거 500라인도 있다심
//   if(xhr.status === 200) { // 200이 송수신 모두 성공해야 하는 거려나 이건 프로토콜에 정의되어 있겠지...
//     // 상태 코드
//     // 상태 코드 종류
//     // 200 : 요청성공
//     // 클라이언트 오류
//     // 401 : 인증안됨 // 인증 키를 발급받아서 날린다심...
//     // 403 : 요청 소스 못찾음
//     // 404 : 요청 페이지 없음
//     // 408 : 시간 초과
//     // 서버오류
//     // 500 : 서버 내부 오류
//     // 503 : 서버 사용 불가
//     const res = JSON.parse(xhr.response); // response는 응답 객체, 문자열이기 때문에 parse해줘야 한다심
//     console.log(res);
//   } else {
//     console.error(xhr.status, xhr.statusText); // error하면 빨간색으로 출력됨!
//   }
// }
// // 저장하면... 저장함과 동시에 날라올 거라심... 이벤트 처리 같은 거 안 했기 때문에....
// // 응답 날라오면 이제 사이버 상하차하면 된다심 ㅋㅋㅋㅋㅋㅋㅋ
// // res 에 들어 있는 100개 한땀 한땀 옮기면 되겠구려 허허.

// // 2. ajax
// // 이게 구현
// // jQuery 방식이기 때문에 html에 jquery 링크 잘 걸려 있어야 한다심
// // 비동기 처리 방식이고 새로고침이 안되게 구현된
// // 헤더를 보내지 않고 데이터만 보내면 되서 좋다심
// // json 형태의 변환도 알아서 해주기 때문에 좋다심 이게 가장 큰 장점이라심...
// $.get('https://jsonplaceholder.typicode.com/posts')
//   .done((response)=>{ // 요청 성공했을 때 구현한 코드...
//     console.log(response);
//   })
//   .fail(()=>{
//     console.log('요청실패');
//   })

// 이런 거를 이제 이벤트 리스너에 넣어서 써야 함...
// https://raw.githubusercontent.com/Naessss/study/main/fruit.json 
// 강사님이 만들어두신 서버 테스트
// let fruit;
// $('.btn').on('click', ()=>{
//   $.get('https://raw.githubusercontent.com/Naessss/study/main/fruit.json')
//     .done((data) => { // data, result, response 등의 명칭을 사용한다심
//       $('.content').html(data);
//       fruit = data;
//       console.log(fruit, typeof fruit);
//       // 뿌리는 건 이따가 openAPI 사용해서 할 거라심
//     })
//     .fail(()=>{
//       alert('요청 실패');
//     })
// });

// 이런 비동기통신
// Ajax를 왜 ajax라고 하냐면 새로 고침이 안되기 때문이라심
// ajax의 대표적인 예가 연관검색어! 검색어 칠 때 새로고침되면 검색어 치던게 사라지면 안 되잖슴!
// ajax 편해서 종종 쓸 건데
// 리액트는 엑시오스? 무슨 라이브러리 쓴다심
// 쌩자바는 jquery 안되기 때문에 fetch라는 걸 사용한다심

// 3 쌩자바 fetch 몇 단계를 거쳐야 함...
// fetch('https://jsonplaceholder.typicode.com/posts/1')
//   .then((response) => response.json())
//   .then((data) => console.log(data))
//   .catch(() => console.log('요청실패'));
// 프라미스? 객체를 사용하는 거라심
// 요청을 날리고 성공하면 첫번째 then이 실행됨
// 응답객체를 배열 혹은 오브젝트 형태로 .json() 이 변환시킨다음 리턴시킴 .json이 parse 같은 거라심
// response가 두번째 then의 data로 들어가서 작업
// 형식은 보내는 거 나중에 할 때 다시 정리한다심
// 지금은 갖춰진 게 없어서... 포스트렉? 같은 거 설치해서 본다심 그 파란코끼리인가???
// 방식은 비슷할 거라심
// 카카오지도라든지 네이버이메일이라든지... 다 문서화 시켜져 있다심
// https://developers.kakao.com/
// https://apis.map.kakao.com/web/guide/
// 이런 건 카카오 많이 가져다 쓰는 게 한글로 되어 있어서라심 ㅋㅋㅋ
// 다른 건 다 영어로 되어 있다심 ㄷㄷ

// 프라미스 객체 비동기 제어를 해줄 수 있는 객체
// 프론트쪽 나가면 알아야 한다심 프로미스 어싱크 어웨이 형제들은 무조건 해야 한다심...
// 비동기처리할 수 있는 걸 fetch같은 걸 이용하지 않고 내가 직접 만들 수 있는 게 프라미스라는 것이라심
const p = new Promise(function(resolve, reject){
  // 성공했을 때 담을 매개변수가 resolve이고 실패했을 때 담을 매개변수가 reject라심
  // 처리할 코드
  setTimeout(()=>{
    // resolve('성공');
    // 강제로 에러를 발생 시킴, 성공 실패를 둘다 담을 수는 없어서 윗줄 테스트 후 주석처리함
    reject(new Error('실패'));
  }, 3000);
});

p.then((data)=>{
  console.log(data);
})
.catch((error) => {
  console.log(error);
})

// https://openweathermap.org/
// 날씨 뿌려주는 api 회원가입 ㄱㄱ 하라심
// 키 발급 받으려면 회원가입 거의다 해야 할 거라심