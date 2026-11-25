#include <stdio.h>

int a[10], x[10];
int n, K;
int found;

void Try(int pos, int start, int sum) {
    // Tổng đã bằng K
    if (sum == K) {
        found = 1;

        printf("[");
        for (int i = 0; i < pos; i++) {
            printf("%d", x[i]);

            if (i < pos - 1)
                printf(" ");
        }
        printf("] ");

        return;
    }

    // Thử chọn các phần tử tiếp theo
    for (int i = start; i < n; i++) {
        // Vì các số đều dương
        if (sum + a[i] > K)
            break;

        x[pos] = a[i];

        Try(pos + 1, i + 1, sum + a[i]);
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d %d", &n, &K);

        for (int i = 0; i < n; i++)
            scanf("%d", &a[i]);

        found = 0;

        Try(0, 0, 0);

        if (!found)
            printf("-1");

        printf("\n");
    }

    return 0;
}