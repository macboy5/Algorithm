#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

bool check(int A, int B, int tmp1, int tmp2){

    if( A == B){
        if(tmp1 == tmp2){
            if(A > tmp1) return true;
            else return false;
        }
        else return true;
    }
    else{
        if(tmp1 == tmp2) return false;
        else{
            if((A+B)%10 > (tmp1+tmp2)%10) return true;
            else return false;
        }
    }

}

double func(int A, int B) {

    vector<int> card;
    for (int i = 1; i <= 10; i++) {
        card.push_back(i);
        card.push_back(i);
        if (i == A) {
            card.pop_back();
        }
        if (i == B) {
            card.pop_back();
        }
    }

    vector<int> combi(18, 0);
    for (int i = 16; i <= 17; i++) {
        combi[i] = 1;
    }

    int win = 0, lose = 0, total = 0;

    do {
        vector<int> tmp;
        for (int i = 0; i < 18; i++) {
            if (combi[i] == 1) {
                tmp.push_back(card[i]);
            }
        }

        if (check(A, B, tmp[0], tmp[1])) win++;
        else lose++;

    } while (next_permutation(combi.begin(), combi.end()));

    total = win + lose;
    double answer = (double)win/total * 1000;
    return round(answer)/1000.0;

}


int main() {

    int A, B;
    cin >> A >> B;

    cout.precision(3);
    cout << fixed << func(A,B);

    return 0;
}