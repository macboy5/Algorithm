import java.util.*;

class Solution {
    
   
    static int[] pick = new int[5];
    static HashSet<List<Integer>> set = new HashSet<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // 1~n중 5개 뽑아서 만들 수 있는 모든 조합을 구한다
        getCom(1,n, 0);
        
        
        // 입력한 정수와 시스템응답까지 같게 나오는 개수를 return.
        for(List<Integer> list : set){
            
            int[] s = new int[5];
            for(int i=0; i<5; i++){
                s[i] = list.get(i);
            }

            
            boolean flag = true;
            for(int j=0; j< q.length; j++){
                if( compare(s, q[j] ) == ans[j]) continue;
                else{
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
            
        }
        
        return answer;
    }
    
    private int compare(int[] a1, int[] a2){
        int cnt = 0;
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(a1[i] == a2[j]) cnt++;    
            }
        }
        
        
    
        return cnt;
    }
    
    
    private void getCom(int start, int n, int depth){
        if(depth == 5){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<5 ; i++){
                list.add(pick[i]);
            }
            set.add(list);           
            return;
        }
        
        for(int i=start; i<=n; i++){
            
            pick[depth] = i;    
            getCom(i+1, n, depth+1);
            
        }
        
    }
}