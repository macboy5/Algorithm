#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), -1);
    stack<int> s;

    
    for(int i=numbers.size()-1; i>=0; i--){
        

        int cur = numbers[i];
        
        while( !s.empty() && s.top() <= cur ){
            s.pop();
        }
        
        if( !s.empty()){
            answer[i] = s.top();
        }
        
        s.push(cur);
        
        
        
    }
    
    
    
    return answer;
}