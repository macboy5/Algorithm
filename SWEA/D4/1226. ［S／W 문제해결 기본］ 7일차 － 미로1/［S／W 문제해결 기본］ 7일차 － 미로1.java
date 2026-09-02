import java.util.*;
import java.io.FileInputStream;


class Solution
{
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T;
			T=sc.nextInt();
			
			// 길 0 벽 1 시작점 2 도착점 3
			
			// 도달 가능 하면 1 불가능하면 0 출력
			int result = 0;
			
			char[][] map = new char[16][16];
			
			for(int i=0; i<16; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			
			result = bfs(map);
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
	
	public static int bfs(char[][] map) {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[16][16];
		int targetRow = -1;
		int targetCol = -1;
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				if(map[i][j] == '2') {
					q.add(new int[] {i,j});
					isVisited[i][j] = true;
				}
				if(map[i][j] == '3') {
					targetRow = i;
					targetCol = j;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			
			if(row == targetRow && col == targetCol) return 1;
			
			for(int i=0; i<4; i++) {
				
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr >= 0 && nr < 16 && nc>=0 && nc<16
						&& map[nr][nc] != '1'
						&& !isVisited[nr][nc]) {
					q.add(new int[] {nr, nc});
					isVisited[nr][nc] = true;
					}
				}
			}		
		
		
		
		return 0;
	}
	
}