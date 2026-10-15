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
           
			int N = sc.nextInt();
            int M = sc.nextInt();
            boolean[][] adj = new boolean[N+1][N+1];
            
            for(int i=1; i<= M ; i++){
            	int a = sc.nextInt();
                int b = sc.nextInt();
                // a학생키 < b 학생 키
            	adj[a][b] = true;                    
            }
            
           for(int i=1; i<=N; i++){
            	for(int k=1; k<=N; k++){
                 	for(int j=1; j<= N ; j++){
                     	if( adj[i][k] && adj[k][j]){
                         	adj[i][j]= true;   
                        }
                    }
                }
           }
           
            int answer = 0;
            
            for(int i=1; i<= N ; i++){
             	int cnt = 0;
                for(int j=1; j<= N; j++){
                 	if(adj[i][j] || adj[j][i]){
                     	cnt++;   
                    }
                }
               
                             if( cnt == N-1) answer++;
            }
            

            
            
			
            System.out.println("#" + test_case + " " + answer);
            
		}
        
        sc.close();
        
	}
}