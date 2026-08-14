import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        
        for(int i=1; i<=r2; i++){
            int max = (int)Math.floor(Math.sqrt(r2*(long)r2 - i*(long)i));
            int min = (int)Math.ceil(Math.sqrt(r1*(long)r1 - i*(long)i));        
            answer += (max-min+1);
        }
        
        answer *= 4;
        
        return answer;
    }
}