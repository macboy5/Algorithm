#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> int_num;
    string tmp = "";

    for(int i = 0; i < s.size(); i++) {
        if(s[i] == ' ') {
            if(!tmp.empty()) { // 공백이 연속될 경우를 대비
                int_num.push_back(stoi(tmp));
                tmp = "";
            }
        } else {
            tmp += s[i];
        }
    }
 
    if(!tmp.empty()) {
        int_num.push_back(stoi(tmp));
    }


    sort(int_num.begin(), int_num.end());


    int minVal = int_num.front();
    int maxVal = int_num.back();

    answer = to_string(minVal) + " " + to_string(maxVal);

    return answer;
}