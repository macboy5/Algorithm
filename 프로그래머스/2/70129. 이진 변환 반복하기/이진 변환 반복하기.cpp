#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

string binary_change(int num){
if (num == 0) return "0";
    
    string value = "";
    int tmp = num;
    int max_bit = 0;

    while (pow(2, max_bit + 1) <= num) {
        max_bit++;
    }

    for (int i = max_bit; i >= 0; i--) {
        int power_of_2 = pow(2, i); 
        
        if (num >= power_of_2) {
            value += '1';      
            num -= power_of_2;  
        } else {
            value += '0';      
        }
    }
    
    return value;
}

vector<int> solution(string s) {
    vector<int> answer;
    string tmp = s;
    
    int eliminated = 0;
    int func_cnt = 0;
    
    while(1){
        if(tmp == "1") break;
        
        int length = 0;
        for(int i=0; i<tmp.size(); i++){
            if(tmp[i]== '1') length++;
            else eliminated++;
        }
        
        tmp = binary_change(length);
        func_cnt++;
    }
    
    answer.push_back(func_cnt);
    answer.push_back(eliminated);

    
    
    return answer;
}