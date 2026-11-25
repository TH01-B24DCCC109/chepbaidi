#include <stdio.h>

int n;
char x[11];

void Try(int i) {
    if (i == n) {
        printf("%s ", x);
        return;
    }

    x[i] = 'A';
    Try(i + 1);

    x[i] = 'B';
    Try(i + 1);
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d", &n);

        Try(0);
        printf("\n");
    }

    return 0;
}