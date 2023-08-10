// 01_sample.js
let user = {
  name : '고길동',
};
let admin = user;
console.log(user);
console.log(admin);

user.name = '홍길동';
console.log(user);
console.log(admin); // '홍길동' 으로 변경됨
// object 자료형의 변수는 변수를 담는 공간 안에 주소값이 들어가는 거임. 자바와 동일
// 나름 중요한 개념. react하게 되면 중요한 개념이라심. 내용이 바뀌면 랜더링이 안된다심? ㄷㄷ

// 이런 것 때문에 내용만 단순히 복사하는 거 하고 싶을 때 여러 가지 방법이 있는데...
// 방법 1
user = {
  name : '고길동',
  age : 20
};
admin = {};
for(let key in user)
  admin[key] = user[key];
console.log(user);
console.log(admin);

user.name = '홍길동';
console.log(user);
console.log(admin); // 변경되지 않고 그대로 '고길동'

// 방법 2, js 나름 최신 문법
user = {
  name : '고길동',
  age : 20
};
admin = {...user}; // 반복문과 동일한 효과, ... 점 세 개는 중괄호를 깨주는 역할을 한다심... 그 상태에서 중괄호로 묶어주면 object형으로 다시 만들어주는... 주소값을 새로운 거로 만드는 거
// admin = { user }; 는 admin = { user : user }; 의 {{ ... }} 형태이기 때문에... ... 이 필요함.
// ...을 Spread 연산자라고 한다심
console.log(user);
console.log(admin);

user.name = '홍길동';
console.log(user);
console.log(admin); // 변경되지 않고 그대로 '고길동'

// ...은 배열도 동일함
let arr = [1, 2, 3, 4, 5];
// let copy = arr;
let copy = [...arr];
console.log(arr);
console.log(copy);
arr[0] = 5;
console.log(arr);
console.log(copy);

// ...을 활용하면 배열 합치기도 용이함
let arr2 = [10, 20, 30];
copy = [arr, arr2, 100];
copy2 = [...arr, ...arr2, 100];
console.log(copy); // 배열의 배열
console.log(copy2); // 1차원 통합된 배열, 이건 리액트하면 간간히 쓴다심

// 이제 키를 저장하는 변수를 만들고 싶을 때
user = {
  name : '고길동',
  age : 20
};
let name2 = user.name;
let age2 = user.age;
console.log(name2, age2); // 고길동 20

// 위에 걸 한 방에...Destructuring 디스트럭처링이라고 한다심. 나름 최신 문법
let {name, age} = user; // name, user 키값 이름은 동일해야 함. 있는 거 중에서만 빼옴, 없는 건 undefined 처리 해주는 듯
console.log(name, age); // 고길동 20

// 동일한 작업을 배열도 가능함, 배열은 순서대로 저장... 
arr = ['abc', 'qwer', 'zxc'];
let [first, second] = arr;
console.log(first, second);

// 함수지향 언어
// 클래스는 개념이 있긴 하지만 다루지는 않을 거라심
function person(name) {
  this.name = name;
  this.fn = () => console.log('hi');
}
let p1 = new person('홍길동'); // 자바에서 객체 생성하듯이 new라는 키워드가 있다심
console.log(p1); // person {name: '홍길동'}
p1.fn();
// 지난 시간에는 return 시켜줘서 new 키워드 사용하지 않았음, 약간의 차이가 있음
// 자바의 클래스 같은 개념과 유사...

// 기본적인 개념은 여기까지인데. 이제 어찌보면 가장 중요한 거(?) 쉬었다 한다심 헤헷