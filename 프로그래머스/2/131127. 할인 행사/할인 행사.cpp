#include <string>
#include <vector>
#include <map>

using namespace std;

bool solve(map<string, int> m, vector<string> &discount, int start, int length){
    
    for(int i=start; i<start+length; i++){
        if(m.find(discount[i]) != m.end()){
            m[discount[i]]--;
        }
    }
    
    for(auto const& [key,val] : m){
        if(val > 0) return false;
    }
    
    
    return true;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    int product_num = want.size();
    int discount_days = discount.size();
    int days = discount_days;
    int length = 0;
    for(int i=0; i<product_num; i++){
        length += number[i];
    }
    days -= length;
    
    map<string, int> m;
    for(int i=0; i<product_num; i++){
        m[want[i]] = number[i];
    }
    
    for(int i=0; i<=days; i++){
        if(solve(m, discount, i, length )) answer++;
    }
    
    
    return answer;
}