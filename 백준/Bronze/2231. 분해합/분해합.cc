#include <iostream>
using namespace std;

int main(){

    int N;
    cin >> N;

    // N을 만드는 가장 작은 생성자를 구한다.
    // 생성자가 없으면 0을 출력한다.


    for(int i=1; i<=N; i++){
        int tmp = i;
        int sum = tmp;

        while(tmp>0){
            sum += tmp % 10;
            tmp /= 10;
        }

        if(sum == N) {
            cout << i;
            return 0;
        }

    }

    cout << 0;

    return 0;
}