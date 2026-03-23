class Solution {
    public int[] solution(int[] num_list) {
    
        int length = num_list.length;
        int tmp; 
        
        int[] answer = new int[length + 1];
        
        for(int i=0; i<length; i++){
            answer[i] = num_list[i];
        }
          
        if(num_list[length-1] > num_list[length-2]){
            tmp = num_list[length-1] - num_list[length-2];
        }
        else{
            tmp = num_list[length-1]*2;
        }
        
        answer[length] = tmp;
        
        
        return answer;
    }
}