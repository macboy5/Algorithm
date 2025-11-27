#include <iostream>
#include <algorithm>


using namespace std;


#define ASIZE 200001
#define VSIZE 100001

int A[ASIZE];
int visitCnt[VSIZE];

int main(){
    int N, K;
    cin >> N >> K;

    for(int i=1; i<=N; i++){
        cin>> A[i];
    }


    int len = 0, left = 1, right = 1;

    while(left<=right && right <= N){
        if(visitCnt[A[right]] < K){
            visitCnt[A[right++]]++;
            len = max(len, right-left);
        }
        else if(visitCnt[A[right]] == K){
            visitCnt[A[left++]]--;
        }
    }

    cout << len;


    return 0;

}