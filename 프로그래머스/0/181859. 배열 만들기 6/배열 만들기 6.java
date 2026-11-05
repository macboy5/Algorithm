import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        Stack<Integer> st = new Stack<>();
        
        int i = 0;
        while(i < arr.length){
            
            if(st.isEmpty()){
                st.push( arr[i] );
                i++;
            }
            else{
                if( st.peek() == arr[i] ){
                    st.pop();
                    i++;
                }
                else{
                    st.push(arr[i]);
                    i++;
                }
            }
            
        }
        
        if(st.isEmpty()) return new int[]{-1};
        
        answer = new int[st.size()];
        
        for(int j=st.size()-1; j >= 0 ; j--){
            answer[j] = st.pop();
        }
        
        
        return answer;
    }
}