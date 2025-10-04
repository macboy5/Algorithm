#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// 최대 위치 100000 + 1 (배열 크기 100001)
const int MAX = 100001; 

void bfs(int N, int K) {
    if (N == K) {
        cout << 0 << '\n' << 1 << endl; // 시작점과 도착점이 같으면 시간 0, 방법 1
        return;
    }

    queue<int> q;
    vector<int> dist(MAX, 0); // 각 지점까지의 최소 시간 (0으로 초기화)
    vector<int> count(MAX, 0); // 각 지점까지 최소 시간으로 도달하는 경로의 개수

    q.push(N);
    dist[N] = 0;
    count[N] = 1; // 시작 지점은 경로의 개수 1

    while (!q.empty()) {
        int pos = q.front();
        q.pop();

        // 3가지 이동 방법 (X-1, X+1, 2*X)
        for (int next : {pos - 1, pos + 1, pos * 2}) {
            
            // 1. 유효한 범위 체크
            if (next >= 0 && next < MAX) {
                
                // 2. 해당 지점을 처음 방문하는 경우 (최단 경로 발견)
                if (dist[next] == 0) {
                    dist[next] = dist[pos] + 1;
                    count[next] = count[pos];
                    q.push(next);
                }
                // 3. 해당 지점에 최소 시간으로 재방문하는 경우 (또 다른 최단 경로 발견)
                else if (dist[next] == dist[pos] + 1) {
                    count[next] += count[pos];
                }
            }
        }
    }

    // 최종 결과 출력
    cout << dist[K] << '\n' << count[K] << endl;
}

int main() {
    // 입력을 빠르게 하기 위해 sync_with_stdio(false) 사용
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    if (!(cin >> N >> K)) return 0;

    bfs(N, K);

    return 0;
}