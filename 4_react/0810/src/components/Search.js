import { useState } from 'react';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import { useDispatch, useSelector } from 'react-redux';
import { setShowItems } from '../redux/store';
import { useNavigate } from 'react-router-dom';

const Search = () => {
  const [searchInput, setSearchInput] = useState('');
  const {totalItems} = useSelector(state => state);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const submitHandler = (e) => {
    e.preventDefault();
    dispatch(setShowItems(totalItems.filter(item => item.title.includes(searchInput))));
    setSearchInput('');
    navigate('/items');
  }

  return (
    <Form className="my-2" onSubmit={submitHandler}>
      <InputGroup>
        <Form.Control aria-label="Default" aria-describedby="inputGroup-sizing-default"  value={searchInput} onChange={(e)=>setSearchInput(e.target.value)}/>
        <InputGroup.Text id="inputGroup-sizing-default" onClick={submitHandler} style={{cursor:'pointer'}}>
          <i className="fa-solid fa-magnifying-glass"></i>
        </InputGroup.Text>
      </InputGroup>
    </Form>
  );
}

export default Search;