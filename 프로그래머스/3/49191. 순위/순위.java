import java.util.*;

class Solution {
    
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // n명의 선수
        int[][] dp = new int[n+1][n+1];
        
        // 승패 관계 저장.
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            
            dp[winner][loser] = 1;
            dp[loser][winner] = -1;
        }
        
        
        // 플로이드워셜
        for(int i=1; i<=n ; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    
                    if(dp[i][j] ==1 && dp[j][k]==1){
                        dp[i][k] = 1;
                        dp[k][i] = -1;
                    }
                    if(dp[i][j] ==-1 && dp[j][k] ==-1){
                        dp[i][k] = -1;
                        dp[k][i] = 1;
                    }
                    
                }
            }
        }
        
        
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(dp[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
            
        }
         
        
        
        return answer;
    }
}