#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> time;
    
    for(int i=0; i<progresses.size(); i++){
        int day = 1;
        while(1){
            if(progresses[i] + speeds[i] * day >= 100) break;
            else day++;
        }
        time.push_back(day);
    }

    
    int std = time.front();
    int cnt = 0;
    for(int i=0; i<time.size(); i++){
        
        if(std >= time[i]){
            cnt++;
        }
        else{
            answer.push_back(cnt);
            std = time[i];
            cnt = 1;            
        }
        
        if(i == time.size()-1){
            answer.push_back(cnt);
        }
        
    }
    
    
    return answer;
}