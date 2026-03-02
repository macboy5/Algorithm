#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int sum = 0;
    int num = 0;
    
    while(1){

        sum += num;
        num++;    
        
        if( (n-sum) <=0) break;
        
        if((n-sum)%num == 0) answer++;
        

        
    }
    
    
    return answer;
}