import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int V;
	public static int E;
	public static List<Integer>[] graph;
	public static boolean[] visited;
	public static List<Integer> sequenceList;
	
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			graph = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start].add(end);
			}
			
			visited = new boolean[V+1];
			sequenceList = new ArrayList<>();
			
			for(int i=1; i<=V; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			
			Collections.reverse(sequenceList);
			
			
			StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
            for(int node : sequenceList) {
                sb.append(node).append(" ");
            }
            System.out.println(sb.toString().trim());
            
            
		}
		sc.close();
	}
	
	public static void dfs(int vertex) {
		visited[vertex] = true;
		
		for(int next : graph[vertex]) {
			if( !visited[next]) {
				dfs(next);
			}
		}
		
		sequenceList.add(vertex);
	}
}