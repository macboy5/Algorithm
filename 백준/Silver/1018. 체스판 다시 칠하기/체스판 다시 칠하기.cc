#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

char white_arr[8][8] = {
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W'
};

char black_arr[8][8] = {
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B',
        'B','W','B','W','B','W','B','W',
        'W','B','W','B','W','B','W','B'
};


int comp(const vector<vector<char>>& arr, int a, int b) {
    int cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (arr[i + a][j + b] != white_arr[i][j]) cnt1++;
            if (arr[i + a][j + b] != black_arr[i][j]) cnt2++;
        }
    }
    return min(cnt1, cnt2);
}

int main() {
    int N, M;
    cin >> N >> M;


    vector<vector<char>> arr(N, vector<char>(M));
    string line;
    for (int i = 0; i < N; i++) {
        cin >> line;
        for (int j = 0; j < M; j++) {
            arr[i][j] = line[j];
        }
    }

    int min_changes = 65; // Max possible changes is 64 + 1

    for (int i = 0; i <= N - 8; i++) {
        for (int j = 0; j <= M - 8; j++) {
            min_changes = min(min_changes, comp(arr, i, j));
        }
    }

    cout << min_changes;

    return 0;
}