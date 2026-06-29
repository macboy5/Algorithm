import java.util.*;

class Solution {
    public int solution(String A, String B) {
        
        if(A.equals(B)) return 0;
        
        int len = A.length();
        String tmp = "";
        
        int cnt = 0;
        for(int i=0; i<len; i++){
            tmp += A.substring(len-1);
            tmp += A.substring(0,len-1);
            
            System.out.println("tmp : " + tmp);
            
            cnt++;
            if(tmp.equals(B)) break;
            else {
                A = tmp;
                  tmp = "";}
        }
        
        if(cnt == len) return -1;
        else return cnt;
        
        
    }
}