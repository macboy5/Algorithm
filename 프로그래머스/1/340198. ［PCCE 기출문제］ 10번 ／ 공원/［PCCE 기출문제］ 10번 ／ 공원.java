import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats);
        
        for(int i=mats.length-1; i>=0; i--){
            
            int cur = mats[i];

            if(func(park, cur)) return mats[i];
            
        }
        
        return -1;
    }
    
    public boolean func(String[][] park, int cur){
        
        int row = park.length;
        int col = park[0].length;
        
        // cur x cur 짜리 윈도우 움직여볼까...?
        
        for(int i=0; i<=row-cur; i++){
            for(int j=0; j<=col-cur; j++){
                // 시작점 (i,j)
                if(!park[i][j].equals("-1")) continue;
                
                boolean flag = true;
                
                loop2 : 
                for(int k=0; k<cur; k++){
                    for(int s=0; s<cur; s++){
                        if(park[i+k][j+s].equals("-1")) continue;
                        else {
                            flag = false;
                            break loop2;
                        }
                    }
                }
                if(flag) return true;
            }
        }
        
        
        
        return false;
    }
}