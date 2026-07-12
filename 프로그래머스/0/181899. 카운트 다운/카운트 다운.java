import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=start_num; i>= end_num; i--){
            list.add(i);    
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}