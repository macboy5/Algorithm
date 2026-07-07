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
		
			int N, M, num;
            N = sc.nextInt();
            M = sc.nextInt();
            
            int map[][] = new int[N][N];
            
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                    num = sc.nextInt();
                	map[i][j] = num;
                }
            }
            
            
            int max = -1;
            
           
            // (i,j)에서 M칸 검사
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
					int sum = map[i][j];
                    int total = map[i][j];
                    
                    // 정방향 검사 
                    for(int k=M-1; k>=1; k--){
                    	//좌
                        if(j-k>=0){
                        	sum += map[i][j-k];
                        }
                        //우
                        if(j+k < N){
                        	sum += map[i][j+k];
                        }
                        //상
                        if(i-k>=0){
                        	sum += map[i-k][j];
                        }
                        //하
                        if(i+k<N){
                        	sum += map[i+k][j];
                        }
                    }
                    
                    // 대각선 검사
                   for(int k=M-1; k>=1; k--){
                   		//left up
                       if(i-k>=0 && j-k>=0){
                       		total += map[i-k][j-k];
                       }
                       // right up
                       if(i-k>=0 && j+k<N){
                       		total += map[i-k][j+k];
                       }
                       // right down
                       if(i+k<N && j+k<N){
                       		total += map[i+k][j+k];
                       }
                       // left down
                       if(i+k<N && j-k>=0){
                       		total += map[i+k][j-k];
                       }
                   }
                    
                    
                    
                    // 대소비교
                    total = Math.max(sum, total);
                    max = Math.max(max, total);
                    
                    
                }
            }
            
            
            System.out.println("#"+ test_case + " " + max);
            
            
		}
	}
}