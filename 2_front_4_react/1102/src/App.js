import './App.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { useEffect, useState } from 'react';
import DisplayRow from './DisplayRow';
import cloneDeep from 'lodash/cloneDeep';

function App() {
  const IMG_PATH = 'https://20230601sy.github.io/0810/src/assets/';
  const [num, setNum] = useState(new Array(729).fill(1));
  const [set, isSet] = useState(new Array(729).fill(1));

  useEffect(()=>{
    for(let i=0; i<27; i++) {
      for(let j=0; j<27; j++)
        num[27*i+j] = 1 + (i%3)*3 + j%3;
    }
    // for(let j=0; j<27; j++)
    //   num[j] = '';
    setNum([...num]);
  }, []);
  
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
              {
                new Array(27).fill(1).map((_, i) => <DisplayRow y={i} setNum={setNum} num={num} set={set} isSet={isSet}/>)
              }
            </table>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
