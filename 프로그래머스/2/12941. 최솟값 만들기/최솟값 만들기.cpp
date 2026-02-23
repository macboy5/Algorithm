#include <iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool compare(int a, int b){
    return a> b ? true : false;
}

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), compare);
    
    int length = A.size();
    
    for(int i=0; i<length; i++){
        answer += (A[i]*B[i]);
    }

    return answer;
}