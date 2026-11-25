#include <stdio.h>

int n;
int a[10];

void Try(int i) {
    if (i > (n - 1)  / 2) {
        for (int j = 0; j < n; j++) {
            printf("%d", a[j]);
            if (j < n - 1)
                printf(" ");
        }
        printf("\n");
        return;
    }


    a[i] = 0;
    a[n - 1 - i] = 0;
    Try(i + 1);

    // Chọn 1
    a[i] = 1;
    a[n - 1 - i] = 1;
    Try(i + 1);
}

int main() {
    scanf("%d", &n);

    Try(0);

    return 0;
}