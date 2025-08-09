#include <iostream>
using namespace std;

int N, input;
string command;

struct Node{
    int data;
    Node* next;
};

class Stack{

private :
    Node* start;
    int cnt;

public :

    Stack(){
        start = nullptr;
        cnt = 0;
    }
    ~Stack(){
        while(start != nullptr){
            pop();
        }
    }

    void push(int num){
        Node* node = new Node;
        node->data = num;
        node->next = start;
        start = node;
        cnt ++;
    }

    int pop(){
        if(empty()){
            return -1;
        }
        Node* tmp = start;
        int poppedData = tmp->data;
        start = start->next;
        delete tmp;
        cnt --;
        return poppedData;
    }

   int size(){
    return cnt;
}

    int empty(){
        if(start == nullptr) return 1;
        else return 0;

    }

    int top(){
        if(empty()) return -1;
        return start->data;

    }

};

int main() {

    cin >> N;

    Stack s;
    for(int i=1; i<= N; i++){
        cin >> command;

        if (command == "pop") {
            cout << s.pop() << '\n';
        } else if (command == "empty") {
            cout << s.empty() << '\n';
        } else if (command == "size") {
            cout << s.size() << '\n';
        } else if (command == "top") {
            cout << s.top() << '\n';
        } else if (command == "push") {
            cin >> input;
            s.push(input);
        }

    }

    return 0;

}