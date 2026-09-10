import java.util.*;
import java.io.FileInputStream;


class Solution
{
	
	public static int N;
	public static long[][] map;
	public static char[][] tmp;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			map = new long[N][N];
			tmp = new char[N][N];
			
			for(int i=0 ; i<N; i++) {
				tmp[i] = sc.next().toCharArray();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = tmp[i][j] -'0';
				}
			}
			
		
			long result = 0;
			int mid = (N-1)/2;
			
			for(int i=0; i<=(N-1)/2; i++) {
				for(int j=mid-i; j<= mid+i; j++) {
					result += map[i][j];
				}
			}
			int idx=1;
			for(int i=(N-1)/2 + 1; i<N; i++) {
				for(int j=idx; j<N-idx; j++) {
					result += map[i][j];
				}
				idx++;
			}
			
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
}