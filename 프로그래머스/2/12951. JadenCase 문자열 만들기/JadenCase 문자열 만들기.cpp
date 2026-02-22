#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    bool isFirst = true; 

    for (int i = 0; i < s.size(); i++) {
        if (s[i] == ' ') {
            isFirst = true;
        } 
        else if (isFirst) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                s[i] -= 32; 
            }
            isFirst = false; 
        } 
        else {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                s[i] += 32;
            }
        }
    }

    return s;
}