import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        List<Integer> list = new ArrayList<>();    
        for(int a : arr){
           if(list.contains(a)) continue;
            else {
                list.add(a);
            }
        }    
        
        
        
        
        for (int i = 0; i < list.size() && i < k; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}