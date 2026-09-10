import java.util.*;
import java.io.FileInputStream;


class Solution
{
	
	public static int[] memo;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		memo = new int[100000];
		Arrays.fill(memo, -1);
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N =sc.nextInt();

			
			System.out.println("#" + test_case + " " + getMaxTurn(N));
		}
		
		sc.close();
	}
	
	public static int getMaxTurn(int N) {
		if(N<10) return 0;
		
		if(memo[N] != -1) return memo[N];
		
		int maxTurn = 0;
		String s = String.valueOf(N);
		int len = s.length();
		
		for(int i=1; i< (1 <<(len-1)); i++) {
			int product = 1;
			int tmp = 0;
			
			for(int j=0; j<len; j++) {
				tmp = tmp *10 + (s.charAt(j) -'0');
				
				if((i & (1<<j)) != 0) {
					product *= tmp;
					tmp = 0;
				}
			}
			product *= tmp;
			maxTurn = Math.max(maxTurn, getMaxTurn(product)+1);
		}
		

		
		return memo[N] = maxTurn;
	}
}