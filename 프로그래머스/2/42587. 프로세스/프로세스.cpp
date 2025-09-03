#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    queue<pair<int,int>> q;
    priority_queue<int> pq;
    
    for(int i=0; i<priorities.size(); i++){
        q.push({i, priorities[i]});
        pq.push(priorities[i]);
    }
    
    
    while(1){
        
        pair<int,int> temp = q.front();
        q.pop();
        
        if(temp.second != pq.top()){
            q.push(temp);
        }
        else{
            if(temp.first == location){
                return ++answer;
            }
            else{
                answer++;
                pq.pop();
            }
        }
        
    }
    
    
    
    
    return answer;
}