#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

int main() {
    // 입출력 속도 향상 (선택 사항)
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    if (!(cin >> n)) return 0; // n을 입력받음

    vector<int> target_sequence(n);
    for (int i = 0; i < n; i++) {
        cin >> target_sequence[i]; // 0번 인덱스부터 n-1번 인덱스까지 목표 수열 저장
    }

    stack<int> s;
    string result = ""; // '+'와 '-' 연산을 저장할 문자열
    int current_push_number = 1; // 다음에 스택에 push 할 숫자 (1부터 시작)

    // 목표 수열의 원소를 순서대로 처리
    for (int target_num : target_sequence) {

        // Case 1: 스택에 push 해야 할 경우
        // 현재 push 해야 할 숫자(current_push_number)가 목표 숫자(target_num)보다 작거나 같으면,
        // target_num을 스택에 넣을 때까지 계속 push 한다.
        while (current_push_number <= target_num) {
            s.push(current_push_number);
            result += "+\n";
            current_push_number++;
        }

        // Case 2: 스택의 top이 목표 숫자와 일치하여 pop 할 경우
        // push를 마친 후, 스택의 top이 목표 숫자인지 확인하고 pop 한다.
        if (!s.empty() && s.top() == target_num) {
            s.pop();
            result += "-\n";
        }

            // Case 3: 스택의 top이 목표 숫자보다 큰 경우 -> 불가능
            // push는 오름차순으로만 했기 때문에, top의 숫자가 target_num보다 크다는 것은
            // target_num이 이미 스택 깊숙한 곳에 묻혀 있어 LIFO 규칙상 지금 꺼낼 수 없다는 의미이다.
        else {
            cout << "NO\n";
            return 0; // 즉시 프로그램 종료
        }
    }

    // 모든 수열 생성이 성공적으로 완료되면 결과 출력
    cout << result;

    return 0;
}