#include <string>
#include <vector>

using namespace std;
vector<vector<int>> answer;

void hanoi(int n, int from, int to, int tmp){
    if(n==1){
        
        answer.push_back({from,to});
        return;
    }
    else{
        hanoi(n-1, from, tmp, to);
        answer.push_back({from, to});
        hanoi(n-1, tmp, to, from);
        
    }
    
}

vector<vector<int>> solution(int n) {

    hanoi(n, 1, 3, 2);
        
    
    return answer;
}