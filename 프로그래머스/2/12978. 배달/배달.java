import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
                    Arrays.fill(map[i], 500001);
                    map[i][i] = 0;
        }
        
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            // a와 b 사이의 비용 c
            map[a][b] = Math.min(map[a][b], c);
            map[b][a] = Math.min(map[b][a], c);
            
        }
        
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // 1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        pq.add(new int[]{1,0});
        dp[1] = 0;
        
        while(!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int pos = cur[0];
            int cost = cur[1];
            
            if(cost > dp[pos]) continue;
            
            for(int i=1; i<=N; i++){
                if(map[pos][i] != 500001 && dp[i] > cost + map[pos][i]){
                    dp[i] = cost + map[pos][i];
                    pq.add(new int[]{i, dp[i]});
                }
            }
            
            
            
        }
        
        for(int i=1; i<=N ; i++){
            if(dp[i] <= K){
                answer++;
            }
        }
        
        
        
        

        return answer;
    }
}