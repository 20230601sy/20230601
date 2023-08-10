// 04_property.js
let div = document.createElement('div'); // 태그 만들어주는 거... 지금은 빈 div만 만듬

div.className = 'alert';
div.innerHTML = '새로만든 div';

// document.body.append(div); // 기존에 있는 거 뒤에 추가... 이제 html에 요소를 직접 추가할 수 있게 됨 굿
// document.body.prepend(div); // 처음에 추가
// document.body.before(div); // 해당 요소 이전에 추가, body 바깥에 있어...마진이 벗어남, 개발자도구에서 확인해보면 그렇게 되어 있음
// document.body.after(div); // 해당 요소 이후에 추가, after도 before와 마찬가지

let test = document.getElementById('test');
test.insertAdjacentHTML("beforebegin", '<p>hi</p>'); // (위치, 넣을 내용), before랑 유사함, 넣을 내용은 html 코드, 보통은 내용이 길어지니까 변수에 담아서 씀
test.insertAdjacentHTML("afterend", '<p>bye</p>');
test.insertAdjacentHTML("beforeend", '<p>태그 내부 안쪽 마지막에 추가</p>');
test.insertAdjacentHTML("afterbegin", '<p>태그 내부 안쪽 처음에 추가</p>');

let a = '<div class="alert"><b>변수로 추가</b></div>';
test.lastChild.insertAdjacentHTML("beforebegin", a);

// 삭제
test.remove(); // id가 test인 요소 삭제됨
console.log(test); // remove를 한다고 해서 변수가 지워지는 거는 아님, 화면상 출력되는 요소만 지워지는 거임, 그래서 아래 복사할 수 있음, 또 cloneNode 결과 보면, html 내용만 들어가 있는 게 아니고 js에서 추가한 내용까지 들어가 있다는 것도 확인할 수 있음

let test2 = test.cloneNode(true); // true나 false가 들어감
document.body.append(test2);

test2 = test.cloneNode(false); // false로 하면 자식 노드를 복사하지 않기 때문에 껍데기만 복사됨
document.body.prepend(test2);

// 접근하는 거 구버전 명령어 몇개 더 있긴 한데 그런 건 안할 거라심