class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int MOD = 20170805;
        
        // m행 n열 city_map
        // (0,0) -> (m-1, n-1)로 가는 경로의 수 구하기
        
        // dp[][][0] 아래쪽, dp[][][1] 오른쪽
        int[][][] dp = new int[m+1][n+1][2];
        
        dp[1][1][0] = dp[1][1][1] = 1;
        
         for(int r = 1 ; r <= m ; ++r){
             for(int c = 1 ; c <= n ; ++c){
                  if(cityMap[r - 1][c - 1] == 0){
                      dp[r][c][0] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                      dp[r][c][1] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                  } 
                 else if(cityMap[r - 1][c - 1] == 1){
                      dp[r][c][0] = 0;
                      dp[r][c][1] = 0;
                  } 
                 else if(cityMap[r -1][c -1] == 2){
                      dp[r][c][0] = dp[r - 1][c][0];
                      dp[r][c][1] = dp[r][c - 1][1];
                  }
              }
          }
        
        answer = dp[m][n][0];
        
        return answer;
    }
}