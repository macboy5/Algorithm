class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        long a = 1, b=0;
        for(int n : num_list){
            a *= n;
            b += n;
        }
        
        if(a < Math.pow(b,2)) answer = 1;
        
        return answer;
    }
}