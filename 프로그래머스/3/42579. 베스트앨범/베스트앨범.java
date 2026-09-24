import java.util.*;

class Solution {
    
    class Genre{
        String genre;
        int genreId;
        int playCnt = 0;
        List<Song> songList = new ArrayList<>();
        
        Genre(String genre, int genreId){
            this.genre = genre;
            this.genreId = genreId;
        }
        
        void setPlayCnt(int play){
            this.playCnt += play;
        }
        
        void setSongList(Song song){
            songList.add(song);
        }
        
    List<Song> getTopTwoSong(){
        List<Song> list = new ArrayList<>();
        int limit = Math.min(songList.size(), 2);
        for(int i = 0; i < limit; i++) {
            list.add(songList.get(i));
        }
        return list;
    }
        
    }
    
    class Song{
        int primaryNumber;
        int play;
        
        Song(int primaryNumber, int play){      
            this.primaryNumber = primaryNumber;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        
        //장르 별로 가장 많이 재생된 노래를 두 개씩
        
        // 장르 : Id
        HashMap<String, Integer> hm1 = new HashMap<>();
        List<Genre> genreList = new ArrayList<>();
        
        int idx = 0;
        for(String genre : genres){
            if( hm1.getOrDefault(genre, -1) == -1){
                hm1.put(genre, idx);
                genreList.add(new Genre(genre, idx++));
            }
            else{
                continue;
            }
        }
        
        
        
        for(int i=0; i<plays.length; i++){
            
            // 장르의 플레이 횟수 업데이트
            int genreId = hm1.get(genres[i]);
            Genre g = genreList.get(genreId);
            g.setPlayCnt(plays[i]);
            
            // 장르 내 노래 업데이트
            Song song = new Song(i, plays[i]);
            g.setSongList(song);
            
        }
        
        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        
        for(Genre g : genreList){
            g.songList.sort( (s1, s2) -> {
                if(s1.play == s2.play){
                    return s1.primaryNumber - s2.primaryNumber;
                }
                else return s2.play-s1.play;
            });
        }
        
        genreList.sort( (g1,g2) -> g2.playCnt - g1.playCnt);
        
        List<Integer> answerList = new ArrayList<>();
        
        for(Genre genre : genreList){
            List<Song> l = genre.getTopTwoSong();
            for(Song s : l) {
                answerList.add(s.primaryNumber);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}