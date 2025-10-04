#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <queue>

using namespace std;

long long fibo(int n) {
    long long dp[91];
    dp[0] = 0;
    dp[1] = 1;
    
    if(n>=2){
    for(int i=2; i<=n ; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    }
    
    return dp[n];

}

int main() {
    int n;
    cin >> n;
    cout << fibo(n);


    return 0;
}