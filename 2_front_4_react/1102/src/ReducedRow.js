const ReducedRow = ({y, simpleTable}) => {
  return (
    <tr>
      {
        new Array(9).fill(y).map((i, j) => {
          return (
            <td style={{
                        // border:`${set[i*27+j]}`, 
                        width:'18px', height:'18px !important', 
                        // backgroundColor:`${set[i*27+j]? ( ((i-i%3)/3+(j-j%3)/3)%2 ? 'lightgray' : 'none') : 'skyblue'}`,
                        // backgroundColor:`${((i-i%3)/3+(j-j%3)/3)%2 ? 'lightgray' : 'none'}`,
                        // color:`${set[i*27+j]? 'black' : 'blue'}`,
                      }}>
              <div key={i*9+j}> {simpleTable[i*9+j]} </div>
            </td>
          );
        })
      }
    </tr>
  );
};

export default ReducedRow;