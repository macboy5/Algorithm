import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
       PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        
        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int fee = cost[2];
            
            map[from][to] = fee;
            map[to][from] = fee; 
        }
        
        boolean[] isVisit = new boolean[n];
        
        pq.add(new int[]{0,0});
        int connectCnt = 0;
        
        while(!pq.isEmpty()){
        
            int[] cur = pq.poll();
            int from = cur[0];
            int fee = cur[1];
            
            if(isVisit[from]) continue;
            
            isVisit[from] = true;
            answer += fee;
            connectCnt++;
            
            if(connectCnt == n) break;
            
            for(int i=0; i<n; i++){
                if(map[from][i] != Integer.MAX_VALUE && !isVisit[i]){
                    pq.add(new int[] {i, map[from][i]});
                }
            }

            
        }
        
        return answer;
    }
}