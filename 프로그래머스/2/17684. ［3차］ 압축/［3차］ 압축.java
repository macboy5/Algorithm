import java.util.*;

class Solution {
    public int[] solution(String msg) {

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        int idx = 27;
        
        // 알파벳 초기화
        for(int i=0; i< 26; i++){
            hm.put(Character.toString('A' + i), i + 1);
        }
        
        int i = 0;
        int n = msg.length();
        
        while(i<n){
            
            int j = i;
            String s = "";
            int lastIdx = -1;
            
            while(j < n){
                s += msg.charAt(j);
                
                if(hm.containsKey(s)){
                    lastIdx = hm.get(s);
                    j++;
                }
                else{
                    hm.put(s, idx++);
                    break;
                }
            }
            
            result.add(lastIdx);
            
            i = j;
            
            
        }
        
        

        
        
        int[] answer = new int[result.size()];
        for(int k=0; k<result.size(); k++){
            answer[k] = result.get(k);
        } 
        
        return answer;
    }
}