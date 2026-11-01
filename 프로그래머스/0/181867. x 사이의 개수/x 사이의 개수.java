import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<myString.length(); i++){
            
            char c = myString.charAt(i);
            
            if(c == 'x'){
                list.add(cnt);
                cnt = 0;
            }
            else{
                cnt++;
            }
            
        }
        if(cnt >= 0) list.add(cnt);
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}