import { useDaumPostcodePopup } from "react-daum-postcode";
import { postcodeScriptUrl } from "react-daum-postcode/lib/loadPostcode";

function Post({setAddress, setPostcode}) {

  const open = useDaumPostcodePopup(postcodeScriptUrl);

  const handleComplete = (data) => {
    let fullAddress = data.address;
    let extraAddress = '';

    if (data.addressType === 'R') {
      if (data.bname !== '')
        extraAddress += data.bname;
      if (data.buildingName !== '')
        extraAddress += extraAddress !== '' ? `, ${data.buildingName}` : data.buildingName;
      fullAddress += extraAddress !== '' ? ` (${extraAddress})` : '';
    }

//    console.log(fullAddress); // e.g. '서울 성동구 왕십리로2길 20 (성수동1가)'
    setAddress(fullAddress);
    setPostcode(data.zonecode);
  }
  //클릭 시 발생할 이벤트
  const handleClick = () => {
  	open({onComplete: handleComplete});
  }
  
  return <button type="button" onClick={handleClick}>우편번호, 주소 찾기</button>
 }

export default Post;