#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

int dateToDays(string date){
    int y = stoi(date.substr(0,4));
    int m = stoi(date.substr(5,2));
    int d = stoi(date.substr(8,2));
    
    return (y*12*28) + (m*28) + d;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    
    int todayDays = dateToDays(today);
    map<char, int> termMap;    

    for(string term : terms){
        stringstream ss(term);
        char type;
        int month;
        ss >> type >> month;
        
        termMap[type] = month*28;
    }
    
    for(int i=0 ; i<privacies.size(); i++){
        
        string dateStr = privacies[i].substr(0,10);
        char type = privacies[i].back();
        
        int days = dateToDays(dateStr);
        int expireDays = days + termMap[type];
        
        if(todayDays >= expireDays){
            answer.push_back(i+1);
        }
        
    }
    
    return answer;
}