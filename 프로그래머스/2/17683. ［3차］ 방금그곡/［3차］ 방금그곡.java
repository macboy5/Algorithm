import java.util.*;

class Solution {

    class Song{
        String title;
        int playTime;
        int idx;
        
        Song(String title, int playTime, int idx){
            this.title = title;
            this.playTime = playTime;
            this.idx = idx;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        // m : 멜로디를 담은 문자열
        // musicinfos[i] : i번째 방송 정보 ->  시작시각,끝난시각,음악제목,악보정보
        
        int melodyLen = m.length();
        
        // 재생된 시간이 제일 긴 음악 제목을 반환
        // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환
        List<Song> list = new ArrayList<>();
        
        int idx = 0;
        for(String music : musicinfos){
            String[] tmp = music.split(",");
            int playTime = getPlayTime(tmp[0], tmp[1]);
            String title = tmp[2];
            String info = tmp[3];
            
            String melody = getMelody(playTime, info);
            // C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12가지
            
            if( check(melody, m)) list.add(new Song(title, playTime, idx++));           
        }
        
        list.sort((s1, s2) -> {
                    if (s2.playTime != s1.playTime) {
                        return s2.playTime - s1.playTime;
                    }
                    return s1.idx - s2.idx;
                });
        
        if (list.isEmpty()) return "(None)";
        else answer = list.get(0).title;
            
        // 일치하는 음악 제목 return
        return answer;
    }
    
    private boolean check(String melody, String m){
        int mLen = m.length();
        int melodyLen = melody.length();
        
        if (melodyLen < mLen) return false;
        
        for (int idx = 0; idx <= melodyLen - mLen; idx++) {
            if (melody.startsWith(m, idx)) {
                int nextIdx = idx + mLen;
                if (nextIdx < melodyLen && melody.charAt(nextIdx) == '#') {
                    continue; 
                }
                return true; 
            }
        }
        
        return false;
        
    }
    
    
    private String getMelody(int playTime, String info) {
        StringBuilder tmp = new StringBuilder();
        int infoLen = info.length();
        int idx = 0;
        
        for (int i = 0; i < playTime; i++) {
            char cur = info.charAt(idx);
            tmp.append(cur);
            idx = (idx + 1) % infoLen;

            if (info.charAt(idx) == '#') {
                tmp.append('#');
                idx = (idx + 1) % infoLen;
            }
        }
        
        return tmp.toString();
    }
    
    private int getPlayTime(String start, String end){
        String[] tmp1 = start.split(":");
        String[] tmp2 = end.split(":");
        
        int time1 = Integer.parseInt(tmp1[0])*60 + Integer.parseInt(tmp1[1]);
        int time2 = Integer.parseInt(tmp2[0])*60 + Integer.parseInt(tmp2[1]);
        
        return time2-time1;  
    }
    
}