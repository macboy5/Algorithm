import java.util.*;
import java.io.FileInputStream;


class Solution
{
    
    public static int N;
    public static char[][] map ;
    public static int[][] real;
    public static int[] dc = {0, +1, +1, +1, 0, -1, -1,  -1};
    public static int[] dr = {+1, +1, 0, -1, -1, -1, 0, +1};
    public static boolean[][] isVisited;
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            map = new char[N][N];
            real = new int[N][N];
            isVisited = new boolean[N][N];
            
			for(int i=0; i<N; i++){
             	map[i] = sc.next().toCharArray(); 
            }
			
            
            for(int i=0; i<N; i++){
             for(int j=0; j<N; j++){
                 if(map[i][j] == '.'){ 	/// 주변 8방향 검사해서 갯수를 넣어준다.

                     int cnt = 0;
                     
                     for(int dir = 0 ; dir<8; dir++){
                      	int nr = i+ dr[dir];
                        int nc = j + dc[dir];
                         
                         if(nr >= 0 && nr <N && nc>= 0 && nc<N
                           && map[nr][nc] == '*' ){
                             cnt++;
                         }
                         
                     }
                     real[i][j] = cnt;
                     
                 }
                 if(map[i][j] == '*'){
                   real[i][j] = -1;   
                 }
                 
             }
            }
            
//            for(int i=0; i<N; i++){
//             for(int j=0 ; j<N; j++){
//              	System.out.print(real[i][j] + " ");   
//             }
//                System.out.println();
//            }
            
            
            
            // 0인 지점을 먼저 찾아서 퍼뜨려 나간다
            int cnt = 0;
            
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(real[i][j] == 0 && !isVisited[i][j]) {
            			
            			Queue<int[]> q = new ArrayDeque<>();
            			q.add(new int[] {i,j, -1});
            			isVisited[i][j] = true;
            			
            			while(!q.isEmpty()) {
            				int[] cur = q.poll();
            				int r = cur[0];
            				int c = cur[1];
            				int flag = cur[2];
            				if(flag == 1) {
            					continue;
            				}
            				
            				for(int dir=0; dir<8; dir++) {
            					int nr = r + dr[dir];
            					int nc = c + dc[dir];
            					
            					if(nr>=0 && nr < N && nc>=0 && nc<N
            							&& !isVisited[nr][nc]) {
            						
            						isVisited[nr][nc] = true;	
            						
            					if(real[nr][nc] == 0) {
            						q.add(new int[] {nr, nc, -1});
            					}
            					else q.add(new int[] {nr, nc, 1});
            					
        						
            					
            					}
            					

            				}           				
            				
            			}
            			
            			cnt++;
            		}
            		else continue;
            	}
            }
            
            // 나머지에 대해서 >=1 인 지점들을 검사한다
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(real[i][j] >= 1 && !isVisited[i][j]) {
                        cnt++; // 아직 열리지 않은 숫자 칸은 각각 1번씩 클릭해야 함
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);

		}
	}
}