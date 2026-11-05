import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int len = arr.length;
        int targetLen = 1;
        
        while(targetLen < len){
            targetLen *= 2;
        }
        
        return Arrays.copyOf(arr, targetLen);
    }
}