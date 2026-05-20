import java.util.*;

class Solution {
    int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0; i<info.length; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        dfs(0, 0, 1, tree, visited , info);
        
        return maxSheep;
    }
    
    // 양의 수 <= 늑대의 수 : 모두 잡아먹는다
    void dfs(int cur, int wolf, int sheep, List<List<Integer>> tree, boolean[] visited, int[] info){
        
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<info.length; i++){
            if(visited[i]){
        for(int next : tree.get(i)){
            if(!visited[next]){
                    int nextWolf = wolf + (info[next] == 1 ? 1 : 0);
                    int nextSheep = sheep + (info[next] == 0 ? 1 : 0);
                
                if(nextSheep>nextWolf){
                    visited[next] = true;
                    dfs(next, nextWolf, nextSheep, tree, visited, info);
                    visited[next] = false;
                }
            }
        }
        }
        }
    }
}