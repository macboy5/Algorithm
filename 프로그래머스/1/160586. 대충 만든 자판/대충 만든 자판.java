import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(String km : keymap){
            
            int len = km.length();
            
            for(int i=0; i<len; i++){
                char  c = km.charAt(i);
                
                int value = hm.getOrDefault(c, 999);
                if(value > i+1){
                    hm.put(c, i+1);
                }
                
            }
            
        }
        
        int idx = 0;
        for(String target : targets){
            
            int result = 0;
            int len = target.length();
            boolean isProblem = false;
            
            for(int i=0; i<len; i++){
                char  c = target.charAt(i);
                
                int value = hm.getOrDefault(c, 0);
                if(value == 0){
                    answer[idx] = -1;
                    isProblem = true;
                    break;
                }
                else result += value;
            }
            
            if(!isProblem){
                answer[idx] = result;
            }
            idx++;
            
            
        }
        
        return answer;
    }
}