class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String tmp1 = Integer.toString(a)+Integer.toString(b);
        String tmp2 = Integer.toString(b)+Integer.toString(a);
        
        int tmp3 = Integer.parseInt(tmp1);
        int tmp4 = Integer.parseInt(tmp2);
        answer = tmp3>=tmp4 ? tmp3 : tmp4;
        
        return answer;
    }
}