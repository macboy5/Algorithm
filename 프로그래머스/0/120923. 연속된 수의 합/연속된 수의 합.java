import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int start = 0;
        
        for(int i=-1000; i<= 1000; i++){
            int sum = 0;
            for(int j=i; j<i+num; j++){
                sum += j;
            }
            if(sum == total){
                start = i;
                break;
            }
        }
        
        for(int i=0; i<num; i++){
            answer[i] = start+i;
        }
        
        
        Arrays.sort(answer);
        
        return answer;
    }
}