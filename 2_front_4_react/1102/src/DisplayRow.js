import { useEffect } from "react";

const DisplayRow = ({y, num, setNum, set, isSet, simpleTable, setSimpleTable}) => {
  useEffect(()=>{
    for(let i=0; i<27; i++) {
      for(let j=0; j<27; j++) {
        if(set[27*i+j]===0)
          simpleTable[3*(i-i%3)+(j-j%3)/3] = num[27*i+j];
      }
    }
    setSimpleTable([...simpleTable]);
  });

  return (
    <tr>
      {
        new Array(27).fill(y).map((i, j) => {
          return (
            <td style={{
                        // border:`${set[i*27+j]}`, 
                        width:'18px', height:'18px', 
                        // backgroundColor:`${set[i*27+j]? ( ((i-i%3)/3+(j-j%3)/3)%2 ? 'lightgray' : 'none') : 'skyblue'}`,
                        backgroundColor:`${((i-i%3)/3+(j-j%3)/3)%2 ? 'lightgray' : 'none'}`,
                        color:`${set[i*27+j]? 'black' : 'blue'}`
                      }}>
              <div
                key={i*27+j} 
                // onClick={e => e.target.className='d-none'} 
                onClick={() => {
                  if(num[i*27+j])
                    num[i*27+j] = '';
                  else
                    num[i*27+j] = '';
                  setNum([...num]);
                }} 
                onContextMenu={e=> {
                  e.preventDefault();
                  e.stopPropagation();
                  // e.target.style.color = 'blue';
                  // e.target.style.background = 'pink';

                  let _num = num[i*27+j];
                  for(let _i=0; _i<3; _i++) {
                    for(let _j=0; _j<3; _j++){
                      num[(i-i%3+_i)*27+j-j%3+_j] = '';
                      set[(i-i%3+_i)*27+j-j%3+_j] = 0;
                    }
                  }
                  for(let _i=0; _i<3; _i++)
                    for(let _j=0; _j<3; _j++)
                      num[(i-i%9+_i*3+i%3)*27 + j-j%9+_j*3+j%3] = '';

                  for(let _i=0; _i<9; _i++)
                    num[(_i*3+i%3)*27+j] = '';
                  for(let _j=0; _j<9; _j++)
                    num[i*27+_j*3+j%3] = '';

                  num[i*27+j] = _num;
                  isSet([...set]);
                  setNum([...num]);
                }}>
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