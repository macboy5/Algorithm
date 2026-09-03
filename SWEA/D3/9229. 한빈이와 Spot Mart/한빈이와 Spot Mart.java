import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			int maxSum = 0;
			
			int left = 0;
			int right = N-1;
			while(left < right) {
				
				int sum = arr[left] + arr[right];
				
				if(sum <= M) {
					maxSum = Math.max(maxSum, sum);
					left++;
				}
				else right--;
				
			}
			
			
			System.out.println("#" + test_case + " " + (maxSum > 0 ? maxSum : -1) );
		
		
		}
	}
}