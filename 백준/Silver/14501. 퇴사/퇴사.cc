#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> T(N + 1); // 상담 기간
    vector<int> P(N + 1); // 상담 금액
    vector<int> dp(N + 2, 0); // i번째 날부터의 최대 수익을 저장할 DP 테이블

    for (int i = 1; i <= N; ++i) {
        cin >> T[i] >> P[i];
    }

    // N일차부터 1일차까지 거꾸로 계산
    for (int i = N; i >= 1; --i) {
        // i번째 상담을 했을 때, 퇴사일(N+1일)을 넘기지 않는 경우만 고려
        if (i + T[i] <= N + 1) {
            // max(i번째 상담을 안 했을 때의 수익, i번째 상담을 했을 때의 수익)
            dp[i] = max(dp[i + 1], P[i] + dp[i + T[i]]);
        } else {
            // 상담 기간이 퇴사일을 넘기면, i번째 상담은 할 수 없으므로
            // i번째 상담을 하지 않았을 때의 수익과 같다.
            dp[i] = dp[i + 1];
        }
    }

    // 최종 결과는 1일부터의 최대 수익
    cout << dp[1] << endl;

    return 0;
}