#include <string>
#include <vector>
#include <algorithm>


using namespace std;


int solution(string name) {
    int answer = 0;
    int length = name.size();
    int min_move = length - 1;
    
    for(int i=0; i<length ; i++){

        answer += min(name[i] - 'A', 'Z'- name[i]+1);
        
        int next = i+1;
        while(next< length && name[next]== 'A') next++;
        
       min_move = min({ min_move, i * 2 + length - next, (length - next) * 2 + i });

        
    }
    
  answer += min_move;
    
    
    
    
    
    return answer;
}