#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(char c : myString){
        if(c >= 'a' && c <= 'z'){
            answer += (c-32);
        }
        else answer += c;
    }
    return answer;
}