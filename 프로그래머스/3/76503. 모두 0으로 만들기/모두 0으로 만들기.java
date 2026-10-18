import java.util.*;

class Solution {
    
    long[] longA;
    List<Integer>[] list;
    boolean[] visit;
    long answer = 0;
    public long solution(int[] a, int[][] edges) {
        
        longA = new long[a.length];
        long sum = 0;
        int idx = 0;
        
        for(int tmp : a){
            longA[idx++] = tmp;
            sum += tmp;
        }
        if(sum != 0) return -1;
        
        list = new ArrayList[a.length];
        visit = new boolean[a.length];
        for(int i=0; i<a.length; i++){
            list[i] = new ArrayList<>();
        }
        // 리프를 0으로 만들고 부모쪽에 더하면서 올린다        
        
        for(int[] edge : edges){
            int e1 = edge[0];
            int e2 = edge[1];
            
            list[e1].add(e2);
            list[e2].add(e1);            
        }
        
        dfs(0);
        
        
        return answer;
    }
    
    public long dfs(int now)
    {
        visit[now] = true;
        
        for(int i=0;i<list[now].size();i++)
        {
            int next = list[now].get(i);
            if(visit[next]) continue;
            longA[now] += dfs(next);
        }
        
        answer += Math.abs(longA[now]);
        return longA[now];
    }
}