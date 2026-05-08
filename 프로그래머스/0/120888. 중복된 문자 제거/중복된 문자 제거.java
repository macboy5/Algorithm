import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        HashSet<Character> s = new HashSet<>();
        
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            // if(c>= 'A' && c<= 'Z' || c>= 'a' && c<='z'){
            if(s.contains(c)) continue;
            else{
                answer += c;
                s.add(c);
            }
            // }
        }
        
        
        
        
        
        
        return answer;
    }
}