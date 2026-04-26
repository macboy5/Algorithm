class Solution {
    public int solution(int hp) {
        
        // 장군 5 병정 3 일 1
        
        int gMax = hp/5;
        int remainder;
        int cnt = 987654321;
        
        for(int i=gMax; i>=0; i--){
            
            remainder = hp - i*5;
        
            int tmp = i + remainder/3 + remainder%3;
            if(tmp < cnt) cnt = tmp;
            
        }
        
        return cnt;
    }
}