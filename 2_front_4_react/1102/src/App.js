import './App.css';
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Box1by1 from './Box1by1';
import { useState } from 'react';

function App() {
  const IMG_PATH = 'https://20230601sy.github.io/0810/src/assets/';

  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);
  const [num3, setNum3] = useState(0);
  const [num4, setNum4] = useState(0);
  const [num5, setNum5] = useState(0);
  const [num6, setNum6] = useState(0);
  const [num7, setNum7] = useState(0);
  const [num8, setNum8] = useState(0);
  const [num9, setNum9] = useState(0);

  const [num, setNum] = useState(new Array(27).fill(new Array(27).fill(0)));
  
  console.log('변경 전', num[0]);
  setNum()
  console.log('변경 후', num[0]);

  return (
    <div className="App">
      
      <Container className='mt-5'>
        <Row>
          <Col>
            <div className='mb-5' style={{height:'150px', width:"100%", overflow:'hidden'}}>
              <img src={`${IMG_PATH}thumbnail_sdk.png`} alt="" style={{width:"100%"}}/>
            </div>
          </Col>
        </Row>
        <Row>
          <Col className='d-flex justify-content-center'>
            <table>
                <tr>
                  <td><Box1by1 num={num1} setNum={setNum1}/></td>
                  <td><Box1by1 num={num2} setNum={setNum2}/></td>
                  <td><Box1by1 num={num3} setNum={setNum3}/></td>
                </tr>
                <tr>
                  <td><Box1by1 num={num4} setNum={setNum4}/></td>
                  <td><Box1by1 num={num5} setNum={setNum5}/></td>
                  <td><Box1by1 num={num6} setNum={setNum6}/></td>
                </tr>
                <tr>
                  <td><Box1by1 num={num7} setNum={setNum7}/></td>
                  <td><Box1by1 num={num8} setNum={setNum8}/></td>
                  <td><Box1by1 num={num9} setNum={setNum9}/></td>
                </tr>
            </table>
          </Col>
        </Row>
      </Container>      
      
    </div>
  );
}

export default App;
