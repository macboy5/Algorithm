import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        int[] answer = new int[len];
        
        int[] sums = new int[len];
        for (int i = 0; i < len; i++) {
            sums[i] = score[i][0] + score[i][1];
        }

        for (int i = 0; i < len; i++) {
            int rank = 1;
            for (int j = 0; j < len; j++) {
                if (sums[j] > sums[i]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        
        return answer;
    }
}