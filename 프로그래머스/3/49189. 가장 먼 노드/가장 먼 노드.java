import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        //  1번 노드에서 가장 멀리 떨어진 노드의 갯수
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        
        q.add(1);
        isVisited[1] = true;


        while(!q.isEmpty()){

            int size = q.size();
            answer=  size;
            
            for(int i=0; i< size; i++){
            int cur = q.poll();
                
            for( int next  : graph.get(cur) ){

                if(!isVisited[next]){

                    q.add(next);
                    isVisited[next] = true;
                }
                
            }
            }

   
        }
    
        
        
        return answer;
    }
}