#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>


using namespace std;

int N;
string input[101];
char color[101][101];
bool isVisited[101][101];

int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};

void func(){

    queue< pair<char, pair<int,int> >> Q;

    int cnt = 0;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){

            if(isVisited[i][j]) continue;

            Q.push({color[i][j], {i,j}});

            isVisited[i][j] = true;
            cnt++;

            while(!Q.empty()){
                int y = Q.front().second.first;
                int x = Q.front().second.second;
                int c = Q.front().first;
                Q.pop();
//                isVisited[y][x] = true;

                for(int i=0; i<4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (isVisited[ny][nx]) continue;

                    if (c == color[ny][nx]) {
                        Q.push({c, {ny, nx}});
                        isVisited[ny][nx] = true;
                    }
                }

            }
        }
    }

    cout << cnt <<"\n";

}

void blind(){

}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    cin >> N;

    for(int i=0; i<N; i++){
        cin >> input[i];
        for(int j=0; j<N; j++){
            color[i][j] = input[i][j];
        }
    }


    func();
    memset(isVisited, 0 , sizeof(isVisited));
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(color[i][j] == 'R') color[i][j] = 'G';
        }
    }
    func();

    return 0;

}