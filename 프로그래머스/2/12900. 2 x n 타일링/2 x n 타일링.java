class Solution {
    public int solution(int n) {
        
        // 점화식 f(n) = f(n-1) + f(n-2);
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n ; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        
        return dp[n];
    }

}