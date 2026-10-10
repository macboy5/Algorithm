class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int max = 0;
        int N = board.length;
        int M = board[0].length;
        
        int[][] dp = new int[N+1][M+1];
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = board[i-1][j-1];
            }
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(dp[i][j] == 1){
                    int min = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        answer = max*max;

        return answer;
    }
}