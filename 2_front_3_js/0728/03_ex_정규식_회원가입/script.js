// // 정규식 조건
// const regexId = /^\w{8,20}$/;
// const regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
// const regexMail = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
// const regexPhone = /^\d{2,3}-\d{3,4}-\d{4}$/;

// const id = document.querySelector('#id_txt');
// const idBtn = document.querySelector('#id_confirm');
// const idChk = document.querySelector('.id_input_check');
// let idConfirm = false;
// idBtn.addEventListener('click', (e)=>{
//   e.preventDefault(); // 새로고침 방지
//   let idtxt = id.value;
//   // console.log(`입력한 값의 적합성 : ${regexId.test(idtxt)}`);
//   idChk.innerHTML = `입력한 값의 적합성 : ${regexId.test(idtxt)}`;
//   if(regexId.test(idtxt)) {
//     idChk.style.color = 'blue';
//     idConfirm = true;
//   } else {
//     idChk.style.color = 'red';
//     idConfirm = false;
//   }
//   isPossible();
// });

// const pw = document.querySelector('#pw_txt');
// const pwBtn = document.querySelector('#pw_confirm');
// const pwChk = document.querySelector('.pw_input_check');
// let pwConfirm = false;
// pwBtn.addEventListener('click', (e)=>{
//   e.preventDefault(); // 새로고침 방지
//   let pwtxt = pw.value;
//   pwChk.innerHTML = `입력한 값의 적합성 : ${regexPw.test(pwtxt)}`;
//   if(regexPw.test(pwtxt)) {
//     pwChk.style.color = 'blue';
//     pwConfirm = true;
//   } else {
//     pwChk.style.color = 'red';
//     pwConfirm = false;
//   }
//   isPossible();
// });

// const email = document.querySelector('#email_txt');
// const emailBtn = document.querySelector('#email_confirm');
// const emailChk = document.querySelector('.email_input_check');
// let emailConfirm = false;
// emailBtn.addEventListener('click', (e)=>{
//   e.preventDefault(); // 새로고침 방지
//   let emailtxt = email.value;
//   emailChk.innerHTML = `입력한 값의 적합성 : ${regexMail.test(emailtxt)}`;
//   if(regexMail.test(emailtxt)) {
//     emailChk.style.color = 'blue';
//     emailConfirm = true;
//   } else {
//     emailChk.style.color = 'red';
//     emailConfirm = false;
//   }
//   isPossible();
// });

// const phone = document.querySelector('#phone_txt');
// const phoneBtn = document.querySelector('#phone_confirm');
// const phoneChk = document.querySelector('.phone_input_check');
// let phoneConfirm = false;
// phoneBtn.addEventListener('click', (e)=>{
//   e.preventDefault(); // 새로고침 방지
//   let phonetxt = phone.value;
//   phoneChk.innerHTML = `입력한 값의 적합성 : ${regexPhone.test(phonetxt)}`;
//   if(regexPhone.test(phonetxt)) {
//     phoneChk.style.color = 'blue';
//     phoneConfirm = true;
//   } else {
//     phoneChk.style.color = 'red';
//     phoneConfirm = false;
//   }
//   isPossible();
// });

// const reqBtn = document.querySelector('.reg_req_btn');
// function isPossible() {
//   if(idConfirm && pwConfirm && emailConfirm && phoneConfirm)
//     reqBtn.style.background = 'green';
//   else
//     reqBtn.style.background = 'darkgray';
// }
// ====================================================================================================
// 배열화 mine 굳이 배열 안 만들어도 되는 것까지 만든 측면이 있군...
// const regexId = /^\w{8,20}$/;
// const regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
// const regexMail = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
// const regexPhone = /^\d{2,3}-\d{3,4}-\d{4}$/;
// const regexArr = [regexId, regexPw, regexMail, regexPhone];
// const textArr = ['id', 'pw', 'email', 'phone'];
// const qTxts = [];
// const qBtns = [];
// const qChecks = [];
// let confirmArr = [false, false, false, false];
// const reqBtn = document.querySelector('.reg_req_btn');

// textArr.forEach((data, i)=>{
//   qTxts.push(document.querySelector(`#${data}_txt`));
//   qBtns.push(document.querySelector(`#${data}_confirm`));
//   qChecks.push(document.querySelector(`.${data}_input_check`));
//   qBtns[i].addEventListener('click', (e)=>{
//     e.preventDefault();
//     let inputTxt = qTxts[i].value;
//     qChecks[i].innerHTML = `입력한 값의 적합성 : ${regexArr[i].test(inputTxt)}`;
//     if(regexArr[i].test(inputTxt)) {
//       qChecks[i].style.color = 'blue';
//       confirmArr[i] = true;
//     } else {
//       qChecks[i].style.color = 'red';
//       confirmArr[i] = false;
//     }
//     let totalConfirm = true;
//     confirmArr.forEach((confirm)=> totalConfirm = confirm && totalConfirm);
//     if(totalConfirm)
//       reqBtn.style.background = 'green';
//     else
//       reqBtn.style.background = 'darkgray';
//   });
// });
// ====================================================================================================
// 함수형 (강사님 간략화 버전)
const regexId = /^\w{8,20}$/;
const regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
const regexMail = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
const regexPhone = /^\d{2,3}-\d{3,4}-\d{4}$/;
const regexs = [regexId, regexPw, regexMail, regexPhone];
const confirms = [false, false, false, false];
const btns = document.querySelectorAll('.input_confirm_btn');
const reqBtn = document.querySelector('.reg_req_btn');

btns.forEach((btn, i) => {
  btn.addEventListener('click', (e) => {
    e.preventDefault();
    const pTag = e.target.previousElementSibling;
    const inputTag = pTag.previousElementSibling;
    if (regexs[i].test(inputTag.value)) {
      pTag.style.color = 'blue';
      pTag.innerText = '사용 가능한 입력입니다.';
      confirms[i] = true;
    } else {
      pTag.style.color = 'red';
      pTag.innerText = '사용 불가능한 입력입니다.';
      confirms[i] = false;
    }
    if (!confirms.includes(false))
      reqBtn.style.background = 'green';
    else
      reqBtn.style.background = 'darkgray';
  });
});
