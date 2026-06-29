class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0){
        int remainder = storey % 10;
        storey /= 10;
        
        // 6 7 8 9 일 때 올린다.
        if(remainder>5){
            answer += (10-remainder);
            storey++;
        }
        // 0 1 2 3 4 일 때 버린다.
        else if(remainder < 5){
            answer += remainder;
        }
        // 5 일 때.
        if(remainder == 5){
            answer += remainder;
            if(storey%10>=5){
                storey++;
            }   
        }
        
        
        }
        
        return answer;
    }
}