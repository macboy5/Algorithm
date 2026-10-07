import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static Pos company, home;
    static List<Pos> customers;
    static boolean[] visited;
    static int minDistance;
    
    static class Pos {
        int r, c;
        
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());     

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            // Integer.pasrseInt -> Integer.parseInt 오타 수정
            home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            customers = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                customers.add(new Pos(r, c));
            }
            
            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;
            
            dfs(0, company, 0);
            
            System.out.println("#" + test_case + " " + minDistance);
        }
    }
    
    private static void dfs(int count, Pos current, int sumDist) {
        if(sumDist >= minDistance) return;
        
        if(count == N) {
            int totalDist = sumDist + getDistance(current, home);
            minDistance = Math.min(minDistance, totalDist);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                Pos next = customers.get(i);
                dfs(count + 1, next, sumDist + getDistance(current, next));
                visited[i] = false;
            }
        }
    }
    
    private static int getDistance(Pos p1, Pos p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);   
    }
}