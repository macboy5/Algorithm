#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> isVisited;

void bfs(int start, int n, vector<vector<int>> &computers){
        isVisited[start] = 1;
        
        for(int i=0; i<n; i++){
            if(computers[start][i] && !isVisited[i]){ 
                isVisited[i] = 1;
                bfs(i, n, computers);
            
                                                    }
        }
    
}


int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    isVisited.assign(n,0);
        
    for(int i=0; i<n; i++){
        if(!isVisited[i]){
            bfs(i, n, computers);
            answer++;
        }
        else continue;
    }
    
    return answer;
}