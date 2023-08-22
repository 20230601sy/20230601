const input = document.querySelector('input');
const form = document.querySelector('form');
const list = document.querySelector('.list');

let todo = JSON.parse(localStorage.getItem('todo'));
if(todo===null)
  todo = [];
for(let i=0; i<todo.length; i++)
  list.insertAdjacentHTML("beforeend", `<li>${Object.values(todo[i])}<button>x</button></li>`)

form.addEventListener('submit', (e)=> {
  // console.log(e);
  // console.log(e.target);
  e.preventDefault();
  // alert(Date.now()); 로 key값
  // console.log(document.querySelector('input').value);
  // localStorage.setItem('todo', JSON.stringify(`[{ ${Date.now()} : ${input.value} }]`));
  todo.push({ [Date.now()] : input.value });
  localStorage.setItem('todo', JSON.stringify(todo));
  list.insertAdjacentHTML("beforeend", `<li>${input.value}<button>x</button></li>`)
  input.value = '';
});

list.addEventListener('click', (e)=>{
  let btns = document.querySelectorAll('.list>li>button');
  for(let i=0; i<btns.length; i++){
    if(e.target == btns[i]) {
      console.log(i);
      console.log(todo[i]);
      todo.splice(i, 1);
      localStorage.setItem('todo', JSON.stringify(todo));
      e.target.parentNode.remove();
    }
  }
});

// document.querySelector('input').addEventListener('enter', (e)=> {
//   e.preventDefault();
// });

/*
input val
local structure
showList
remove item
event area
*/

// 조만간 미니프로젝트 주제 제출하라고 할 거라심
// 주제 고민, 관심사로...