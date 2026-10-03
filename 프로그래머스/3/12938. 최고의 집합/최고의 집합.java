import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // n개의 합으로 s를 만들 수 없으면 -1 return
        if(n > s){
            return new int[]{-1};
        }
        
        int quotient = s/n;
        int remainder = s%n;
        
        Arrays.fill(answer, quotient);
        for(int i=0; i<remainder; i++){
            answer[n-1-i]++;
        }
        
        return answer;
    }
}