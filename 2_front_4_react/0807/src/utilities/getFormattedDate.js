export const getFormattedDate = (date) => {
  let year = date.getFullYear();
  let month = date.getMonth() + 1;
  let day = date.getDate();
  month = String(month).padStart(2, 0);
  day = String(day).padStart(2, 0);
  
  return `${year}-${month}-${day}`;
}