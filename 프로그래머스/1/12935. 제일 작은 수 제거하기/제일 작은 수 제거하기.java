import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
            
        if(arr.length == 1) return new int[]{-1};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            if(min > arr[i]){
                min = arr[i];
                idx = i;
            }
        }
    
        
        list.remove(idx);
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}