import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String lowercase = my_string.toLowerCase();
        
        char[] chars = lowercase.toCharArray();
        
        Arrays.sort(chars);
        
        answer = new String(chars);       
        
        
        return answer;
    }
}