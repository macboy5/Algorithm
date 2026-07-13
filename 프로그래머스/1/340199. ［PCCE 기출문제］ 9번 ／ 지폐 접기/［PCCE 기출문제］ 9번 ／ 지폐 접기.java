import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
        int min = wallet[0];
        int max = wallet[1];
        
        Arrays.sort(bill);
        
        while(true){
            
            int shrt = bill[0];
            int lng = bill[1];
            
            if(shrt > min || lng > max){
                lng /= 2;
                answer++;
            }
            else break;
                        
            bill[1] = lng;
            
            Arrays.sort(bill);
        }
        
        
        return answer;
    }
}