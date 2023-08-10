const todos = document.getElementById('todos');
const todoList = document.querySelector('.todo-list');
const todoInput = document.querySelector('#todos > input');

let arrTodo = JSON.parse(localStorage.getItem('todos'));
if(arrTodo === null)
  arrTodo = [];
arrTodo.forEach((data) => {showTodo(data);});

// 함수에는 보통 주석을 안 다는데, 왜냐하면 함수 이름이 주석이기 때문이라심 오오 이거 멋지당ㅎ
// todo를 전송할 때 실행되는 함수
function todoSubmit(e) {
  e.preventDefault(); // 이제 기능 구현은 다 되어서 지금 단계에서는 제거해도 상관 없지만 새로고침 되는 거 방지를 해주기도 하고, 좀더 정확하게는 서버로 데이터를 전송하는 걸 막아놓는 용도로 남겨놓는 게 좋음...
  // console.log(todoInput.value);
  let newTodo = todoInput.value;
  let newTodoObj = {
    'key' : Date.now(),
    'text' : newTodo
  }
  arrTodo.push(newTodoObj);
  saveTodos();
  showTodo(newTodoObj);
  todoInput.value = '';
}

function saveTodos() {
  localStorage.setItem('todos', JSON.stringify(arrTodo));
}
// 내용을 받아와서 화면에 표시해주는 함수
function showTodo(newTodoObj) {
  const li = document.createElement('li');
  const button = document.createElement('button');
  button.innerHTML = 'x';
  button.addEventListener('click', deleteTodo); // 이러면 반복문을 피할 수 있긴 하군...
  // li.dataset.append(newTodoObj.key);
  li.id = newTodoObj.key;
  li.innerHTML = newTodoObj.text;
  li.append(button); // 와 이게 되네ㅋㅋㅋ 무식하게 쓰고 있었고만ㅠㅋㅋㅋ
  todoList.append(li);
}

function deleteTodo(e) {
  // console.log('delete');
  // console.log(e.target.parentElement);
  const removeLi = e.target.parentElement;
  removeLi.remove();
  // 로컬스토리지에 있는 것도 지워야 함
  // let text = removeLi.innerText;
  // text = text.slice(0, text.length-1);
  if(arrTodo.length == 1){
    arrTodo = [];
    localStorage.removeItem('todos');
  } else {
    arrTodo = arrTodo.filter((data) => data.key != removeLi.id);
    saveTodos();
  }
}
todos.addEventListener('submit', todoSubmit);