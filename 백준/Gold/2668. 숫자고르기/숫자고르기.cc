#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int arr[101];
int visited[101];

vector<int> V;

void DFS(int start, int curr){

    if(visited[curr]){
        if(start == curr) V.push_back(start);

        return;

    }

    visited[curr] = 1;
    DFS(start, arr[curr]);

}

int main(){

    int N;
    cin >> N;


    for(int i=1; i<=N; i++){
        cin >> arr[i];
    }


    for(int i=1; i<=N; i++){

        memset(visited, 0, sizeof(visited));

        DFS(i, i);

    }

    cout << V.size() << "\n";
    sort(V.begin(), V.end());
    for(auto i : V){
        cout << i<< "\n";
    }

    return 0;

}