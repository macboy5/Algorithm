#include <iostream>

using namespace std;

int number[10][7] = {1,1,0,1,1,1,1,
                     0,1,0,0,1,0,0,
                     1,1,1,0,0,1,1,
                     1,1,1,0,1,1,0,
                     0,1,1,1,1,0,0,
                     1,0,1,1,1,1,0,
                     1,0,1,1,1,1,1,
                     1,1,0,0,1,0,0,
                     1,1,1,1,1,1,1,
                     1,1,1,1,1,1,0};

int N, K , P , X;

int main(){

    cin >> N >> K >> P >> X;

    // 1~N층까지 있고 K 자리수. X를 최대 P번 반전 가능할 때, 반전시킬 수 있는 경우의 수 계산.

    int total = 0;

    for(int i=1; i<= N; i++){
        int cnt = 0;
        int from = X, to = i;

        for(int j=1; j<=K; j++){

            for(int r=0; r<7; r++){
                if(number[from%10][r] != number[to%10][r]) cnt++;
            }

            from /= 10;
            to /= 10;

        }

        if(cnt <= P && cnt >=1) total++;

    }

    cout << total;


    return 0;

}