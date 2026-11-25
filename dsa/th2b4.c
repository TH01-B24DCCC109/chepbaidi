#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        int a[10];

        scanf("%d", &n);

        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }

        // In từng hàng
        while (n > 0) {

            // In hàng hiện tại
            printf("[");
            for (int i = 0; i < n; i++) {
                printf("%d", a[i]);

                if (i < n - 1)
                    printf(" ");
            }
            printf("]\n");

            // Tạo hàng tiếp theo
            for (int i = 0; i < n - 1; i++) {
                a[i] = a[i] + a[i + 1];
            }

            n--;
        }
    }

    return 0;
}