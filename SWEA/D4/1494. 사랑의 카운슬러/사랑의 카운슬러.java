import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static class Pos{
        int x,  y;
        
        Pos(int x, int y){
        	this.x = x;
            this.y = y;
        }
    
    }
    
    static List<Pos> posList = new ArrayList<>();
    static boolean[] visit;
    static int N;
    static long answer;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            visit = new boolean[N];
            answer = Long.MAX_VALUE;
            
            for(int i=0; i<N; i++){
                int x = sc.nextInt();
                int y = sc.nextInt(); // 좌표
                posList.add(new Pos(x, y));
            }

			comb(0, 0);
            
            System.out.println("#" + test_case + " " + answer);
            posList.clear();
		}
        
        sc.close();
	}
    
    private static void comb(int start, int depth){
     	if(depth == N/2){ // 다 뽑았을 때
      		
            long sumX = 0;
            long sumY = 0;
            for(int i=0; i<N; i++){
               	Pos cur = posList.get(i);
            	
                if(visit[i]){
                    sumX += cur.x;
                    sumY += cur.y;
                }
                else{
                    sumX -= cur.x;
                    sumY -= cur.y;
                }
            }
            
            long result = sumX*sumX + sumY*sumY;
            
            answer = answer > result ? result : answer;
            return;
        }
        
        for(int i=start; i<N; i++){
         
            visit[i] = true;
            comb(i+ 1, depth + 1);
            visit[i] = false;            
     
        }
        
    }
    
}