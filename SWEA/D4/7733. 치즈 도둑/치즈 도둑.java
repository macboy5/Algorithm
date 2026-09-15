import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int N;
	public static int[][] map;
	public static boolean[][] isVisited;
	public static int[] dr = {+1,-1,0,0};
	public static int[] dc = {0,0,+1,-1};
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = sc.nextInt();
			map = new int[N][N];
			isVisited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int result = 1;
			
			for(int day = 1; day<=100 ; day++) {
				
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
							isVisited[i][j] = false;
					}
					}
				
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j] == day) {
							map[i][j] = -1;
							isVisited[i][j] = true;
						}
					}
					}
				
				
				int cnt = 0;
				
				Queue<int[]> q = new ArrayDeque<>();
				// bfs
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j] != -1 && !isVisited[i][j]) {
							q.add(new int[] {i,j});
							isVisited[i][j] = true;
							
							while(!q.isEmpty()) {
								int[] cur = q.poll();
								int r = cur[0];
								int c = cur[1];
								
								for(int dir=0; dir<4; dir++) {
									int nr = r + dr[dir];
									int nc = c + dc[dir];
									
									if(nr>=0 && nr<N && nc>=0 && nc<N
											&& map[nr][nc] != -1
											&& !isVisited[nr][nc]) {
										isVisited[nr][nc] = true;
										q.add(new int[] {nr, nc});
										
									}
								}
								
							
						}
							
							
						cnt++;	
					}
						
				}
				
				
			}
				result = Math.max(result, cnt);
			}
			
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
}