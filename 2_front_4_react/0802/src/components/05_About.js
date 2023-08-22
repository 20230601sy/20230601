import { Outlet, useNavigate } from "react-router-dom";

const About = () => {
  const navigate = useNavigate();

  return (
    <div>
      <button className="btn btn-secondary" style={{margin : '10px'}} onClick={() => {navigate('/about/introduce')}}>회사소개</button>
      <button className="btn btn-secondary" style={{margin : '10px'}} onClick={() => {navigate('/about/history')}}>연혁</button>
      <button className="btn btn-secondary" style={{margin : '10px'}} onClick={() => {navigate('/about/location')}}>오시는길</button>
      <div style={{padding : '0 10px'}}>
        <Outlet/>
      </div>
    </div>
  );
}

export default About;