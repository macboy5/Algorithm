import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int[][]map;
	public static List<Core> coreList;
	public static int N;
	
	public static int result = 0;
	public static int maxCoreCnt = Integer.MIN_VALUE;
	public static int wireLength = Integer.MAX_VALUE;
	
	public static int[] dr = {1,-1,0,0};
	public static int[] dc = {0,0,1,-1};
	
	public static class Core{
		private int r;
		private int c;
		
		Core(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			N = sc.nextInt();
			map = new int[N][N];
			coreList = new ArrayList<>();
	
			maxCoreCnt = Integer.MIN_VALUE;
			wireLength = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					
					if(map[i][j] == 1) {
						if(i>0 && i<N && j>0 && j<N) {
							coreList.add(new Core(i,j));
						}
					}
					
				}
			}
			

			dfs(0,0);
			System.out.println("#" + test_case + " " + wireLength );
			coreList.clear();
		}
		
		sc.close();
	}
	

	public static void dfs(int idx, int coreCnt) {

		if(idx == coreList.size()) {
			if(maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				wireLength = countLen();
			}
			if(maxCoreCnt == coreCnt) {
				int len = countLen();
				wireLength = Math.min(wireLength, len);
			}
			return;
		}
		
		
		Core current = coreList.get(idx);
		int r = current.r;
		int c = current.c;
		
		for(int dir = 0 ; dir <4; dir++) {
			if(isAvailable(r, c, dir)) {
				setLine(r, c, dir, 2);
				dfs(idx+1, coreCnt+1);
				setLine(r,c,dir,0);
			}
		}
		dfs(idx+1, coreCnt);
		
	}
	
	public static int countLen() {
		int len = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 2) {
					len++;
				}
			}
		}
		
		
		return len;
	}
	
	public static boolean isAvailable(int r, int c, int dir) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr < 0 || nr > N-1 || nc < 0 || nc >  N-1) break;
			
			if(map[nr][nc] != 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void setLine(int r, int c, int dir, int value) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr < 0 || nr > N-1 || nc < 0 || nc >  N-1) break;
			
			map[nr][nc] = value;
		}
		
	}
	

}