class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String tmp1 = Integer.toString(a) + Integer.toString(b);
        int tmp2 = Integer.parseInt(tmp1);
        
        int tmp3 = 2*a*b;
        
        answer = tmp2>=tmp3 ? tmp2 : tmp3;
        
        return answer;
    }
}