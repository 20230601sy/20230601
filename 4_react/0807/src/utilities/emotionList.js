import getEmotionImgById from './util'

export const emotionList = [
  {
    id : 1,
    name : '매우 좋음',
    img : getEmotionImgById(1)
  },
  {
    id : 2,
    name : '좋음',
    img : getEmotionImgById(2)
  },
  {
    id : 3,
    name : '보통',
    img : getEmotionImgById(3)
  },
  {
    id : 4,
    name : '나쁨',
    img : getEmotionImgById(4)
  },
  {
    id : 5,
    name : '매우 나쁨',
    img : getEmotionImgById(5)
  }
];