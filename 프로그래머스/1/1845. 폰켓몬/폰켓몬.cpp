#include <vector>
#include <set>
using namespace std;

int solution(vector<int> nums){
    int answer = 0;
    
    int total = nums.size();
    
    set<int> h;
    
    for(int i=0; i<total; i++){
         h.insert(nums[i]);
    }
    
    if(h.size() > total/2) answer = total/2;
    else answer = h.size();
    
    return answer;
}