class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int div =0;
        int remainder=  0;
        
        while(n>=a){

            remainder = n%a;
            answer += (n/a)*b;
            n = (n/a)*b + remainder;
            
        }
        
        return answer;
    }
}