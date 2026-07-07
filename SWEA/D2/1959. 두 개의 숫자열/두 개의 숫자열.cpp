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
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            for(int i=0; i<N; i++){
            	arr1[i] = sc.nextInt();
            }
            for(int i=0; i<M; i++){
            	arr2[i] = sc.nextInt();
            }
                  
            int answer=-1;
            
            
            if(N<=M){
                
                for(int start=0; start<=M-N; start++){
                    int sum = 0;
                    for(int i=0; i<N; i++){
                        sum += arr1[i] * arr2[start+i];
                    }
                    answer = Math.max(answer, sum);
                }
            
            }
            else{
                
                    for(int start=0; start<=N-M; start++){
                    int sum = 0;
                    for(int i=0; i<M; i++){
                        sum += arr1[start+i] * arr2[i];
                    }
                    answer = Math.max(answer, sum);
                }
            
            }
            

            System.out.println("#" + test_case + " " + answer);
            
		}
	}
}