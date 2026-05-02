#include <string>
#include <set>
#include <math.h>

using namespace std;
multiset<string> ms1;
multiset<string> ms2;

void makeSet(string str1, string str2){
    
    for(int i=0; i<str1.size()-1; i++){
        if(isalpha(str1[i]) && isalpha(str1[i+1])){
            string tmp = "";
            tmp += toupper(str1[i]);
            tmp += toupper(str1[i+1]);
            ms1.insert(tmp);
        }
    }
    
    for(int i=0; i<str2.size()-1; i++){
        if(isalpha(str2[i]) && isalpha(str2[i+1])){
            string tmp = "";
            tmp += toupper(str2[i]);
            tmp += toupper(str2[i+1]);
            ms2.insert(tmp);
        }
    }
    
}

double computeJacde(){
    int common, total;
    
    auto it1 = ms1.begin();
    auto it2 = ms2.begin();

    while (it1 != ms1.end() && it2 != ms2.end()) {
        if (*it1 < *it2) {
            it1++;
        } else if (*it1 > *it2) {
            it2++;
        } else {
            common++;
            it1++;
            it2++;
        }
    }
    
    total = ms1.size() + ms2.size() - common;
    if (total == 0) return 1.0;
    return (double)common/total;
    
}

int solution(string str1, string str2) {
    int answer = 0;
    
    makeSet(str1, str2);
    double result = computeJacde();
    answer = (int)(result * 65536 );
    
    return answer;
}