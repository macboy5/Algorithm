import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        // destination에서 source까지의 최단거리.
    
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        int[] dis = new int[n+1];
        Arrays.fill(dis,-1);
        dis[destination]  = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int nextNode : graph.get(cur)){
                if(dis[nextNode] == -1){
                    dis[nextNode] = dis[cur]+1;
                    q.add(nextNode);
                }
            }
            
        }
        
        for(int i=0; i<sources.length; i++){
            answer[i] = dis[sources[i]];
        }
        
        
        
        return answer;
    }
}