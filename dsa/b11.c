#include <stdio.h>

int n;
int a[20];

void Try(int sum, int max, int pos) {
    // dung de tach n
    if (sum == n) {
        printf("(");

        for (int i = 0; i < pos; i++) {
            if (i > 0)
                printf(" ");
            printf("%d", a[i]);
        }

        printf(")");
        return;
    }

    // tu lon xuong be
    int limit = n - sum;

    if (limit > max)
        limit = max;

    for (int i = limit; i >= 1; i--) {
        a[pos] = i;

        Try(sum + i, i, pos + 1);

        printf(" ");
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d", &n);

        Try(0, n, 0);

        printf("\n");
    }

    return 0;
}