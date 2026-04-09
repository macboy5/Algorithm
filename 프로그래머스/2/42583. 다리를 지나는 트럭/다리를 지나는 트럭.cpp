#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int sum = 0;
    int idx = 0;
    
    queue<int> bridge;
    queue<int> done;
    for(int i=0; i<bridge_length; i++){
        bridge.push(0);
    }
    
    while(!bridge.empty() ){
        answer++;

        
        int front = bridge.front();
        if(front != 0) {
            sum -= front;
            done.push(front);
        }
        if(done.size() == truck_weights.size()) break;
        bridge.pop();
        
        sum += truck_weights[idx];
        if(sum > weight){
            sum -= truck_weights[idx];
            bridge.push(0);          
        }
        else{
            bridge.push(truck_weights[idx++]);
        }
        
        
    }
    
    
    return answer;
}