#include <string>
#include <vector>
#include <math.h>
#include <set>
#include <algorithm>

using namespace std;

// 숫자가 소수인지 판별하는 함수 (수정됨)
bool isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

int solution(string numbers) {
    set<int> unique_primes;

    // 1. next_permutation을 위해 문자열을 정렬
    sort(numbers.begin(), numbers.end());

    // 2. 모든 가능한 순열을 생성
    do {
        // 3. 각 순열의 부분 문자열을 숫자로 변환하여 소수인지 확인
        for (int i = 1; i <= numbers.length(); i++) {
            string sub = numbers.substr(0, i);
            int num = stoi(sub); // 문자열을 정수로 변환
            
            if (isPrime(num)) {
                unique_primes.insert(num);
            }
        }
    } while (next_permutation(numbers.begin(), numbers.end()));

    return unique_primes.size();
}