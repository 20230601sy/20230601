const input = document.querySelector("input");
const audio = document.querySelector("audio");
const audiosrc = document.querySelector("source");
const currentTrackName = document.querySelector("p");
const audiolist = document.querySelector("ol");

let max_song_id = 0;
let song_id = 0;

const audioplay = () => {
  currentTrackName.innerText = input.files[song_id].name;
  audiosrc.src = URL.createObjectURL(input.files[song_id]);
  audio.load();
  audio.play();
  URL.revokeObjectURL(input.files[song_id]);
};

input.addEventListener("change", ()=> {
  if(input.files.length > 0) {
    song_id=0;
    max_song_id = input.files.length;
//    song_id = max_song_id;
//    max_song_id += input.files.length;
    audioplay();
    // for(let i=song_id; i<=max_song_id; i++){
    for(let i=0; i<max_song_id; i++){
      const li = document.createElement('li');
      li.innerText = input.files[i].name;
      li.addEventListener("click", ()=>{
        song_id = i;
        audioplay();
      });
      audiolist.append(li);
    }
  }
});

audio.addEventListener("ended", ()=>{
  song_id++;
  if(song_id==max_song_id)
    song_id = 0;
  audioplay();
});