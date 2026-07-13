import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=n; i<num_list.length; i++){
            list.add(num_list[i]);
        }
        for(int i=0; i<n ; i++){
            list.add(num_list[i]);
        }
        
        for(int i=0; i<num_list.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}