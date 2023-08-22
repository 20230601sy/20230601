export const setPageTitle = (title) => {
  const TitleElement = document.getElementsByTagName('title')[0]; // elements 배열 형태
  TitleElement.innerText = title;
}