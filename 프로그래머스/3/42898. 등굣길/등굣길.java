class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[m + 1][n + 1];
        
        // 웅덩이 위치를 -1로 표시
        if (puddles != null && puddles.length > 0 && puddles[0].length > 0) {
            for (int[] puddle : puddles) {
                dp[puddle[0]][puddle[1]] = -1;
            }
        }
        
        // 시작점 설정
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 시작점이거나 웅덩이인 경우 건너뜀
                if ((i == 1 && j == 1) || dp[i][j] == -1) {
                    continue;
                }
                
                int fromLeft = 0;
                int fromUp = 0;
                
                // 왼쪽에서 오는 경우
                if (dp[i - 1][j] != -1) {
                    fromLeft = dp[i - 1][j];
                }
                
                // 위쪽에서 오는 경우
                if (dp[i][j - 1] != -1) {
                    fromUp = dp[i][j - 1];
                }
                
                // 현재 칸의 최단 경로 수 업데이트 \
                dp[i][j] = (fromLeft + fromUp) % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}