import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int cnt = array.length;
        int middle = cnt/2;
        
        Arrays.sort(array);
        
        answer = array[middle];
        
        return answer;
    }
}