import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int max = -1;
        int idx = -1;
        
        for(int i=0; i<array.length; i++){
            int tmp = array[i];
            if(tmp > max){
                max = tmp;
                idx = i;
            }
        }
        
        answer[0] = max;
        answer[1] = idx;
        
        return answer;
    }
}