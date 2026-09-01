class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int len = sticker.length;
        // 스티커가 1개인 경우
        if (len == 1) {
            return sticker[0];
        }
        // 스티커가 2개인 경우 둘 중 큰 값 반환
        if (len == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        int[] dp3 = new int[len];

        // 0번째 idx부터 시작
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        
        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);        
        }
        dp1[len-1] = dp1[len-2];
        
        
        // 1번째 idx부터 시작
        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = sticker[1];
        
        for(int i=3; i<len; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);        
        }
        
        // 2번쨰 idx부터 시작
        dp3[0] = 0;
        dp3[1] = 0;
        dp3[2] = sticker[2];
        
        for(int i=4; i<len; i++){
             dp3[i] = Math.max(dp3[i-2] + sticker[i], dp3[i-1]);   
        }
        
        
        answer = Math.max(dp1[len-1], dp2[len-1]);
        answer = Math.max(answer, dp3[len-1]);
        
        return answer;
    }
}