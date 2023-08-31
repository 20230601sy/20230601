const review = document.getElementById('review');
const stars = document.querySelectorAll('.star');
const list = document.querySelector('.review-list');
const submit = document.getElementById('submit-button');
let cntStar;

const setStar = () => {
  stars.forEach(star => star.className = "star ");
  for(let i=0; i<cntStar; i++)
    stars[i].className += "selected-star";
}

stars.forEach((star, i) => star.addEventListener('click', ()=> {
  cntStar = i + 1;
  setStar();
}));

submit.addEventListener('click', (e)=>{
  e.preventDefault();
  
  if(cntStar && review.value) {
    list.insertAdjacentHTML("beforeend", `<li>평점: ${cntStar} / 리뷰: ${review.value}</li>`);
    cntStar = 0;
    setStar();
    review.value='';
  }
});
