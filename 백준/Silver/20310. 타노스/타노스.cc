#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해

using namespace std;

void solve(string S){
    int cnt_zero = 0, cnt_one = 0;

    for(int i=0; i<S.length(); i++){
        if(S[i] == '0') cnt_zero++;
        else cnt_one++;
    }

    string answer = "";

    for(int i=1; i<=cnt_zero/2; i++){
        answer += '0';
    }
    for(int i=1; i<=cnt_one/2; i++){
        answer += '1';
    }

    cout << answer;


}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string S;
    cin >> S;

    solve(S);

    return 0;
}