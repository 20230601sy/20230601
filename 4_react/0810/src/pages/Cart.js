import { Container, Table } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { incCnt, decCnt, deleteItemFromCart } from "../redux/store";
import { BG_COLOR, BG_COLOR_SECOND } from "../constants/color";
import Chart from "./Chart";

const Cart = ({width}) => {
  const dispatch = useDispatch();
  const {loginState, cartItems} = useSelector(state => state);

  if(loginState==='admin' || loginState==='manager')
    return <Chart width={width}/>

  if(cartItems.length === 0)
    return <Container className='Cart mt-2'>표시할 상품이 없습니다.</Container>;

  return (
    <Container className='Cart mt-2'>
      <Table style={{textAlign : 'center'}}>
        <thead>
          <tr>
            {
              ['번호', '상품명', '수량', '변경', '삭제'].map(text => <th scope="col" key={text}>{text}</th>)
            }
          </tr>
        </thead>
        <tbody>
          {
            cartItems.map((item, i)=> {
              return (
                <tr key={item.id}>
                  <td>{i+1}</td>
                  <td>{item.title}</td>
                  <td>
                    <button className="btn" onClick={()=>dispatch(decCnt(item.id))}>─</button>
                    &nbsp;&nbsp;{item.count}&nbsp;&nbsp;
                    <button className="btn" onClick={()=>dispatch(incCnt(item.id))}>┼</button>
                  </td>
                  <td> <button className="btn btn-primary" style={{...BG_COLOR, border:'none'}} onClick={()=>dispatch(incCnt(i))}>수량추가</button> </td>
                  <td>
                    <button className="btn btn-primary" style={{...BG_COLOR_SECOND, border:'none'}} onClick={()=>{dispatch(deleteItemFromCart(item.id))}}>상품삭제</button> 
                  </td>
                </tr>
              );
            })
          }
        </tbody>
      </Table>
    </Container>
  );
}

export default Cart;