#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int gcd(int a, int b){
    int big = max(a,b);
    int small = min(a,b);
    
    if(small == 0) return big;
    else{
        return gcd(small, big%small);
    }
}


int solution(vector<int> arr) {
    int answer = 0;
    
    int a = arr[0], b;
    int tmp;
    
    for(int i=1; i<arr.size(); i++){
        b = arr[i];
        tmp = gcd(a, b);
        a = (a*b)/tmp;
    }
     
    answer = a;
    
    return answer;
}