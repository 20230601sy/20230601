import { Table } from "react-bootstrap";

const Box1by1 = ({num, setNum}) => {
  if(num)
    return (
      <table>
        <tr><td style={{border:'0'}}><div style={{width:'20px', height:'24px'}}> </div></td></tr>
        <tr>
          <td style={{border:'0'}}><div style={{width:'20px'}}></div></td>
          <td style={{border:'0'}}><div style={{width:'20px'}}>{num}</div></td>
          <td style={{border:'0'}}><div style={{width:'20px'}}></div></td>
        </tr>
        <tr><td style={{border:'0'}}><div style={{width:'20px', height:'24px'}}> </div></td></tr>
        <tr />
      </table>
    // <div style={{width:'60px', height:'72px'}}>{num}</div>
    );
  return (
    <table>
        <tr>
          {
            [1, 2, 3].map(i => {
              return (
                <td>
                  <div style={{width:'20px'}} key={i} onClick={e => e.target.className='d-none'} onContextMenu={()=>setNum(i)}>{i}</div>
                </td>
              );
            })
          }
        </tr>
        <tr>
          {
            [4, 5, 6].map(i => {
              return (
                <td>
                  <div key={i} onClick={e => e.target.className='d-none'} onContextMenu={()=>setNum(i)}>{i}</div>
                </td>
              );
            })
          }
        </tr>
        <tr>
          {
            [7, 8, 9].map(i => {
              return (
                <td>
                  <div key={i} onClick={e => e.target.className='d-none'} onContextMenu={()=>setNum(i)}>{i}</div>
                </td>
              );
            })
          }
        </tr>

        {/* {

          onContextMenu={e => console.log("right-click")}
          onClick={e => console.log("left-click")}


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
        } */}
    </table>
  );
}

export default Box1by1;