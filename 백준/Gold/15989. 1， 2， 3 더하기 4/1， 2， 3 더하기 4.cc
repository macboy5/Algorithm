#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <queue>

using namespace std;

int dp[10001][4];

void solve(){

    dp[1][1] = 1;
    dp[2][1] = dp[2][2] = 1;
    dp[3][1] = dp[3][2] = dp[3][3] = 1;

    for(int i=4; i<=10000; i++){
        dp[i][1] = dp[i-1][1];
        dp[i][2] = dp[i-2][1] + dp[i-2][2];
        dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
    }


}

int main() {


    int T;
    cin >> T;

    solve();

    for(int i=1; i<=T; i++){
        int tmp;
        cin >> tmp;
        cout << dp[tmp][1] + dp[tmp][2] + dp[tmp][3] << "\n";
    }


    return 0;
}