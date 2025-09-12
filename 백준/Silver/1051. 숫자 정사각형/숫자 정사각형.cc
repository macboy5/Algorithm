#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int cal_size(int N, int M, vector<vector<int>>& arr) {
    int max_side = min(N, M);

    for (int i = max_side; i >= 1; i--) {
        for (int j = 0; j <= N - i; j++) {
            for (int k = 0; k <= M - i; k++) {
                if (arr[j][k] == arr[j + i - 1][k] && arr[j][k] == arr[j][k + i - 1] && arr[j][k] == arr[j + i - 1][k + i - 1]) {
                    return i * i;
                }
            }
        }
    }
    return 1;
}


int main() {
    int N, M;
    cin >> N >> M;

    vector<vector<int>> arr(N, vector<int>(M));

    for (int i = 0; i < N; i++) {
        string numbers;
        cin >> numbers;
        for (int j = 0; j < M; j++) {
          
            arr[i][j] = numbers[j] - '0';
        }
    }

    cout << cal_size(N, M, arr);

    return 0;
}