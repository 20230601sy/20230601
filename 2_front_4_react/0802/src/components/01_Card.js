// const Card = ({fruits}) => {
//   return (
//     <div>
//       {/* <div className="col-md-4">
//         <img src={process.env.PUBLIC_URL + 'images/' + fruit[0].title + '.jpg'} style={{width : '90%'}} />
//         <h4>{fruit[0].title}</h4>
//         <p>{fruit[0].price}</p>
//       </div>
//       <div className="col-md-4">
//         <img src={process.env.PUBLIC_URL + 'images/strawberry.jpg'} style={{width : '90%'}} />
//         <h4>strawberry</h4>
//         <p>10000</p>
//       </div>
//       <div className="col-md-4">
//         <img src={process.env.PUBLIC_URL + 'images/watermelon.jpg'} style={{width : '90%'}} />
//         <h4>watermelon</h4>
//         <p>20000</p>
//       </div> */}
//       {
//         fruits.map((fruit) => {
//           return(
//             <div className="col-md-4" style={{textAlign:'center'}}>
//               <img src={process.env.PUBLIC_URL + 'images/' + fruit.title + '.jpg'} style={{width : '80%'}} />
//               <h4 className="mt-2">{fruit.title}</h4>
//               <p>{fruit.price.toLocaleString()}원</p>
//             </div>
//           );
//         })
//       }
//     </div>
//   );
// }

// const Card = ({fruit}) => {
//   return (
//     <div className="col-md-4" style={{textAlign:'center'}}>
//       <img src={process.env.PUBLIC_URL + `images/${fruit.title}.jpg`} style={{width : '80%'}} />
//       <h4 className="mt-2">{fruit.title}</h4>
//       <p>{fruit.price.toLocaleString()}원</p>
//     </div>
//   );
// }

import { useNavigate } from "react-router-dom";
const Card = ({fruit}) => {
  const navigate = useNavigate();
  return (
    <div className="col-md-4" style={{textAlign:'center', cursor:'pointer'}} onClick={() => {navigate(`/detail/${fruit.id}`)}}>
      {/* <img src={process.env.PUBLIC_URL + `images/${fruit.title}.jpg`} style={{width : '80%'}} /> */}
      <img src={`https://raw.githubusercontent.com/Naessss/study/main/${fruit.title}.jpg`} style={{width : '80%'}} />
      <h4 className="mt-2">{fruit.title}</h4>
      <p>{fruit.price.toLocaleString()}원</p>
    </div>
  );
}
export default Card;