import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
         // 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 송전탑 개수의 차이를 return 
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            int cnt = func(n);
            answer = Math.min(answer, Math.abs(n-cnt*2));
            
            graph[a].add(b);
            graph[b].add(a);        
        }
        
        
        return answer;
    }
    
    private int func(int n){
        // 1번 송전탑과 연결된 갯수 return
        int cnt = 1;
        boolean[] visit = new boolean[n + 1];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visit[1] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                if(!visit[graph[cur].get(i)] ){
                    visit[graph[cur].get(i)] = true;
                    q.add(graph[cur].get(i));
                    cnt++;
                }
            }
            
            
        }
        
        return cnt;
        
    }
}