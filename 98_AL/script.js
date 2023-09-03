const input = document.querySelector("input");
const audio = document.querySelector("audio");
const audiosrc = document.querySelector("source");
const currentTrackName = document.querySelector("p");
const audiolist = document.querySelector("ol");

let max_song_id = 1;
let song_id = 0;

const audioplay = () => {
  currentTrackName.innerText = input.files[song_id].name;
  audiosrc.src = URL.createObjectURL(input.files[song_id]);
  audio.load();
  audio.play();
};

input.addEventListener("change", ()=> {
  max_song_id = input.files.length;
  song_id = 0;
  audioplay();
  for(let i=0; i<max_song_id; i++){
    const li = document.createElement('li');
    li.innerText = input.files[i].name;
    li.addEventListener("click", ()=>{
      song_id = i;
      audioplay();
    });
    audiolist.append(li);
  }
});

audio.addEventListener("ended", ()=>{
  song_id++;
  if(song_id==max_song_id)
    song_id = 0;
  audioplay();
});