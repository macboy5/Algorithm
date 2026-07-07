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
            int N;
            N = sc.nextInt();
            
            int map[][] = new int[N][N];
            int tmp1[][] = new int[N][N];
            int tmp2[][] = new int[N][N];
            int tmp3[][] = new int[N][N];
            
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	map[i][j] = sc.nextInt();
                }
            }

            //90
             for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	tmp1[i][j] = map[N-j-1][i];
                }
            }
            
            //180
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	tmp2[i][j] = tmp1[N-j-1][i];
                }
            }
            
            //270
           for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	tmp3[i][j] = tmp2[N-j-1][i];
                }
            }
          
            System.out.println("#"+test_case);
          for(int i=0; i<N; i++){
              
            	for(int j=0; j<N; j++){
                	System.out.print(tmp1[i][j]);
                }
              System.out.print(" ");
              
               for(int j=0; j<N; j++){
                	System.out.print(tmp2[i][j]);
                }
              System.out.print(" ");
              
              for(int j=0; j<N; j++){
                	System.out.print(tmp3[i][j]);
                }
              System.out.println();
              
             }
	}
}
}