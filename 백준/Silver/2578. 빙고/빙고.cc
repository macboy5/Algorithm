#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

// 모든 가로 라인의 빙고 수를 세는 함수
int check_all_garo(const vector<vector<int>> &bingo) {
    int count = 0;
    for (int i = 0; i < 5; ++i) {
        bool is_bingo = true;
        for (int j = 0; j < 5; ++j) {
            if (bingo[i][j] != 0) {
                is_bingo = false;
                break;
            }
        }
        if (is_bingo) count++;
    }
    return count;
}

// 모든 세로 라인의 빙고 수를 세는 함수
int check_all_sero(const vector<vector<int>> &bingo) {
    int count = 0;
    for (int j = 0; j < 5; ++j) {
        bool is_bingo = true;
        for (int i = 0; i < 5; ++i) {
            if (bingo[i][j] != 0) {
                is_bingo = false;
                break;
            }
        }
        if (is_bingo) count++;
    }
    return count;
}

// 모든 대각선 라인의 빙고 수를 세는 함수
int check_all_daegak(const vector<vector<int>> &bingo) {
    int count = 0;
    // 주 대각선 검사
    bool main_diag_bingo = true;
    for (int i = 0; i < 5; ++i) {
        if (bingo[i][i] != 0) {
            main_diag_bingo = false;
            break;
        }
    }
    if (main_diag_bingo) count++;

    // 역 대각선 검사
    bool anti_diag_bingo = true;
    for (int i = 0; i < 5; ++i) {
        if (bingo[i][4 - i] != 0) {
            anti_diag_bingo = false;
            break;
        }
    }
    if (anti_diag_bingo) count++;

    return count;
}


int times(vector<vector<int>> &bingo, vector<vector<int>> &speak) {
    int cnt = 0;

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            int tmp = speak[i][j];

            for (int k = 0; k < 5; k++) {
                for (int l = 0; l < 5; l++) {
                    if (bingo[k][l] == tmp) {
                        bingo[k][l] = 0;
                        cnt++;

                        int bingo_lines = check_all_garo(bingo) + check_all_sero(bingo) + check_all_daegak(bingo);
                        if (bingo_lines >= 3) {
                            return cnt;
                        }
                    }
                }
            }
        }
    }
    return cnt;
}


int main() {
    vector<vector<int>> bingo(5, vector<int>(5));
    vector<vector<int>> speak(5, vector<int>(5));

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> bingo[i][j];
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> speak[i][j];
        }
    }

    cout << times(bingo, speak);

    return 0;
}