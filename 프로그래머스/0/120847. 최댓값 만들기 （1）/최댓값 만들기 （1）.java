import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        int length = numbers.length;
        
        answer = numbers[length-1] * numbers[length-2];
        
        return answer;
    }
}