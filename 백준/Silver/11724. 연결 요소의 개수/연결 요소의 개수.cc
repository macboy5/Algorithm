#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <queue>

using namespace std;

vector<int> graph[1001];
bool visit[1001];

void BFS(int index){

    queue<int> q;
    q.push(index);
    visit[index] = true;

    while(!q.empty()){
        int index = q.front();
        q.pop();

        for(int i=0; i<graph[index].size(); i++){
            if(visit[graph[index][i]]) continue;
            visit[graph[index][i]] = true;
            q.push(graph[index][i]);
        }

    }

}

int main() {

    int N, M, u, v;
    cin >> N >> M;

    int answer = 0;
    // 그래프 초기화
    for(int i=1; i<= M; i++){
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    // bfs 돌면서 연결 요소 개수 검사.
    for(int i=1; i<=N; i++){
        if(visit[i]) continue;
        else{
            BFS(i);
            answer++;
        }
    }

    cout << answer ;


    return 0;
}