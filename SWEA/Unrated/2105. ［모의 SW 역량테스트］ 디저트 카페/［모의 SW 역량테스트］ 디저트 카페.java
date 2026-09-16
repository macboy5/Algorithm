import java.util.*;
import java.io.FileInputStream;


class Solution
{
	
	public static int N;
	public static int[][] map;
	
	public static int[] dr = {+1, +1, -1,  -1};
	public static int[] dc = {+1, -1, -1, +1};
	
	public static boolean[][] isVisited;
	public static boolean[] dessert;
 	
	public static int max = 0;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			max = 0;
			
			for(int i=0; i<N-2; i++) {
				for(int j=1 ; j<N-1; j++) {
					
					isVisited = new boolean[N][N];
					dessert = new boolean[101];
					
					isVisited[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i,j, i,j, 1, 0);
					
				}
				
			}
			
			if(max == 0) max = -1;
			
			
			
			System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}
	
	public static void dfs(int r, int c, int initR, int initC, int cnt, int prevDir) {
		
		if(prevDir >=4) return;

		
		for(int dir = prevDir ; dir<= prevDir+1; dir++) {
			
			if(dir>=4) return;
			
			
			
			int nr = r  + dr[dir];
			int nc = c + dc[dir];
		
			if(nr>=0 && nr< N && nc>=0 && nc< N) {
				
				if( cnt>=4 && nr == initR && nc == initC) {
					
					max = Math.max(max, cnt);
					return;
				}

				if( !isVisited[nr][nc] && !dessert[map[nr][nc]]) {
					isVisited[nr][nc] = true;
					dessert[map[nr][nc]] = true;
					
					dfs(nr, nc, initR, initC, cnt+1, dir);
					
					isVisited[nr][nc] = false;
					dessert[map[nr][nc]] = false;
				}
				
			}
		
		}
		
		
	}
	
}