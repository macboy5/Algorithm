import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        
        List<Integer> delete = new ArrayList<>();
        for(int d : delete_list){
            delete.add(d);
        }
        
        for(int a : arr){
            if(delete.contains(a)) continue;
            list.add(a);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}