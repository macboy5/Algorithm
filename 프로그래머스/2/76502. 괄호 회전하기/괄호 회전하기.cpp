#include <string>
#include <vector>
#include <stack>

using namespace std;

bool solve(string s, int idx){
    
    int length = s.size();
    vector<bool> checked(length, false);
    
    stack<char> tmp;
    for(int i = idx; i<length; i++){
        if( !tmp.empty()){
            if(tmp.top() == '{' && s[i] == '}'){
                tmp.pop();   
            }
            else if(tmp.top() == '(' && s[i] == ')'){
                tmp.pop();
            }
            else if(tmp.top() == '[' && s[i] == ']'){
                tmp.pop();
            }
            else{
                tmp.push(s[i]);
            }
        }
        else{
            tmp.push(s[i]);
        }

    }
    for(int i=0; i<idx; i++){
       if( !tmp.empty()){
            if(tmp.top() == '{' && s[i] == '}'){
                tmp.pop();   
            }
            else if(tmp.top() == '(' && s[i] == ')'){
                tmp.pop();
            }
            else if(tmp.top() == '[' && s[i] == ']'){
                tmp.pop();
            }
            else{
                tmp.push(s[i]);
            }
        }
        else{
            tmp.push(s[i]);
        }
    }
    
    if( tmp.empty()) return true;
    else return false;
}

int solution(string s) {
    int answer = 0;
    
    int circular_cnt = s.size();
    
    for(int i=0; i<circular_cnt; i++){
        if(solve(s, i) ) answer++;
    }
    
    
    return answer;
}