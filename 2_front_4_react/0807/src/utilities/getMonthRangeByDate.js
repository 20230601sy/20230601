export const getMonthRangeByDate = (date) => {
  // const startTimeStamp = new Date(date.getFullYear(), date.getMonth(), 1).getTime();
  const startTimeStamp = new Date(date.getFullYear(), date.getMonth()).getTime();
  // const endTimeStamp = new Date(date.getFullYear(), date.getMonth()+1, 0, 23, 59, 59).getTime();
  const endTimeStamp = new Date(date.getFullYear(), date.getMonth()+1).getTime();
  return {startTimeStamp, endTimeStamp};
}