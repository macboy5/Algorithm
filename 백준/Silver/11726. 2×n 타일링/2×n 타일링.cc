#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;

int dp[1001];

void solve(int n){
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    //dp[n] = dp[n-1] + dp[n-2];

    if(n>=3) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10007;
        }
    }

}



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    solve(n);

    cout << dp[n]%10007;


    return 0;
}