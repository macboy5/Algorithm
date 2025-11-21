#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;

int map[500][500];
int visited[500][500];
int n,m, cnt = 0, sum = 0, ma = 0;

int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};

void dfs(int y, int x){
    visited[y][x] = 1;
    sum++;

    for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny<0 || nx < 0 || ny >= n || nx >= m) continue;
        if(!visited[ny][nx] && map[ny][nx]){
            dfs(ny,nx);
        }
    }

    if(ma < sum) {
        ma = sum;

    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    cin >> n >> m;

    for(int i=0; i<n; i++){
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
            visited[i][j] = 0;
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(map[i][j] && !visited[i][j]) {
                cnt++;
                sum = 0;
                dfs(i, j);
            }
        }
    }

    cout << cnt << "\n" << ma;


    return 0;
}


