class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        
        int len = num_list.length - n+1;
        
        answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = num_list[i+n-1];
        }
        
        return answer;
    }
}