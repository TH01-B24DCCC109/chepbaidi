#include <stdio.h>

int n, k;
int a[20];
int x[20];
int dem = 0;

void Try(int i, int sum, int pos) {
    // Nếu tổng bằng K thì in dãy con
    if (sum == k) {
        for (int j = 0; j < pos; j++) {
            if (j > 0)
                printf(" ");
            printf("%d", x[j]);
        }
        printf("\n");

        dem++;
        return;
    }

    // Đã xét hết phần tử hoặc tổng đã vượt K
    if (i == n || sum > k)
        return;

    // Chọn a[i]
    x[pos] = a[i];
    Try(i + 1, sum + a[i], pos + 1);

    // Không chọn a[i]
    Try(i + 1, sum, pos);
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