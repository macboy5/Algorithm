class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] dp = new int[1001];

         
        int maxCnt = -1;
        int idx=0;
        int flag = -1;
        for(int i=0; i<array.length; i++){
            idx = array[i];
            dp[idx]++;
            
            if(dp[idx] > maxCnt){
                maxCnt = dp[idx];
                answer = idx;
                flag = -1;
                continue;
            }
            if(dp[idx] == maxCnt){
                flag = 1;
            }
        }
        
        if(flag ==1 ) answer =-1;
        
        
        return answer;
    }
}