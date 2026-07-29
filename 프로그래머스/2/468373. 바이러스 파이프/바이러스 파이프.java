import java.util.*;

class Solution {
    static int cnt = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        cnt = 0;
        
        boolean isInfected[] = new boolean[n + 1];
        isInfected[infection] = true;
        
        infect(1, 0, k, edges, isInfected);
        infect(2, 0, k, edges, isInfected);
        infect(3, 0, k, edges, isInfected);
        
        return cnt;
    }
    
    public void infect(int type, int cur, int k, int[][] edges, boolean isInfected[]){
        if(cur == k){
            int tmp = 0;
            for(int i = 0; i < isInfected.length; i++){
                if(isInfected[i]) tmp++;
            }
            if(tmp > cnt) cnt = tmp;
            return;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // ★ 핵심: 한 번의 타입 선택 내에서 연쇄적으로 퍼져나갈 수 있도록 반복 처리
        boolean changed;
        do {
            changed = false;
            for(int[] edge : edges){
                int x = edge[0], y = edge[1], t = edge[2];
                
                if(type == t){
                    if(isInfected[x] && !isInfected[y]){
                        isInfected[y] = true;
                        list.add(y);
                        changed = true;
                    }
                    else if(!isInfected[x] && isInfected[y]){
                        isInfected[x] = true;
                        list.add(x);
                        changed = true;
                    }
                }
            }
        } while (changed); // 더 이상 새로 감염되는 노드가 없을 때까지 반복
        
        // 다음 단계 탐색 (1, 2, 3 타입 모두 시도)
        infect(1, cur + 1, k, edges, isInfected);
        infect(2, cur + 1, k, edges, isInfected);
        infect(3, cur + 1, k, edges, isInfected);
        
        // 백트래킹 원복
        for(int node : list){
            isInfected[node] = false;
        }
    }
}