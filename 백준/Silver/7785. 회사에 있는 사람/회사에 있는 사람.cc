#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <climits>
#include <set>

using namespace std;


int main() {
    int n;
    cin >> n;
    set<string> S;

    for(int i=0;i<n; i++){
        string tmp, check;

        cin >> tmp >> check;

        if(check == "enter"){
            S.insert(tmp);
        }
        else if(check == "leave") {
            S.erase(tmp);
        }
    }

    int size = S.size();

    for (set<string>::reverse_iterator iter = S.rbegin(); iter != S.rend(); iter++) {
        cout << *iter << "\n";
    }



    return 0;
}