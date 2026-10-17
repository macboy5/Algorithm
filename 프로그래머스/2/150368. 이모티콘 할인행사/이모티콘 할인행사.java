import java.util.*;
class Solution {
    
    int[] discountRate = new int[]{10, 20, 30, 40};
    int[] pick;
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        
       // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
       // 2. 이모티콘 판매액을 최대한 늘리는 것.      
    
        pick = new int[emoticons.length];
        
        dfs(0, users, emoticons);

        
        
        // 이모티콘플러스 가입자 수, 매출액 return
        return answer;
    }
    
    private void dfs(int depth, int[][] users, int[] emoticons){
        
        if(depth == emoticons.length){
            calculate(users, emoticons);
            return;
        }
        
        for(int i=0; i<4; i++ ){
            pick[depth] = discountRate[i];
            dfs(depth +1, users, emoticons);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons){
        
        int subscribe = 0;
        int sales = 0;
        
        for(int[] user : users){
            int rate = user[0];
            int fee = user[1];
            int sum = 0;
            
            for(int i=0; i<pick.length; i++){
                
                if(pick[i] >= rate){
                    sum += emoticons[i] * (double)( 100 - pick[i]) / 100;
                }
            }
            
            if(sum >= fee){
                subscribe++;
            }
            else{
                sales += sum;    
            }
            
        }
        
        if(answer[0] < subscribe){
            answer[0] = subscribe;
            answer[1] = sales;
        }
        else if(answer[0] == subscribe){
            if(answer[1] < sales){
                answer[1] = sales;
            }
        }
        
        
    }
    
}