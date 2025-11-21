#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;

int N, M;
int arr[1001][1001];
int visited[1001][1001];

int dy[4] = {0,0,1,-1};
int dx[4] = {1,-1,0,0};

void dfs(int y, int x){
    visited[y][x] = 1;
    
    for(int i=0; i<4; i++){
        int ny = y+dy[i];
        int nx = x+dx[i];
        
        if(nx<0 || nx >=N || ny<0 || ny>= M) continue;
        
        if(visited[ny][nx] == 0 && arr[ny][nx] == 0) dfs(ny,nx);
        
    }
}

int main() {
    ios_base::sync_with_stdio(false);

    cin >> M >> N;
    for(int i=0; i<M; i++){
        for(int j=0; j<N; j++){
            char c; cin >> c;
            arr[i][j] = c-'0';
        }
    }

    for(int j=0; j<N; j++){
        dfs(0, j);
    }

    bool cango = false;
    for(int j=0; j<N; j++){
        if(visited[M-1][j] == 1){
            cout << "YES\n";
            return 0;
        }
    }

    cout << "NO\n";

    return 0;
}


