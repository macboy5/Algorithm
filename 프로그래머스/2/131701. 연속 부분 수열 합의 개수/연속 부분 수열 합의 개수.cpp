#include <string>
#include <vector>
#include <set>

using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    
    int length = elements.size();
    
    set<int> s;
    
    for(int i=1; i<=length; i++){
        
        // 시작 지점
        for(int j=0; j<length; j++){
            int cnt = 0;
            int sum = 0;
            while(cnt < i){
                if(j+cnt < length){
                    sum += elements[j+cnt++];
                }
                else{
                    sum += elements[j+cnt++-length];
                }
            }
            s.insert(sum);
        }
    }
    
        answer = s.size();
        
    return answer;
}