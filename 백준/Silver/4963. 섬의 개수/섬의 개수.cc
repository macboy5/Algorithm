#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;
int w, h , cnt=0;
int map[50][50];
int visited[50][50];

int dy[8] = {1, -1, 0, 0,  1,  1, -1, -1}; // 상하좌우 및 대각선
int dx[8] = {0, 0, 1, -1,  1, -1,  1, -1};

void dfs(int y, int x) {
    visited[y][x] = 1;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
            if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                dfs(ny, nx);
            }

    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    while(1){

        cin >> w >> h;
        if(w == 0 && h == 0) break;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                cin >> map[i][j];
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        cout << cnt <<"\n";

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                map[i][j] = 0;
                visited[i][j] = 0;
            }
        }
        cnt = 0;

    }

    return 0;
}


