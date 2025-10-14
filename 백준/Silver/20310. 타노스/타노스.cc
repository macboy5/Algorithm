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

    cnt_zero /= 2;
    cnt_one /= 2;

    for(int i=0; i<S.length(); i++){
        if(S[i] == '1'){
            S[i] = 'x';
            cnt_one--;
        }
        if(cnt_one == 0) break;
    }

    for(int i=S.length()-1; i>=0; i--){
        if(S[i] == '0'){
            S[i]     = 'x';
            cnt_zero--;
        }
        if(cnt_zero == 0 ) break;
    }

    string answer = "";

    for(int i=0; i<S.length(); i++){
        if(S[i] == 'x') continue;
        else answer += S[i];
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