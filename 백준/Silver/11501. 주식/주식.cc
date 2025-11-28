#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void solve(vector<int> &price, int N){

    // 1. 1주 매수 2.원하는 만큼 매도 3. 관망
    long long maxProfit = 0;

    vector<int> sellPrice(N+1, 0);
    
    int maxPrice = price[N];
    for(int i=N; i>=1; i--){
          if(maxPrice < price[i]) maxPrice = price[i];
          sellPrice[i] = maxPrice;
    }
    
    for(int i=1; i<=N; i++){
        if(price[i] < sellPrice[i]) maxProfit += sellPrice[i] - price[i];
    }



    cout << maxProfit <<"\n";

}

int main(){

    int T;
    cin >> T;

    for(int i=1; i<=T; i++){
        int N;
        cin >> N;
        vector<int> price(N+1, 0);

        for(int i=1; i<=N; i++){
            cin >> price[i];
        }

        solve(price, N);

    }


    return 0;

}