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
//        cin >> N >> M;  // N�� �����ڼ�. M�� ���Ӽ�.
//
//        int * arr = new int[N+1];
//
//        // sum1�� Ȧ�� ��, sum2�� ¦�� ��.
//        int sum1 = 0, sum2 = 0;
//        for(int i=1; i<=N; i++){
//            if(i%2 == 0) {
//                sum2 += i;
//                arr[i] = 1;     // ¦���� ��� flag.
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

        // �ʱ� �� �Ƿ� �� ���
        ll odd_count = (N + 1) / 2;
        ll even_count = N / 2;

        ll team1_sum = odd_count * odd_count;
        ll team2_sum = even_count * (even_count + 1);
        ll diff = team1_sum - team2_sum;

        cout << diff << ' ';

        // �̵� Ƚ�� ��� (�ִ� M-1��)
        unordered_map<ll, int> move_count;

        for (int i = 0; i < M - 1; i++) {
            ll x;
            cin >> x;

            move_count[x]++;
            if (move_count[x] % 2 == 1) {
                // odd number of moves �� x�� �ݴ� ������ �̵�
                if (x % 2 == 0) diff += 2 * x;
                else diff -= 2 * x;
            } else {
                // ¦���� �̵� �� ���� ������ ����
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
