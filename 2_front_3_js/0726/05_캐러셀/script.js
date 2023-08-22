// 캐러셀
// 이미지를 넘어가는 거 직접 구현할 거라심 부트스트랩에 있다심
const btn1 = document.querySelector('.btn1');
const btn2 = document.querySelector('.btn2');
const btn3 = document.querySelector('.btn3');
const carousel = document.querySelector('.carousel');

btn1.addEventListener('click', ()=>{
  carousel.style.transform = 'translateX(0)';
  index = 0;
});

btn2.addEventListener('click', ()=>{
  carousel.style.transform = 'translateX(-100vw)';
  index = 1;
});

btn3.addEventListener('click', ()=>{
  carousel.style.transform = 'translateX(-200vw)';
  index = 2;
});

const pre = document.querySelector('.pre');
const next = document.querySelector('.next');

let index = 0;
const num = 3;
pre.addEventListener('click', ()=>{
  index = (index - 1 + num) % num;
  carousel.style.transform = 'translateX(-' + index*100 + 'vw)';
});
next.addEventListener('click', ()=>{
  index = (index + 1) % num;
  carousel.style.transform = 'translateX(-' + index*100 + 'vw)';
});

const box = document.querySelectorAll('.box');

let interval = setInterval(()=>{
  index++;
  if(index >= num) {
    // carousel.lastChild.insertAdjacentHTML('beforeend', box[index%num]);
    // console.log(carousel.lastChild);
    index = 0;
  }
  carousel.style.transform = 'translateX(-' + index*100 + 'vw)';
}, 1000);

setTimeout(() => {
  clearInterval(interval);
}, 5000);

