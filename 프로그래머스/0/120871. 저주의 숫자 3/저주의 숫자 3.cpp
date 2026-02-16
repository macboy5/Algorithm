#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;

    // 1 2 (3) 4 5 (6) 7 8 (9) 10 11 (12) (13) 14
    
    // 3 6 9 포함 x
    // 3의 배수 포함 x
    
    int cnt = 0;
    int number = 1;
    while(1){
        
        if(number % 3 == 0) number++;
        else if(number % 10 == 3) number++;
        else if(number /10 == 3) number++;
        else if((number/10)%10 == 3) number++;
        else{
        cnt++;
                    
        if(cnt == n) break;
        
        number++;
        }

    }
    
    answer = number;
    
    return answer;
}