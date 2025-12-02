#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
#define INF 987654321;

int map[125][125];
int sum[125][125];

int N;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

// [0][0] 에서 [N-1][N-1]까지 가는 최소 비용
void func(){

    priority_queue<pair<int, pair<int, int>>> pq;
    pq.push({-1*map[0][0], {0,0}});
    sum[0][0] = map[0][0];

    while( !pq.empty() ){
        int cost = -1*pq.top().first;
        int y = pq.top().second.first;
        int x = pq.top().second.second;

        pq.pop();

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int ncost = cost + map[ny][nx];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(ncost >= sum[ny][nx]) continue;

            sum[ny][nx] = ncost;
            pq.push({-1*ncost, {ny,nx}});
        }


    }



}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);


    int test_case = 1;

    while( 1 ) {
        cin >> N;

        if( N == 0) break;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cin >> map[i][j];
                sum[i][j]  = INF;
            }
        }

        cout << "Problem " << test_case <<": ";
        func();

        cout << sum[N-1][N-1] <<"\n";
        test_case++;


    }

    return 0;

}