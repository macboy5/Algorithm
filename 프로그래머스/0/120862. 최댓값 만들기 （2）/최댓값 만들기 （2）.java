import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        int len = numbers.length;
        
        answer = Math.max(numbers[0]*numbers[1], numbers[len-2] * numbers[len-1]);
        
        return answer;
    }
}