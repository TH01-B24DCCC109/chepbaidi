#include <stdio.h>

int n, k;
int a[105];
int dem = 0;

void Try(int start, int pos, int last) {
    if (pos == k) {
        dem++;
        return;
    }

    for (int i = start; i < n; i++) {
        if (pos == 0 || a[i] > last) {
            Try(i + 1, pos + 1, a[i]);
        }
    }
}

int main() {
    scanf("%d %d", &n, &k);

    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    Try(0, 0, 0);

    printf("%d\n", dem);

    return 0;
}