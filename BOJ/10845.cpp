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
    Node* head; // ť�� �� ��(��µǴ� ��ġ)�� ����Ű�� ������
    Node* tail; // ť�� �� ��(�ԷµǴ� ��ġ)�� ����Ű�� ������

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

    // ť�� �� �ڿ� �����͸� �߰�
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

    // ť�� �� �տ��� �����͸� �����ϰ� ��ȯ
    int pop() {
        if (empty()) {
            return -1;
        }

        int poppedData = head->data;
        Node* temp = head;
        head = head->next;
        delete temp;

        if (head == nullptr) { // ������ ���Ҹ� pop�ϴ� ��� tail�� nullptr�� ����
            tail = nullptr;
        }

        cnt--;
        return poppedData;
    }

    int size() {
        return cnt;
    }

    int empty() {
        return (cnt == 0); // �� ������ ǥ��
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
    for (int i = 0; i < N; i++) { // �ݺ��� ���� ����
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