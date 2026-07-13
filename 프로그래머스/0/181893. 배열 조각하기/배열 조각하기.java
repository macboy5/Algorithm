import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();      
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        
        int idx=0;
        for(int q : query){
            if(idx%2==0){
                list = list.subList(0, q+1);
            }
            else{
                list = list.subList(q, list.size());
            }
            idx++;
        }

        


        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}