#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer={0,0};
    
    int left=0, right=0;
    int sum=sequence[0];
    int length = 1000001;
    
    while(left<= right && right < sequence.size()){
        if(sum > k){
            sum -= sequence[left++];
        }
        else if(sum == k){
            int tmp = right - left + 1;
            if(tmp < length) {
                length = tmp;
                answer = {left, right};
            }
            sum -= sequence[left++];
        }
        else if (sum < k){
            right++;
            if(right < sequence.size()) sum += sequence[right];
        }
    }
        
    return answer;
}