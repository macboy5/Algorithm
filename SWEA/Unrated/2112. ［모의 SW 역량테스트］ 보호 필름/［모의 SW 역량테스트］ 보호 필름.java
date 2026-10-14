import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int D, W, K, answer;
    static int[][] map;
    static int[][] original;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 1. 배열 메모리 할당
            map = new int[D][W];
            original = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    original[i][j] = map[i][j];
                }
            }

            answer = Integer.MAX_VALUE;

            if (K == 1 || check()) {
                System.out.println("#" + test_case + " 0");
                continue;
            }

            dfs(0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void dfs(int row, int cnt) {

        if (cnt >= answer) return;

        if (row == D) {
            if (check()) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        // 1. 약품 투여 안함
        dfs(row + 1, cnt);

        // 2. A 약품 투여 (0)
        for (int i = 0; i < W; i++) map[row][i] = 0;
        dfs(row + 1, cnt + 1);

        // 3. B 약품 투여 (1)
        for (int i = 0; i < W; i++) map[row][i] = 1;
        dfs(row + 1, cnt + 1);

        // 4. 원래 상태로 복구
        for (int i = 0; i < W; i++) map[row][i] = original[row][i];
    }

    // 성능 검사 (모든 열에서 연속된 동일 특성이 K개 이상 존재하는지 확인)
    private static boolean check() {
        for (int col = 0; col < W; col++) {
            int cnt = 1;
            int maxCnt = 1;

            for (int row = 0; row < D - 1; row++) {
                if (map[row][col] == map[row + 1][col]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            if (maxCnt < K) return false;
        }

        return true;
    }
}