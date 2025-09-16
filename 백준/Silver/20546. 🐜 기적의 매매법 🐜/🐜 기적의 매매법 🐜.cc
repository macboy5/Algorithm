#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

int BNP(int cash, vector<int> stock){

    int remain = cash;
    int stock_cnt = 0;

    for(int i=0; i<stock.size(); i++){
        int tmp = remain / stock[i];
        remain -= tmp * stock[i];
        stock_cnt += tmp;
    }

    int value = stock[13] * stock_cnt + remain;

    return value;
}

int Timing(int cash, vector<int> stock){

    int remain = cash;
    int stock_cnt = 0;
    int short_day = 0;
    int long_day = 0;

    for(int i=1; i<stock.size(); i++){
        if(stock[i-1] < stock[i]){
            long_day ++;
            short_day = 0;
        }
        else if( stock[i-1] > stock[i]){
            long_day = 0;
            short_day++;
        }
        else{
            long_day = 0;
            short_day = 0;
        }

        // 전량 매수
        if( short_day == 3){
            int tmp = remain/stock[i];
            remain -= tmp * stock[i];
            stock_cnt += tmp;
            short_day = 0;
            long_day = 0;
        }
        // 전량 매도
        if(long_day == 3){
            remain += stock_cnt * stock[i];
            stock_cnt = 0;
            short_day = 0;
            long_day = 0;
        }
    }

    int value = stock[13] * stock_cnt + remain;

    return value;

}


int main() {

    int cash;

    vector<int> stock(14);

    cin >> cash;

    for(int i=0; i<14; i++){
        cin >> stock[i];
    }

    int bnp = BNP(cash, stock);
    int timing = Timing(cash, stock);

    if(bnp> timing){
        cout << "BNP";
    }
    else if (bnp == timing){
        cout << "SAMESAME";
    }
    else{
        cout << "TIMING";
    }



    return 0;
}