class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int len = num_list.length;
        if(len <= 10){
            answer = 1;
            for(int num : num_list){
                answer *= num;
            }
        }
        else if(len >= 11){
            for(int num : num_list){
                answer += num;
            }
        }
        return answer;
    }
}