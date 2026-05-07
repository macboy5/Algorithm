import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 중복을 허용하지 않고 자동으로 정렬해주는 Set 사용
        Set<Integer> set = new TreeSet<>();
        
        // 2부터 n까지 나누기 시작
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) { // i로 나누어 떨어지는 동안 계속 나눔
                set.add(i);      // i는 자동으로 소수가 됨
                n /= i;
            }
        }
        
        // Set을 int[]로 변환
        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            answer[idx++] = num;
        }
        
        return answer;
    }
}