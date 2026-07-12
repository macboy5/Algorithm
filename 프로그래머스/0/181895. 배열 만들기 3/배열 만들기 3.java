import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            
            for(int i=start ; i <=end ; i++){
                list.add(arr[i]);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}