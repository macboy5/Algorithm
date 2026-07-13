import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int start = 0;
        int end = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(!flag && arr[i] == 2){
                flag = true;
                start = i;
            }
            else if(flag && arr[i]==2 ){
                end = i;
            }
        }
        
        if(start==0 && end ==0){
            list.add(-1);
        }
        else if(flag && end == 0){
            list.add(2);
        }
        else if(flag && end!=0){
            for(int i=start; i<=end ; i++){
                list.add(arr[i]);
            }    
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}