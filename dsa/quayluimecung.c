#include <stdio.h>

int a[10][10];
int n;
char path[20];
int found;

void Try(int i, int j, int pos) {
    // Đã đến đích
    if (i == n - 1 && j == n - 1) {
        path[pos] = '\0';
        printf("%s ", path);
        found = 1;
        return;
    }

    // Đi xuống - D
    if (i + 1 < n && a[i + 1][j] == 1) {
        path[pos] = 'D';
        Try(i + 1, j, pos + 1);
    }

    // Đi sang phải - R
    if (j + 1 < n && a[i][j + 1] == 1) {
        path[pos] = 'R';
        Try(i, j + 1, pos + 1);
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d", &n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &a[i][j]);
            }
        }

        found = 0;

        // Nếu ô đầu hoặc ô cuối bị chặn
        if (a[0][0] == 0 || a[n - 1][n - 1] == 0) {
            printf("-1\n");
            continue;
        }

        Try(0, 0, 0);

        if (!found)
            printf("-1");

        printf("\n");
    }

    return 0;
}