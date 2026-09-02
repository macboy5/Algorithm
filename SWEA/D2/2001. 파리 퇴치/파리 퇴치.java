import java.util.*;
import java.io.FileInputStream;

class Solution
{
	static int N, M;
	static int[][] map;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
			
		for(int test_case = 1; test_case <= T; test_case++)
		{

			N = sc.nextInt();
			M = sc.nextInt();
			
			map =new int[N][N];
			
			for(int i=0 ; i< N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int result = gatcha(map, N, M);
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	public static int gatcha(int[][] map, int N, int M) {
		int result = 0;
		
		for(int i=0 ; i<=N-M; i ++) {
			for(int j=0; j<= N-M; j++) {
				
				int sum = 0;
				for(int k=0; k<M; k++) {
					for(int l=0; l<M; l++) {
						sum += map[i+k][j+l];
					}
				}
				
				result = Math.max(result, sum);
				
			}
		}
		
		return result; 
	}
}