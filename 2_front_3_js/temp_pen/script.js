const container = document.querySelector('.container');
container.addEventListener('mousemove', drawImg);

function drawImg(e) {
  e.preventDefault();
  console.log(e);
  console.log(`${e.clientX}, ${e.clientY}`);
  const div = document.createElement('div');
  div.className = 'dot';
  div.style.left = `${e.layerX}px`;
  div.style.top = `${e.layerY}px`;
  container.append(div);
}