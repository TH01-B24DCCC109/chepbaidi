#include <stdio.h>

int n, k;
int x[20];

void Try(int i, int ones) {
   
    if (i == n) {
        if (ones == k) {
            for (int j = 0; j < n; j++) {
                printf("%d", x[j]);
            }
            printf("\n");
        }
        return;
    }


    x[i] = 0;
    Try(i + 1, ones);

    if (ones < k) {
        x[i] = 1;
        Try(i + 1, ones + 1);
    }
}

int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d", &n, &k);
        Try(0, 0);
    }

    return 0;
}