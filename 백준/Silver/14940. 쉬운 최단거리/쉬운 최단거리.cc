#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

// 상하좌우 이동 벡터
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

void solve() {
    int N, M;
    // N: 세로 (행), M: 가로 (열)
    if (!(cin >> N >> M)) return;

    vector<vector<int>> map_data(N, vector<int>(M));
    vector<vector<int>> distance(N, vector<int>(M, -1)); // 거리 배열: 도달 불가능은 -1로 초기화

    queue<pair<int, int>> q;
    int start_r = -1, start_c = -1;

    // 1. 지도 입력 및 초기화
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> map_data[i][j];

            if (map_data[i][j] == 2) {
                // 목표 지점(2) 찾기
                start_r = i;
                start_c = j;
            } else if (map_data[i][j] == 0) {
                // 갈 수 없는 땅(0)은 출력 요구사항에 따라 0으로 초기 설정
                distance[i][j] = 0;
            }
        }
    }

    // 2. BFS 시작점 설정 및 큐에 삽입
    if (start_r != -1) {
        distance[start_r][start_c] = 0;
        q.push({start_r, start_c});
    }

    // 3. BFS 실행
    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        int current_dist = distance[r][c];

        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; ++i) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 1. 경계 체크
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            // 2. 도달 가능한 땅이면서 아직 방문하지 않은 경우 (distance == -1)
            //    * map_data[nr][nc] == 0인 경우 distance는 이미 0으로 설정되어 있어 패스됨
            if (map_data[nr][nc] != 0 && distance[nr][nc] == -1) {
                
                distance[nr][nc] = current_dist + 1;
                q.push({nr, nc});
            }
        }
    }

    // 4. 결과 출력
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cout << distance[i][j] << (j == M - 1 ? "" : " ");
        }
        cout << "\n";
    }
}

int main() {
    // 입출력 최적화
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solve();

    return 0;
}