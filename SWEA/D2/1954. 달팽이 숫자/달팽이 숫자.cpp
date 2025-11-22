#include<iostream>
#include<vector>
#include<cmath>
#include<cstring> // memset 사용을 위해 (필요에 따라)

using namespace std;

// 방향 벡터: 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위 (시계 방향)
int dr[] = {0, 1, 0, -1}; // 행 변화 (Direction Row)
int dc[] = {1, 0, -1, 0}; // 열 변화 (Direction Column)

void solve(int N){
    // N x N 크기의 달팽이 배열 생성 및 0으로 초기화
    vector<vector<int>> snail(N, vector<int>(N, 0));

    int r = 0; // 현재 행
    int c = 0; // 현재 열
    int dir = 0; // 현재 방향 (0: 오른쪽)
    int num = 1; // 채울 숫자 (1부터 시작)
    int max_num = N * N;

    while(num <= max_num){
        // 1. 현재 위치에 숫자 기록
        snail[r][c] = num;

        // 2. 다음 칸 위치 계산
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        // 3. 다음 칸이 유효한지 확인 (경계 체크 또는 이미 채워졌는지 체크)
        if (nr < 0 || nr >= N || nc < 0 || nc >= N || snail[nr][nc] != 0) {
            
            // 3-1. 방향 전환 (시계 방향 90도)
            dir = (dir + 1) % 4;

            // 3-2. 새 방향으로 현재 위치 갱신 (방향 전환 후 한 칸 이동)
            r = r + dr[dir];
            c = c + dc[dir];

        } else {
            // 4. 다음 칸으로 이동
            r = nr;
            c = nc;
        }

        num++;
    }

    // 정답 출력
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            // 각 숫자 출력 후 공백 추가
            cout << snail[i][j] << " ";
        }
        cout << "\n";
    }

}

int main(int argc, char** argv)
{
    // 입출력 최적화
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin>>T;
    
    for(int test_case = 1; test_case <= T; ++test_case)
    {
        int N;
        cin >> N;

        cout<< "#" << test_case << "\n";
        solve(N);
    }
    return 0;
}