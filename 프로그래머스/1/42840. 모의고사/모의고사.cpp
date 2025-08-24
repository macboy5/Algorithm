#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int first[5] = {1, 2, 3, 4, 5};
    int second[8] = {2, 1, 2, 3, 2, 4, 2, 5};
    int third[10] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int cnt1=0, cnt2=0, cnt3=0;
    
    for(int i=0; i<answers.size(); i++){
        
        if(answers[i] == first[i%5]) cnt1++;
        if(answers[i] == second[i%8]) cnt2++;
        if(answers[i] == third[i%10]) cnt3++;
               
    }

    vector<pair<int,int>> tmp;
    tmp.push_back({cnt1, 1});
    tmp.push_back({cnt2, 2});
    tmp.push_back({cnt3, 3});
    
    sort(tmp.begin(), tmp.end());
    
    if(tmp[2].first == tmp[1].first){
        if(tmp[2].first == tmp[0].first){
            answer.push_back(1);
            answer.push_back(2);
            answer.push_back(3);
        }
        else{
            if(tmp[2].second < tmp[1].second){
                answer.push_back(tmp[2].second);
                answer.push_back(tmp[1].second);
            }
            else{
                answer.push_back(tmp[1].second);
                answer.push_back(tmp[2].second);
            }
        }
        
    }
    else{
        answer.push_back(tmp[2].second);
    }
    
    
    return answer;
}