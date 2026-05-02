#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <iostream>
#include <set>

using namespace std;


string toJinsu(int n, int k){
    string tmp = "";
    
    while(n>0){
        tmp += to_string(n%k); 
        n /= k;
    }
    reverse(tmp.begin(), tmp.end());
    return tmp;
}

bool isPrime(long long num){
    if(num < 2) return false;
    
    int cnt = 0;
    for(long long i=2 ; i<=sqrt(num); i++){
        if(num % i == 0) return false;
    }
    return true;
}


int solution(int n, int k) {
    int answer = 0;
    
    string jinsu = toJinsu(n, k);
    string tmp = "";
    
    for(char c : jinsu){
        if(c == '0'){
            if( !tmp.empty()){
                if(isPrime(stoll(tmp))) answer++;
                tmp = "";
            }
        }
        else{
            tmp += c;
        }
    }
    
    if(!tmp.empty()){
        if(isPrime(stoll(tmp))) answer++;
    }
    
    return answer;
}