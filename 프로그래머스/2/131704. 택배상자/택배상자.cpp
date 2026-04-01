#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    
    stack<int> tmp;
    
    for(int i=1; i<=order.size(); i++){
        tmp.push(i);
        while( !tmp.empty() && order[answer] == tmp.top()){
            tmp.pop();
            answer++;
        }
    } 
    
    
    return answer;
}