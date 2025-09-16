#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    //내림차순 정렬
    sort(citations.begin(), citations.end(), greater<>());
    
    int h = 0;
    
    while(1){
        
        int cnt = 0;
        
        for(int j=0; j<citations.size(); j++){
            if(citations[j] >= h) cnt++;
            if(citations[j] < h) break;
        }
        
        if(cnt >= h && h >= citations.size()-cnt ){ 
            answer = h;
            h++;
        }
        else return answer;
    }
    
    return answer;
}