#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;


int solve(vector<int> &score, int n){

    // dp[n] : n번째 계단 위치에서의 최대 점수값
    vector<int> dp(n+1);

    dp[1] = score[1];
    dp[2] = score[1] + score[2];
    dp[3] = max(score[1] + score[3], score[2]+score[3]);

    for(int i=4; i<=n; i++){
        dp[i] = max(dp[i-2] + score[i], dp[i-3]+score[i-1]+score[i]);
    }

    return dp[n];
}



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> score(n+1);

    for(int i=1;i<=n;i++){
        cin>> score[i];
    }

    cout << solve(score, n);

    return 0;
}