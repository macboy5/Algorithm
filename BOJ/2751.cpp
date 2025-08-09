#include <iostream>
#include <random>
#include <algorithm>

using namespace std;


void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void quickSort(int *arr, int start, int end) {
    if (start >= end) {
        return;
    }

    int pivot = start;
    int left = start + 1;
    int right = end;


    while (left <= right) {

        while (left <= end && arr[left] <= arr[pivot]) {
            left++;
        }
        while (right > start && arr[right] >= arr[pivot]) {
            right--;
        }

        // �����ȴٸ�, right�� �ǹ��� ��ȯ
        if (left > right) {
            swap(&arr[pivot], &arr[right]);
        }
            // �������� �ʾҴٸ�, left�� right�� ��ȯ
        else {
            swap(&arr[left], &arr[right]);
        }
    }

    quickSort(arr, start, right - 1);
    quickSort(arr, right + 1, end);

}

int main() {
    int N;
    cin >> N;

    int *arr = new int[N];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    // �迭 �������� ����
    random_device rd;
    mt19937 g(rd());
    shuffle(arr, arr+N, g);

    quickSort(arr, 0, N - 1);

    for (int i = 0; i < N; i++) {
        cout << arr[i] << '\n';
    }

    delete[] arr;

    return 0;
}