import java.util.*;

class Solution {
    static char[][]map;
    static int N, M;
    static int endR, endC;
    static String answer ="";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        N = n;
        M = m;
        
        map = new char[n][m];
        
        //(x-1, y-1) 출발 (r-1,c-1) 도착 k번 이동
        endR = r-1;
        endC = c-1;
        
        
        dfs("", x-1, y-1, 0, k);
        
        
       return answer == "" ? "impossible" : answer;
        
    }
        
    private static void dfs(String path, int nowR, int nowC, int depth, int k){
        
        if(!answer.equals("")) return;
        
        int remainDist = Math.abs(nowR - endR) + Math.abs(nowC - endC);
        int remainMove = k - depth;
        if (remainDist > remainMove || (remainMove - remainDist) % 2 != 0) return;
        
        if(depth == k){
            if(nowR == endR && nowC == endC){
                answer = path;
            }
            return;
        }
        
        if(nowR+1 < N){
            dfs(path+'d', nowR+1, nowC, depth+1, k);
        }      
        if(nowC-1 >=0){
            dfs(path+'l', nowR, nowC-1, depth+1, k);
        }
        
        if( nowC+1 < M){
            dfs(path+'r', nowR, nowC+1, depth+1, k);
        }
        
        if(nowR-1 >= 0){
            dfs(path+'u', nowR-1, nowC, depth+1, k);
        }

        
    }
    
    
    
}