class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String tmp1="", tmp2="";
        
        for(int n : num_list){
            
            if(n%2 != 0){
                tmp1 += n;
            }
            else tmp2 += n;
            
        }
        
        answer = Integer.parseInt(tmp1) + Integer.parseInt(tmp2);
        
        return answer;
    }
}