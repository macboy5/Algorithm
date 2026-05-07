class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isHap(i)) answer++;
        }
        return answer;
    }

    boolean isHap(int n) {
       
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return true; // 1과 자기자신 외에 약수가 있으면 합성수
        }
        return false;
    }
}