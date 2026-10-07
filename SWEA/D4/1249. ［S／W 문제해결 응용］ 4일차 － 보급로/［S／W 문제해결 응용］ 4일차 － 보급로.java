import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution
{
    static int N;
    static int[][] map;
    static int[][] distance;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Node implements Comparable<Node> {
     	int r, c, cost;
        
        public Node(int r, int c , int cost){
        	this.r = r;
            this.c = c;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
         	return Integer.compare(this.cost, o.cost);   
        }
    }
    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            distance = new int[N][N];
            
            for(int i=0; i<N; i++){
             	String line = br.readLine().trim();
                for(int j=0; j<N; j++){
                 	map[i][j] = line.charAt(j) - '0';   
                }
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            
            int answer = dijkstra();
            System.out.println("#" + test_case + " " + answer);

        }
	}
        
        private static int dijkstra() {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            
            // 시작점 초기화
            distance[0][0] = 0;
            pq.offer(new Node(0,0,0));
            
            while( !pq.isEmpty()){
             	Node current = pq.poll();
                int r = current.r;
                int c = current.c;
                int cost = current.cost;
                
                if(cost > distance[r][c]) continue;
                
                if(r == N-1 && c == N-1) return cost;
                
                for(int dir = 0; dir<4; dir++){
                 	int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    
                    if(nr < 0 || nr>=N || nc < 0 || nc>=N) continue;
                    
                    if(distance[nr][nc] > distance[r][c] + map[nr][nc]){
                     	distance[nr][nc] = distance[r][c] + map[nr][nc];
                        pq.offer(new Node(nr, nc, distance[nr][nc]));
                    }
                    
                }
                
            }
            
            
            return distance[N-1][N-1];
        }
        
}

