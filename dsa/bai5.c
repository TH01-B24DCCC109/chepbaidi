#include <stdio.h>

int n;
int a[10];
int used[10];
int dem = 0;

void Try(int i) {
    if (i > n) {
        dem++;

        printf("%d: ", dem);
        for (int j = 1; j <= n; j++) {
            printf("%d ", a[j]);
        }
        printf("\n");

        return;
    }

    for (int j = 1; j <= n; j++) {
        if (used[j] == 0) {
            a[i] = j;
            used[j] = 1;

            Try(i + 1);

            used[j] = 0;
        }
    }
}

int main() {
    scanf("%d", &n);

    Try(1);

    return 0;
}