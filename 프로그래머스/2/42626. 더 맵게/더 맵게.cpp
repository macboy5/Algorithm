#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<int> > pq;
    
    for(int i=0; i<scoville.size(); i++){
        pq.push(scoville[i]);
    }
    
    int first = pq.top();

    int second;
    
    while(first < K){
        pq.pop();
        if(pq.empty()) return -1;
        second = pq.top();
        pq.pop();
        int tmp = first+second*2;
        pq.push(tmp);
        first = pq.top();  
        answer++;
    }
    
    
    return answer;
}