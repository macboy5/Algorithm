import java.util.*;

class Solution {
    public int solution(String before, String after) {
        
        char[] b = before.toCharArray();
        Arrays.sort(b);
        char[] a = after.toCharArray();
        Arrays.sort(a);
        
        for(int i=0; i< b.length;i++){
            System.out.print("b : " + b[i]);
            System.out.println(",  a : " + a[i]);
        }
        
        if(Arrays.equals(a,b)) return 1;
        else return 0;
    
    }
}