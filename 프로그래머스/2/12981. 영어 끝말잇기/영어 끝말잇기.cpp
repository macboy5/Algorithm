#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <math.h>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    int cnt = 0;
    
    unordered_map<string, int> um;
    char past = '0';
    bool flag = false;
    
    for(int i=0; i<words.size(); i++){
        cnt++;
        
        if(past != words[i][0] && i>=1){ 
            flag = true;
            break;

        }
        else{
            int length = words[i].size();
            past = words[i][length-1];
        }
        
        if(um.find(words[i]) != um.end())
        {   
            flag = true;
            break;
        }   
        else{
            um.insert({words[i], 1});
        }
    }
    
    
    if(!flag){
        answer.push_back(0);    
        answer.push_back(0);        
    }
    else{
        int tmp, b;
        if(cnt%n == 0){
            tmp = n;
            b = cnt/n;
        } 
        else{ 
            tmp = cnt%n;
            b = cnt/n + 1;
        }
        answer.push_back(tmp);
        
        answer.push_back(b);
    }

    return answer;
}