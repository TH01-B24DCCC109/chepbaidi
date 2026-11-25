#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d", &n);

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            int x;
            scanf("%d", &x);

            if (x == 0)
                cnt0++;
            else if (x == 1)
                cnt1++;
            else
                cnt2++;
        }

        for (int i = 0; i < cnt0; i++) {
            printf("0 ");
        }

        for (int i = 0; i < cnt1; i++) {
            printf("1 ");
        }

        for (int i = 0; i < cnt2; i++) {
            printf("2 ");
        }

        printf("\n");
    }

    return 0;
}