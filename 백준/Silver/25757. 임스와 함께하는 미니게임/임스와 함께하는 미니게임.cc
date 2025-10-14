#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <set>

using namespace std;

void solve(char type, set<string> &S){

    int num;

    if(type == 'Y'){
        num = 1;
    }
    else if(type == 'F'){
        num = 2;
    }
    else if(type == 'O'){
        num = 3;
    }

    cout << S.size()/num;

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    char type;
    cin >> N >> type;

    set<string> S;

    while(N--){
        string name;
        cin >> name;
        S.insert(name);
    }

    solve(type, S);

    return 0;
}