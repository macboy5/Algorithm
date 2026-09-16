import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int[][] map;
	public static char[][] tmp;
	
	public static int[] dr = {1,-1,0,0};
	public static int[] dc = {0,0,1,-1};
	public static boolean[][] isVisited;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;
			T=sc.nextInt();
			int result = 0;
			
			map = new int[100][100];
			tmp = new char[100][100];
			isVisited = new boolean[100][100];
			Queue<int[]> q = new ArrayDeque<>();
			
			for(int i=0; i<100; i++) {
				tmp[i] = sc.next().toCharArray();
			}
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = tmp[i][j] - '0';
					
					if(map[i][j] == 2) {
						
						q.add(new int[] {i,j});
						isVisited[i][j] = true;
					}
					
				}
			}
			
			// 시작점에서 도착점 에 도달할 수 있는가?
			

			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				if(map[r][c] == 3) {
					result = 1;
					break;
				}
				
				for(int dir=0; dir<4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if(nr>=0 && nr < 100 && nc>=0 && nc<100
							&& map[nr][nc] != 1
							&& !isVisited[nr][nc]) {
						q.add(new int[] {nr, nc});
						isVisited[nr][nc] = true;
					}
						
					
				}
				
				
				
			}
			
			
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
}