import java.util.*;

class Solution {
    static int MOD = 1000000007;
    public int solution(int n, int[] money) {
        int answer = 0;
        
        // n을 money[]로 만들 수 있는 경우의수
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        
        Arrays.sort(money);
        
        for(int m : money){
            
            for(int i=m; i<=n; i++){
                dp[i] = (dp[i] + dp[i-m]) % MOD;
            }
            
        }
        
        answer = dp[n];
                    
        return answer;
    }
}