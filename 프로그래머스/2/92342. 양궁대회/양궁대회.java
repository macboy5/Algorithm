import java.util.*;

class Solution {
    
    int diff = -1;
    List<int[]> list = new ArrayList<>();    

    public int[] solution(int n, int[] info) {

        // n발. info : 어피치가 맞춘 점수 내역.
        
        int[] lion = new int[11];
        
        func(0, n, info, lion);
        
        if(list.isEmpty()) return new int[]{-1};
        
        list.sort( (a,b) -> {
           for(int i=10; i>=0; i--){
               if(a[i] != b[i]){
                   return Integer.compare(b[i], a[i]);
               }
           }
            return 0;
        });
        
        return list.get(0);
        
        // 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지 return
    }
    
    private void func(int idx, int arrowLeft, int[] info, int[] score){
        if(arrowLeft == 0 || idx == 11){
            if(arrowLeft > 0){
                score[10] += arrowLeft;
            }
            
            int apeach = 0, lion = 0;
            
            // k 점에 어피치가 a 발, 라이언이 b발 맞춰었을 때, 
            // a>=b 어피치 승, a < b 라이언승, a == b == 0 무승부
            for(int i=0; i<=10; i++){
                if(info[i] == score[i] && info[i] == 0) continue;
                else if(info[i] >= score[i]) apeach += (10-i);
                else if(info[i] < score[i]) lion += (10-i);
            }
            
            if(apeach < lion){
                int curDiff = lion - apeach;
                
                if(diff < curDiff){
                    diff = curDiff;
                    list.clear();
                    list.add(score.clone());
                }
                else if(diff == curDiff){
                    list.add(score.clone());
                }
            }
            
            if(arrowLeft > 0){
                score[10] -= arrowLeft;
            }
            
            return;
        }
        
        for(int i=0; i<=10; i++){

        }
        
        // 어피치 보다 1발 더 쏘는 경우
        if(arrowLeft > info[idx]){
            int need = info[idx] + 1;
            score[idx] += need;
            func(idx+1, arrowLeft- need , info, score);
            score[idx] -= need;
        }
        
        // 쏘지 않는 경우
        func(idx+1, arrowLeft, info, score);
        
    }
}