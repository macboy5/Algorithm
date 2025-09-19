#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <climits> // LLONG_MAX, LLONG_MIN 사용을 위해 포함

using namespace std;

// N개의 수와 N-1개의 연산자
void value(int N, vector<int> &A, vector<char> &op){
    // long long의 최댓값과 최솟값으로 초기화
    long long min_val = LLONG_MAX;
    long long max_val = LLONG_MIN;

    // next_permutation은 정렬된 순서부터 시작해야 모든 순열을 탐색
    sort(op.begin(), op.end());

    do{
        long long result = A[0];

        for(int i=0; i<N-1; i++){
            if(op[i] == '+') result += A[i+1];
            else if(op[i] == '-') result -= A[i+1];
            else if(op[i] == 'x') result *= A[i+1];
            else if(op[i] == '/') result /= A[i+1];
        }

        if(min_val > result) min_val = result;
        if(result > max_val) max_val = result;

    }while(next_permutation(op.begin(), op.end()));


    cout << max_val << '\n' << min_val;

}

int main() {
    int N;
    cin >> N;

    vector<int> A(N);
    for(int i=0; i<N; i++){
        cin >> A[i];
    }

    vector<int> operator_cnt(4);
    for(int i=0; i<4; i++){
        cin >> operator_cnt[i];
    }

    vector<char> op;
    for(int i=0; i<4; i++){
        for(int j=0; j<operator_cnt[i]; j++){
            if(i==0) op.push_back('+');
            else if(i==1) op.push_back('-');
            else if(i==2) op.push_back('x');
            else if(i==3) op.push_back('/');
        }
    }

    value(N, A, op);

    return 0;
}