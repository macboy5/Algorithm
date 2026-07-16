class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int cnt = 0;
        int total = 0;
        for(int a : arr){
            total += a;
            cnt++;
        }
        
        answer = (double)total/cnt;
        
        return answer;
    }
}