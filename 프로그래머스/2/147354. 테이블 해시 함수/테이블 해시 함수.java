import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1,o2)->{
            if(o1[col-1] != o2[col-1]){
                return o1[col-1]-o2[col-1];
            }
            else{
                return o2[0]-o1[0];
            }
        });
        
        
        for(int i=row_begin; i<= row_end; i++){
            int[] tmp = data[i-1];
            int sum = 0;
            for(int j=0; j<tmp.length; j++){
                sum += tmp[j]%i;
            }           
            answer ^= sum;
        }
        
        
        
        return answer;
    }
}