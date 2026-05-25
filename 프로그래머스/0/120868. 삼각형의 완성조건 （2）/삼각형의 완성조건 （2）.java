import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        
        // 가장 긴변이 sides에 포함
        int max = sides[1];
        int rest = sides[0];
        
        for(int i=1; i<max; i++){
            if(rest + i > max) answer++;
        }
        
        
        // 미포함
        for(int i=max; ; i++){
            if(max+rest > i) answer++;
            else break;
        }
        
        
        return answer;
    }
}