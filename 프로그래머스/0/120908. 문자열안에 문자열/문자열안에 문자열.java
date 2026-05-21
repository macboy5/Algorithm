import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        
        for(int i=0; i<chars1.length; i++){
            int flag = -1;
            
            for(int j=0; j<chars2.length; j++){
                if(i+j < chars1.length && chars1[i+j] == chars2[j]) continue;
                else {
                    flag = 1;
                    break;
            }
            }
            if(flag == -1){
                return 1;
            }
            
        }
        
        
        return answer;
    }
}