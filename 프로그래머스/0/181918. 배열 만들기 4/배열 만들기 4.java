import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        int i = 0;
        
        while(i<arr.length){
            if(stk.isEmpty()){
                stk.add(arr[i++]);
                continue;
            }
            else{
                if(stk.get(stk.size() - 1) < arr[i]){
                    stk.add(arr[i++]);
                    continue;
                }
                else{
                    stk.remove(stk.size()-1);
                    continue;
                }
            }
        }
        
        
        int[] list = new int[stk.size()];
        
        for(int j=0; j<stk.size(); j++){
            list[j] = stk.get(j);
        }
        
        
        return list;
    }
}