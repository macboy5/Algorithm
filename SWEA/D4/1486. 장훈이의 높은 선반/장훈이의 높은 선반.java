import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int min;
	public static int N;
	public static int B;
	
	public static int[] arr;
	
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
	
			N = sc.nextInt();
			B = sc.nextInt();
			min = Integer.MAX_VALUE;
			
			int result = 0;
			
			arr = new int[N];
			for(int i=0 ; i<N ; i++) {
				arr[i] = sc.nextInt();
			}
		
			Arrays.sort(arr);
			
			dfs(0,0);
			
			result = min - B;

			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
	
	public static void dfs(int idx, int sum){
		

		
		if(sum >= min) return;
		
		if(sum >= B) {
			min = Math.min(min, sum);
			return;
		}
		
		if(idx == N) return;
		
		dfs(idx+1, sum+arr[idx]);
		dfs(idx+1, sum);
		
	}
}