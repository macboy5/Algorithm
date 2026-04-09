#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int answer = 50;
vector<int> isVisited;

bool wordDiff(string a, string b){
    int diffCnt = 0;
    
    for(int i=0; i<a.size(); i++){
        if(a[i] != b[i]) diffCnt++;
        
        if(diffCnt >1) return false;
    }
    
    if(diffCnt==1) return true;
        
    return false;    
}

void dfs(string current, string target, vector<string> words, int step){
    
    if(answer<step) return;
    
    if(current == target){
        answer = min(answer, step);
        return;
    }
    
    for(int i=0; i<words.size(); i++){
        if(wordDiff(current, words[i]) && !isVisited[i]){
            dfs( words[i], target, words, step+1);
            
            isVisited[i] =0;
        }
    }
    
    
}

int solution(string begin, string target, vector<string> words) {

    isVisited.assign(words.size(),0);
    
    int flag=0;
    for(int i=0; i<words.size(); i++){
        if(target == words[i]) {flag=1;
        break;
                               }
    }
    if(flag ==0) return 0;
    
    dfs(begin,target, words, 0);
      


    
    return answer;
}