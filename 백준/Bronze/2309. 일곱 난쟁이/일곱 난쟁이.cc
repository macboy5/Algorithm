#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){

    vector<int> arr(9);
    vector<char> flag(9, 'y');

    int sum = 0;
    for(int i=0; i<9; i++){
        cin >> arr[i];
        sum += arr[i];
    }

    int diff = sum - 100;
    sort(arr.begin(), arr.end());
    
    bool found = false;

    for(int i=0; i<9; i++){
        for(int j=i; j<9; j++){
            if(arr[i] + arr[j] == diff){
                flag[i] = 'x';
                flag[j] = 'x';
                found = true;
                break;
            }
        }
        
        if(found) break;
    }

    for(int i=0; i<9; i++){
        if(flag[i] == 'x') continue;
        else cout << arr[i] << '\n';
    }





    return 0;
}