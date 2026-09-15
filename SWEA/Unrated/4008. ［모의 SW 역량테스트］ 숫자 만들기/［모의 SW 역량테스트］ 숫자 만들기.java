import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int N;
	public static int[] op = new int[4]; // '+', '-', '*', '/' 순서
	public static int[] number;
	public static int min;
	public static int max;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			
			for(int i=0; i<4; i++) {
				op[i] = sc.nextInt();
			}
			
			number = new int[N];
			for(int i=0; i<N; i++) {
				number[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			dfs(1, number[0]);
			
			
			
			
			int answer = max - min;
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}
	
	public static void dfs(int idx, int currentResult) {
		
		if(idx == N) {
			max = Math.max(max, currentResult);
			min = Math.min(min, currentResult);
			return;
		}
		
		if(op[0] > 0) {
			op[0]--;
			dfs(idx+1, currentResult + number[idx]);
			op[0]++;
		}
		
		if(op[1] >0 ) {
			op[1]--;
			dfs(idx+1, currentResult - number[idx]);
			op[1]++;
		}
		
		if(op[2] > 0) {
			op[2]--;
			dfs(idx+1, currentResult * number[idx]);
			op[2]++;
		}
		
		if(op[3]>0) {
			op[3]--;
			dfs(idx+1, currentResult / number[idx]);
			op[3]++;
		}
		
	}
	
}