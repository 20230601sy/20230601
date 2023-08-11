import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';

const Search = () => {
  return (
    <div>Search
      <InputGroup className="mb-3">
        <InputGroup.Text id="inputGroup-sizing-default">
          <i class="fa-solid fa-magnifying-glass"></i>
        </InputGroup.Text>
        <Form.Control aria-label="Default" aria-describedby="inputGroup-sizing-default"/>
      </InputGroup>
    </div>
  );
}

export default Search;