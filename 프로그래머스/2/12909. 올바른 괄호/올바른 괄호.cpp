#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
    stack <char> stack;
    
    for(int i=0; i<s.length(); i++){
        
        
        if(s[i] == '('){
            stack.push('(');
        }
        else if(s[i] == ')'){
            if(stack.empty() or stack.top() == ')'){
                stack.push(')');
            }
            else if(stack.top() == '('){
                stack.pop();
            }
        }
        
    }   
    

    return stack.empty();
}