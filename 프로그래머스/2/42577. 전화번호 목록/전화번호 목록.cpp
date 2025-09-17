#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    // 1. 전화번호 목록을 사전순으로 정렬
    sort(phone_book.begin(), phone_book.end());
    
    // 2. 이웃한 번호끼리만 비교
    for (int i = 0; i < phone_book.size() - 1; i++) {
        // 현재 번호가 다음 번호의 접두어인지 확인
        // substr() 대신 find()를 사용하는 것이 더 효율적일 수 있음.
        if (phone_book[i] == phone_book[i+1].substr(0, phone_book[i].length())) {
            answer = false;
            return answer;
        }
    }
    
    return answer;
}