// import './App.css';
// import Container from 'react-bootstrap/Container';
// import Row from 'react-bootstrap/Row';
// import Col from 'react-bootstrap/Col';
// import { useEffect, useState } from 'react';
// import DisplayRow from './DisplayRow';
// import ReducedRow from './ReducedRow';

// function App() {
//   const IMG_PATH = 'https://20230601sy.github.io/0810/src/assets/';
//   const [num, setNum] = useState(new Array(729).fill(1));
//   const [set, isSet] = useState(new Array(729).fill(1));
//   const [simpleTable, setSimpleTable] = useState(new Array(81).fill(''));

//   useEffect(()=>{
//     for(let i=0; i<27; i++) {
//       for(let j=0; j<27; j++)
//         num[27*i+j] = 1 + (i%3)*3 + j%3;
//     }
//     setNum([...num]);
//   }, []);


//   return (
//     <div className="App">
//       <Container className='mt-5'>
//         <Row>
//           <Col>
//             <div className='mb-5' style={{height:'150px', width:"1000px", overflow:'hidden'}}>
//               <img src={`${IMG_PATH}thumbnail_sdk.png`} alt="" style={{width:"100%"}}/>
//             </div>
//           </Col>
//         </Row>
//         <Row>
//           <Col className='d-flex justify-content-center'>
//             <table id='num-table'>
//               {
//                 new Array(27).fill(1).map((_, i) => <DisplayRow y={i} num={num} setNum={setNum} set={set} isSet={isSet} simpleTable={simpleTable} setSimpleTable={setSimpleTable}/>)
//               }
//             </table>
//           </Col>
//           <Col className='d-flex justify-content-center'>
//             <table id='num-table'>
//               {
//                 new Array(9).fill(1).map((_, i) => <ReducedRow y={i} simpleTable={simpleTable}/>)
//               }
//             </table>
//           </Col>
//         </Row>
//       </Container>
//     </div>
//   );
// }

// export default App;
