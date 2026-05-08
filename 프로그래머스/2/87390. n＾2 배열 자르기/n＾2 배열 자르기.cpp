#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    
    long long curr = left;
    
    // 1234 2234 3334 4444    
    
    while(curr <= right){
        
        long long row = curr / n;
        long long col = curr % n;
        
        int value;
        
        if(col <= row){
            value = row + 1;
        }
        else value = col + 1;
        
        answer.push_back(value);
        curr++;
    }
    
    return answer;
}