class Solution {
    public int solution(int n, int w, int target) {
        int answer = 0;
        
        int row = n%w==0 ? n/w : n/w+1;
        
        int[][] map = new int[row][w];
        
        boolean rightDir = true;
        int num = 1;
        
        int target_row = 0, target_col = 0;
        
        loopout : 
        for(int i = row-1; i>=0; i--){
            
            for(int j=0; j<w; j++){
                if(num > n){
                    break loopout;
                }
                if(rightDir){
                    map[i][j] = num++;
                }
                else{
                    map[i][w-j-1] = num++;
                }
            }
            
            if(rightDir){
                rightDir = false;
            }
            else{
                rightDir = true;
            }
            
        }
        
        for(int i=0; i<row ; i++){
            for(int j=0; j<w; j++){
                
                if(map[i][j] == target){
                    target_row = i;
                    target_col = j;
                    break;
                }
                
            }
        }
        
        for(int i=0; i<=target_row ; i++){
            if(map[i][target_col] >0) answer++;
        }
              
        
        
        
        return answer;
    }
}