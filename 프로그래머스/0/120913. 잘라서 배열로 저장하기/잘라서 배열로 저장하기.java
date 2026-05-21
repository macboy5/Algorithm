class Solution {
    public String[] solution(String my_str, int n) {
        int strLen = my_str.length();
        
        int size = (strLen % n == 0) ? strLen / n : strLen / n + 1;
        String[] answer = new String[size];
        
        int idx = 0;
        for (int i = 0; i < strLen; i += n) {
            int end = Math.min(i + n, strLen);
            answer[idx++] = my_str.substring(i, end);
        }
        
        return answer;
    }
}