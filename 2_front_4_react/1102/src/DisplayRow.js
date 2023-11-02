const DisplayRow = ({y, setNum, num, set, isSet}) => {
  // console.log('변경 전', num[0]);
  // num[0][1] = 1;
  // setNum([...num]);
  // console.log('변경 후', num[0]);
  // <td style={{border:`${set[0][0]}`, width:'20px', height:'20px'}}>
  //       <div style={{width:'20px'}} key={1} onClick={e => e.target.className='d-none'} onContextMenu={()=>setNum(1)}>1</div>
  //     </td>
  return (
    <tr>
      {
        new Array(27).fill(y).map((i, j) => {
          return (
            <td style={{border:`${set[i*27+j]}`, width:'18px', height:'18px'}}>
              <div key={i*27+j} onClick={e => e.target.className='d-none'} onContextMenu={()=>setNum([...num])}>
                {num[i*27+j]}
              </div>
            </td>
          );
        })
      }
    </tr>
  );
};

export default DisplayRow;