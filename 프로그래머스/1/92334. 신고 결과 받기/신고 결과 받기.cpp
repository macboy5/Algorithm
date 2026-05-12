#include <string>
#include <vector>
#include <set>
#include <map>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    
    map<string, set<string>> reported_by;
    map<string, int> id_idx;
    for(int i=0; i<id_list.size(); i++){
        id_idx[id_list[i]] = i;
    }
    
    
    for(string s : report){
        string user, target;
        stringstream ss(s);
        ss >> user >> target;
        
        reported_by[target].insert(user); 
    }
        
    for(auto [target, users] : reported_by){
        if(users.size() >= k){
            for(string user : users){
                answer[id_idx[user]]++;
            }
        }
    }
    
    return answer;
}