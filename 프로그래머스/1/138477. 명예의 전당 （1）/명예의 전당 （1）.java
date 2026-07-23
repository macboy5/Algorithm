import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int min = Integer.MAX_VALUE;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            
            if(i<k){
                list.add(score[i]);
                list.sort(Collections.reverseOrder());
                result.add(list.get(i));
            }
            else{
                list.add(score[i]);
                list.sort(Collections.reverseOrder());
                result.add(list.get(k-1));              
                
            }
            
        }
        
        for(int i=0; i<score.length; i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}