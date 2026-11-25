#include <stdio.h>


void merge(int a[], int left, int mid, int right) {
    int temp[100000];
    
    int i = left;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= right) {
        if (a[i] < a[j]) {
            temp[k] = a[i];
            i++;
        } else {
            temp[k] = a[j];
            j++;
        }
        k++;
    }


    while (i <= mid) {
        temp[k] = a[i];
        i++;
        k++;
    }


    while (j <= right) {
        temp[k] = a[j];
        j++;
        k++;
    }


    for (i = 0; i < k; i++) {
        a[left + i] = temp[i];
    }
}

void mergeSort(int a[], int left, int right) {
    if (left >= right) {
        return;
    }

    int mid = (left + right) / 2;


    mergeSort(a, left, mid);
    mergeSort(a, mid + 1, right);
    merge(a, left, mid, right);
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int N;
        scanf("%d", &N);

        int a[100000];

        for (int i = 0; i < N; i++) {
            scanf("%d", &a[i]);
        }

        mergeSort(a, 0, N - 1);

        for (int i = 0; i < N; i++) {
            printf("%d", a[i]);

            if (i < N - 1) {
                printf(" ");
            }
        }

        printf("\n");
    }

    return 0;
}