#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(int a, int b){
    string sa = to_string(a);
    string sb = to_string(b);
    return sa + sb > sb + sa;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), comp);
    
    if(numbers[0] == 0) return "0";
    
    for(int num : numbers){
        answer += to_string(num);
    }
    

    
    return answer;
}