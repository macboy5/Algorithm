#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


void solve(){
    int N;
    cin >> N;
    vector<int> budget(N);


    for(int i=0; i<N; i++){
        cin>> budget[i];
    }

    sort(budget.begin(), budget.end());

    int min = budget[0];
    int max = budget[N-1];

    int total;
    cin >> total;

    int cur;

    for(int i=1; i<=max; i++){
        cur = i;
        int sum = 0;

        for(int j=0; j<N; j++){
            if(budget[j] >= cur) sum+= cur;
            else{
                sum+=budget[j];
            }
        }

        if(total >= sum){
            continue;
        }
        else{
            cur--;
            break;
        }
    }



    cout << cur;

}

int main(){

    solve();

    return 0;
}