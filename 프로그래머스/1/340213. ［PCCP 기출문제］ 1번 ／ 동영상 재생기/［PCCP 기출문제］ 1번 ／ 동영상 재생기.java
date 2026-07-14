import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int total = trans(video_len);
        int now = trans(pos);
        int start = trans(op_start);
        int end = trans(op_end);
        
        
        for(String command : commands){
            
            if(now >= start && now <= end){
                now = end;
            }
            
            if(command.equals("next")){
                now += 10;
                if(now >= total){
                    now = total;
                }
            }
            else if(command.equals("prev")){
                now -= 10;
                if(now <= 0){
                    now = 0;
                }
            }
            
            
        }
        
        if(now >= start && now <= end){
                now = end;
            }
        
        int mm, ss;
        
        mm = now/60;
        ss = now%60;
        if(mm<10){
            answer += "0";
        }
        answer += String.valueOf(mm);
        
        answer += ":";
        if(ss<10){
            answer += "0";
        }
        answer += String.valueOf(ss);
        
        
        return answer;
    }
    
    public int trans(String time){
        int total = 0;
        String tmp = "";
        for(int i=0; i<2; i++){
            tmp += time.charAt(i);
        }
        total += Integer.parseInt(tmp) * 60;
        tmp = "";
        for(int i=3; i<5; i++){
            tmp += time.charAt(i);
        }
        total += Integer.parseInt(tmp);
        
        return total;
    }
}