#include <string>
#include <vector>

using namespace std;


int count_bits(int n) {
    int cnt = 0;
    while (n > 0) {
        if (n % 2 == 1) cnt++;
        n /= 2;
    }
    return cnt;
}

int solution(int n) {
    int target_cnt = count_bits(n);
    int next_num = n + 1;

    while (true) {
        if (count_bits(next_num) == target_cnt) {
            return next_num;
        }
        next_num++;
    }
}