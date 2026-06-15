import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // 1) x+=n 2) x*=2 3) x*=3
        // x를 y로 변환하는 최소 연산 횟수 반환
        // x에서 y로 이동하면서..dp 최솟값 비교
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, -1);
        dp[x] = 0;

        
        for(int cur=x; cur<=y; cur++){
            
            if(dp[cur] == -1) continue;
            
            // x += n 
            if(cur+n <= y){
                dp[cur+n] = Math.min(dp[cur]+1, dp[cur+n]);
                if(dp[cur+n] == -1) dp[cur+n] = dp[cur]+1;
            }
            // x * 2
            if(cur*2 <=y){
                dp[cur*2] = Math.min(dp[cur]+1, dp[cur*2]);
                if(dp[cur*2] == -1) dp[cur*2] = dp[cur]+1;
            }
            // x * 3
            if(cur*3 <=y){
                dp[cur*3] = Math.min(dp[cur]+1, dp[cur*3]);
                if(dp[cur*3] == -1) dp[cur*3] = dp[cur]+1;
            }
            
        }
        
        return dp[y];
    }
}