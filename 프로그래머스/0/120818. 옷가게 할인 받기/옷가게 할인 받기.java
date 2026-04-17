class Solution {
    public int solution(int price) {
        int answer = 0;
        
        double answer1 = 0;
        
        if(price <100000)
            return answer = price;
        
        if(price >= 100000){
            answer1 = price *0.95;
        }
        
        if(price >= 300000){
            answer1 = price * 0.9;

        }
        
        if(price >=500000){
            answer1 = price * 0.8;
        }
                
        answer = (int)answer1;
        
        return answer;
    }
}