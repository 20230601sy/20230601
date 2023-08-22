import { Container, Row, Col, Table } from "react-bootstrap";
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from "recharts";
import { useEffect, useRef, useState } from "react";
import { salesList } from '../constants/salesList';

const Chart = ({width}) => {
  const [salesData, setSalesData] = useState(salesList);
  // const [width, setWidth] = useState(1000);
  const ref = useRef(null);
  const height = 500;
  const colItems = ['month', 'snack', 'icecream', 'beverage'];

  // useEffect(() => {
  //   setWidth(ref.current.clientWidth*0.9);
  // }, [ref])
  // const {width} = useSelector(state=>state.windowSize);
  let cWidth = width/3;
  // alert(width);
  return (
    <Container className='Chart mt-2'>
      <Row>
        <Col>
          <h1>{new Date().getFullYear()}년 매출</h1>
        </Col>
      </Row>
      <Row>
        <Col xs={12} md={6} ref={ref}>
          <BarChart className='mt-5' width={cWidth} height={height} data={salesData}>
          {/* <BarChart className='mt-5' width={window.innerWidth*0.4} height={window.innerHeight*0.6} data={salesData}> */}
            <XAxis dataKey="name" />
            <YAxis />
            <CartesianGrid strokeDasharray="3 3" />
            <Tooltip />
            <Legend />
            <Bar dataKey="snack" stackId="a" fill="#2578c4" />
            <Bar dataKey="icecream" stackId="a" fill="#ececec" />
            <Bar dataKey="beverage" stackId="a" fill="#8bc6e4" />
          </BarChart>
        </Col>
        <Col xs={12} md={6}>
          <Table responsive>
            <thead>
              <tr>
                {
                  colItems.map(item => <th key={item}>{item}</th>)
                }
              </tr>
              {
                salesData.map(item => { 
                  return (
                    <tr key={item.month}>
                      {
                        colItems.map(content => {
                          return (
                            <th key={`${item.month}-${content}`} data-nth={Number(item.month)-1} data-content={content} onClick={(e)=>{ 
                              const nth = e.target.dataset.nth;
                              const content = e.target.dataset.content;
                              let newValue = prompt('수정할 값을 입력하세요.');
                              salesData[nth] = {...salesData[nth], [content] : newValue};
                              setSalesData([...salesData]);
                              e.target.style.color = '#8bc6e4';
                            }}>
                              {item[content]? item[content] : '' }
                            </th>
                          );
                        })
                      }
                    </tr>
                  );
                })
              }
            </thead>
          </Table>
        </Col>
      </Row>
      <Container className='mt-2' style={{height:'80px'}}></Container>
    </Container>
  );
}

export default Chart;