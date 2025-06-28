//#include <iostream>
//
//using namespace std;
//
//int cal_distance( int *arr, int N){ //������ �Ÿ� ���.
//
//    int min = 987654321;
//    int dis = 0;
//    for(int i= 1; i<=N-2; i++){
//        dis = 0;
//
//        for(int j=0; j<i-1; j++){
//            dis += abs(arr[j+1] - arr[j]);
//        }
//        dis += arr[i+1] - arr[i-1];
//        for(int j=i+1; j<=N-2; j++){
//            dis += abs(arr[j+1] - arr[j]);
//        }
//
//        if ( dis < min){
//            min = dis;
//        }
//    }
//
//    return min;
//}
//
//int main() {
//    ios_base::sync_with_stdio(false);
//    cin.tie(NULL);
//
//    int T;  //T�� �׽�Ʈ ���̽� �Է� ��
//    cin >> T;
//    int * result = new int[T];
//    for (int i=0; i<T; i++){
//
//        int N; // N�� üũ ����Ʈ �� (3 �� N �� 100,000)
//        cin >> N;
//        int * arr = new int[N];
//
//        for ( int j = 0 ; j< N; j++){
//            cin >> arr[j];
//        }
//
//        result[i] = cal_distance(arr, N);
//
//        delete []arr;
//        cout.flush();
//
//    }
//
//    for(int i =0 ;i<T; i++) {
//       cout << result[i] << endl;
//    }
//    delete []result;
//
//    return 0;
//}

#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;
        int* arr = new int[N];
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }

        // ��ü �Ÿ� ���
        int total_dist = 0;
        for (int i = 1; i < N; i++) {
            total_dist += abs(arr[i] - arr[i - 1]);
        }

        // ���� �� �ִ� ���� �Ÿ� ���
        int max_saved = 0;
        for (int i = 1; i < N - 1; i++) {
            int original = abs(arr[i] - arr[i - 1]) + abs(arr[i + 1] - arr[i]);
            int skip = abs(arr[i + 1] - arr[i - 1]);
            max_saved = max(max_saved, original - skip);
        }

        cout << (total_dist - max_saved) << "\n";

        delete[] arr;
    }

    return 0;
}
