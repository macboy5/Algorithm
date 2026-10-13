import java.util.Scanner;
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
            int answer = 0;
            
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] V = new int[N+1];
            int[] C = new int[N+1];
            
            for(int i = 1; i<=N; i++){
             	V[i] = sc.nextInt();   
                C[i] = sc.nextInt();
            }
            
            int[][] dp = new int[N+1][K+1];
		
            // 부피 합 K 이하이면서 가치 C 의 합이 최대여야한다.
            
            for(int i=1; i<= N ; i++){
             	for(int w = 1; w<= K; w++){
                 	if(V[i] <= w){
                     	dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-V[i]] + C[i] );   
                    }
                    else{
                     	dp[i][w] = dp[i-1][w];   
                    }
                }
            }
            
            answer = dp[N][K];
            
            System.out.println("#" + test_case  + " " + answer );
		}
        
        sc.close();
	}
}