#include <iostream>
#include <string>

using namespace std;

struct Node {
    int data;
    Node* next;
};

class Queue {
private:
    int cnt;
    Node* head; // 큐의 맨 앞(출력되는 위치)을 가리키는 포인터
    Node* tail; // 큐의 맨 뒤(입력되는 위치)를 가리키는 포인터

public:
    Queue() {
        head = nullptr;
        tail = nullptr;
        cnt = 0;
    }

    ~Queue() {
        while (head != nullptr) {
            pop();
        }
    }

    // 큐의 맨 뒤에 데이터를 추가
    void push(int data) {
        Node* newNode = new Node;
        newNode->data = data;
        newNode->next = nullptr;

        if (empty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
        cnt++;
    }

    // 큐의 맨 앞에서 데이터를 제거하고 반환
    int pop() {
        if (empty()) {
            return -1;
        }

        int poppedData = head->data;
        Node* temp = head;
        head = head->next;
        delete temp;

        if (head == nullptr) { // 마지막 원소를 pop하는 경우 tail도 nullptr로 설정
            tail = nullptr;
        }

        cnt--;
        return poppedData;
    }

    int size() {
        return cnt;
    }

    int empty() {
        return (cnt == 0); // 더 간결한 표현
    }

    int front() {
        if (empty()) {
            return -1;
        }
        return head->data;
    }

    int back() {
        if (empty()) {
            return -1;
        }
        return tail->data;
    }
};

int main() {
    int N, num;
    cin >> N;
    string command;
    Queue Q;
    for (int i = 0; i < N; i++) { // 반복문 조건 수정
        cin >> command;
        if (command == "front") {
            cout << Q.front() << '\n';
        } else if (command == "back") {
            cout << Q.back() << '\n';
        } else if (command == "size") {
            cout << Q.size() << '\n';
        } else if (command == "empty") {
            cout << Q.empty() << '\n';
        } else if (command == "pop") {
            cout << Q.pop() << '\n';
        } else if (command == "push") {
            cin >> num;
            Q.push(num);
        }
    }
    return 0;
}