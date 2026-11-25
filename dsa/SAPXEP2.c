#include <stdio.h>
#include <stdlib.h>

int X;


int compare(const void *a, const void *b) {
    int x = *(int *)a;
    int y = *(int *)b;

    int dx = abs(X - x);
    int dy = abs(X - y);

    return dx - dy;
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d %d", &n, &X);

        int a[100000];

        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }

        // Sắp xếp theo X - A[i]
        qsort(a, n, sizeof(int), compare);

     
        for (int i = 0; i < n; i++) {
            printf("%d", a[i]);

            if (i < n - 1) {
                printf(" ");
            }
        }

        printf("\n");
    }

    return 0;
}