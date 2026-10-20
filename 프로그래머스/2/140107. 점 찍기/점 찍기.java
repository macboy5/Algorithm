import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // 1사분면에 반지름 d인 원을 그리고 그안에 정수 좌표를 찍는다.
        // x*x + y*y <= d

        
        for(long x=0; x<=d; x+=k){
            
             long maxY = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            
            answer += (maxY/k) +1;
            
        }
        
        
        return answer;
    }
}