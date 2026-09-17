import java.util.*;

class Solution
{
    public static int[] dr = {+1, -1, 0, 0};    
    public static int[] dc = {0, 0, -1, +1};
    
    public static int N;
    
    public static class Info {
        int r, c, dir, energy;
        boolean isDead;
        
        Info(int r, int c, int dir, int energy) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.energy = energy;
            this.isDead = false;
        }
    }
        
    public static int[][] map = new int[4001][4001];
    public static List<Info> infoList;
    public static int sum;
    
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            // 좌표 범위를 0 ~ 4000으로 안전하게 커버하기 위한 map
            
            infoList = new ArrayList<>();
            sum = 0;
            
            for(int i = 0; i < N; i++) {
                // 좌표 변환: (-1000 ~ 1000) -> (0 ~ 2000) * 2 = (0 ~ 4000)
                int c = 2 * (sc.nextInt() + 1000);
                int r = 2 * (sc.nextInt() + 1000); 
                int dir = sc.nextInt();
                int k = sc.nextInt();
                
                infoList.add(new Info(r, c, dir, k));
            }
            
            while(!infoList.isEmpty()) {
                
                // 1단계: 모든 원자 이동
                for(Info cur : infoList) {
                    map[cur.r][cur.c] = 0; // 일단 내 자리를 비움
                }
                
                for(int i = infoList.size() - 1; i >= 0; i--) {
                    Info cur = infoList.get(i);
                    
                    cur.r += dr[cur.dir];
                    cur.c += dc[cur.dir];
                    
                    // 범위를 벗어난 경우 
                    if(cur.r < 0 || cur.r > 4000 || cur.c < 0 || cur.c > 4000) {
                        infoList.remove(i);
                        continue;
                    }
                    
                    // 맵에 현재 원자의 에너지를 기록
                    map[cur.r][cur.c] += cur.energy;
                }
                
                // 2단계: 충돌 발생한 곳 찾기 
            
                List<Info> nextList = new ArrayList<>();
                
                for(Info cur : infoList) {

                    if(map[cur.r][cur.c] > cur.energy) {
                        sum += map[cur.r][cur.c];
                        map[cur.r][cur.c] = -1; // -1은 이미 처리된 충돌 지역 마킹
                    }
                }
                
                // 3단계: 살아남은 원자들만 다시 골라내기
                for(Info cur : infoList) {
                    // map 값이 내 에너지와 정확히 일치하면 혼자 있는 것이므로 생존
                    if(map[cur.r][cur.c] == cur.energy) {
                        nextList.add(cur);
                    } else {
                        if(map[cur.r][cur.c] > 0) {
                            map[cur.r][cur.c] = 0;
                        }
                    }
                }
                
                // 맵 잔여 정리
                for(Info cur : infoList) {
                    map[cur.r][cur.c] = 0;
                }
                
                infoList = nextList;
            }
            
            System.out.println("#" + test_case + " " + sum);
            
            for(int i=0; i<=4000; i++){
             	for(int j=0; j<= 4000; j++){
                 	map[i][j] = 0;   
                }
            }
            
        }
        
        sc.close();
    }
}