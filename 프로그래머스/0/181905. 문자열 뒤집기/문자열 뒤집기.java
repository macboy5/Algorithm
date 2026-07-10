import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        answer += my_string.substring(0, s);
        
        String tmp = my_string.substring(s, e+1);
        StringBuffer sb = new StringBuffer(tmp);
        answer    += sb.reverse().toString();        

        
        answer += my_string.substring(e+1);
        
        return answer;
    }
}