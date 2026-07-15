class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int winCnt = 0, zeroCnt=0;
        
        for(int lotto : lottos){
            
            if(lotto == 0){ 
                zeroCnt++;
                continue;
                          }
            for(int win_num : win_nums){
                if(lotto == win_num) winCnt++;

            }
        }
        
        int max = winCnt + zeroCnt;
        
        answer[0] = calculate(max);
        answer[1] = calculate(winCnt);
        
        return answer;
    }
    
    public int calculate(int cnt){
        if(cnt==6) return 1;
        if(cnt==5) return 2;
        if(cnt ==4) return 3;
        if(cnt ==3) return 4;
        if(cnt ==2) return 5;
        else return 6;
    }
}