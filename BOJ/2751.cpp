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

        // 엇갈렸다면, right와 피벗을 교환
        if (left > right) {
            swap(&arr[pivot], &arr[right]);
        }
            // 엇갈리지 않았다면, left와 right를 교환
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

    // 배열 랜덤으로 섞기
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