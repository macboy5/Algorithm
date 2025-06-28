//#include <iostream>
//
//using namespace std;
//
//int main(){
//    ios_base::sync_with_stdio(false);
//    cin.tie(NULL);
//
//    int T, N, M;
//    cin >> T;
//
//    while(T--){
//        cin >> N >> M;  // N은 참가자수. M은 게임수.
//
//        int * arr = new int[N+1];
//
//        // sum1은 홀수 합, sum2는 짝수 합.
//        int sum1 = 0, sum2 = 0;
//        for(int i=1; i<=N; i++){
//            if(i%2 == 0) {
//                sum2 += i;
//                arr[i] = 1;     // 짝수인 경우 flag.
//            }
//            else sum1 += i;
//        }
//        cout << sum1-sum2 << ' ';
//
//        for(int i=0; i< M-1; i++){
//            int tmp;
//            cin >> tmp;
//            if( arr[tmp] == 1 ){
//                sum2 -= tmp;
//                sum1 += tmp;
//                arr[tmp] = 0;
//            }
//            else{
//                sum1 -= tmp;
//                sum2 += tmp;
//                arr[tmp] = 1;
//            }
//
//            cout << sum1 - sum2 << ' ';
//        }
//
//        cout << endl;
//
//        cout.flush();
//
//    }
//    return 0;
//}

#include <iostream>
#include <unordered_map>
using namespace std;

using ll = long long;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        ll N;
        int M;
        cin >> N >> M;

        // 초기 팀 실력 합 계산
        ll odd_count = (N + 1) / 2;
        ll even_count = N / 2;

        ll team1_sum = odd_count * odd_count;
        ll team2_sum = even_count * (even_count + 1);
        ll diff = team1_sum - team2_sum;

        cout << diff << ' ';

        // 이동 횟수 기록 (최대 M-1번)
        unordered_map<ll, int> move_count;

        for (int i = 0; i < M - 1; i++) {
            ll x;
            cin >> x;

            move_count[x]++;
            if (move_count[x] % 2 == 1) {
                // odd number of moves → x가 반대 팀으로 이동
                if (x % 2 == 0) diff += 2 * x;
                else diff -= 2 * x;
            } else {
                // 짝수번 이동 → 원래 팀으로 복귀
                if (x % 2 == 0) diff -= 2 * x;
                else diff += 2 * x;
            }

            cout << diff << ' ';
        }

        cout << '\n';
        cout.flush();
    }

    return 0;
}
