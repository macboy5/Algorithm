import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // A 순서는 고정, 점수 최대 되도록 B 순서 조정
 
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        
        int idx1 = 0, idx2 = 0;
        
        while(true){
            // if(idx1>=len) break;
            if(idx2>=len) break;
            
            if(A[idx1] >= B[idx2]){
                idx2++;
            }
            else{
                idx1++;
                idx2++;
                answer++;
            }
            
            
        }
        
        return answer;
    }
}