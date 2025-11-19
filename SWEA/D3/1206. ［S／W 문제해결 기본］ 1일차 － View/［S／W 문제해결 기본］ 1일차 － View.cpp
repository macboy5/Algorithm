#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;

int view(vector <int> &building, int N){
    int cnt = 0;

    for(int i=2; i<N+2; i++){
        int cur = building[i];
        int left = max(building[i-2], building[i-1]);
        int right = max(building[i+1], building[i+2]);

        if(cur > left && cur > right){
            int tmp = max(left, right);
            cnt += (cur - tmp);
        }

    }

    return cnt;

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for(int j=1 ; j<=10; j++) {
        int N;
        cin >> N;

        vector<int> building(N + 4, 0);

        for (int i = 2; i < N + 2; i++) {
            cin >> building[i];
        }

        cout <<"#" <<j <<" " << view(building, N) <<"\n";

    }

    return 0;
}