document.querySelector('#form').addEventListener('click', (e)=>{
  // console.log(e.target.tagName);
  // 이벤트작업은 form 태그에 작업해줬지만...
  // p태그를 클릭하면 e.target은 p태그를 출력해줌
  // this도 이벤트를 잡아준다시는데 나중에 설명해주신다심...

  console.log(this);
  console.log(this.event);
  alert('form태그 핸들러');
});

document.querySelector('p').addEventListener('click', (e)=>{
  alert('p태그 핸들러');
  // 이상태로는 2번 p → form alert됨
  e.stopPropagation(); // e 객체의 stopPropagation 함수를 호출하면 버블링 전파 막아줌!
});