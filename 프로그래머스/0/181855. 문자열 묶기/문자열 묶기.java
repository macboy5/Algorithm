import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(String s : strArr){
            int value = hm.getOrDefault(s.length(), 0);
            hm.put( s.length(), value +1);
            
            if(answer < value + 1) answer = value+1;
            
        }
        
        
        
        return answer;
    }
}