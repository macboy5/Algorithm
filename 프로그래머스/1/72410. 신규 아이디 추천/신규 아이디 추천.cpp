#include <string>
#include <vector>
#include <stack>

using namespace std;

string solution(string new_id) {
    string answer = "";
    
    string tmp = "";
    //1단계
    for(char c : new_id){
        if(c>= 'A' && c<='Z'){
            tmp += (c + 32);
        }
        else tmp += c;
    }
    new_id = tmp;
    tmp = "";
    
    //2단계
    for(char c : new_id){
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || 
           c == '-' || c == '_' || c == '.') {
            tmp += c;
        }
    }
    new_id = tmp;
    tmp = "";
    
    //3단계
    for(char c : new_id) {
        if(c == '.') {
            if(tmp.empty() || tmp.back() != '.') {
                tmp += c;
            }
        } else {
            tmp += c;
        }
    }
    new_id = tmp;
    tmp = "";
    //4단계
    if(!new_id.empty() && new_id.front() == '.') new_id.erase(0, 1);
    if(!new_id.empty() && new_id.back() == '.') new_id.pop_back();
    
    //5단계
    if(new_id.empty()) new_id = "a";
    
    //6단계
    if(new_id.size()>=16){
        new_id = new_id.substr(0, 15);
        if(new_id.back() == '.') new_id.pop_back();
    }
    
    //7단계
    if(new_id.size()<=2){
        char c = new_id[new_id.size()-1];
        
        while(new_id.size() <3){
            new_id += c;
        }
    }
    answer = new_id;
    
    return answer;
}