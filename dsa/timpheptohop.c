#include <stdio.h>
#include <stdlib.h>

int a[25];
int x[25];
int n, S;
int found = 0;

int cmp(const void *p, const void *q) {
    return (*(int *)p - *(int *)q);
}

void Try(int pos, int sum, int start) {
    if (sum == S) {
        found = 1;

        printf("[");
        for (int i = 0; i < pos; i++) {
            printf("%d", x[i]);
            if (i < pos - 1)
                printf(" ");
        }
        printf("]");

        return;
    }

    for (int i = start; i < n; i++) {
        // Vì A[i] > 0 nên nếu vượt S thì
        // các phần tử phía sau cũng không thể dùng được
        if (sum + a[i] > S)
            break;

        x[pos] = a[i];

        // i thay vì i+1:
        // cho phép sử dụng lại A[i] nhiều lần
        Try(pos + 1, sum + a[i], i);
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d %d", &n, &S);

        for (int i = 0; i < n; i++)
            scanf("%d", &a[i]);

        // Sắp xếp tăng dần để tạo tổ hợp không giảm
        qsort(a, n, sizeof(int), cmp);

        found = 0;

        Try(0, 0, 0);

        if (!found)
            printf("-1");

        printf("\n");
    }

    return 0;
}