#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <set>

using namespace std;

void solve(string bench, int N, int K){

    for(int i=0; i<N; i++){
        if(bench[i] == 'P'){
            for(int j= i-K; j<= i+K; j++){
                if( j>=0 && j< N && bench[j] == 'H'){
                    bench[j] = 'X';
                    break;
                }
            }
        }
    }

    int cnt = 0;
    for(int i=0; i<N; i++){
        if(bench[i] == 'X') cnt++;
    }

    cout << cnt;

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;
    string bench;
    cin >> bench;

    solve(bench, N, K);

    return 0;
}