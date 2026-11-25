#include <stdio.h>

int a[8][8];

int cot[8];
int cheo1[15]; // row - col + 7
int cheo2[15]; // row + col

int maxScore;

void Try(int row, int score) {
    // Đã đặt đủ 8 quân hậu
    if (row == 8) {
        if (score > maxScore)
            maxScore = score;
        return;
    }

    for (int col = 0; col < 8; col++) {

        // Kiểm tra cột và 2 đường chéo
        if (!cot[col] &&
            !cheo1[row - col + 7] &&
            !cheo2[row + col]) {

            // Đặt hậu
            cot[col] = 1;
            cheo1[row - col + 7] = 1;
            cheo2[row + col] = 1;

            Try(row + 1, score + a[row][col]);

            // Bỏ hậu để thử vị trí khác
            cot[col] = 0;
            cheo1[row - col + 7] = 0;
            cheo2[row + col] = 0;
        }
    }
}

int main() {
    int T;
    scanf("%d", &T);

    for (int tc = 1; tc <= T; tc++) {

        // Nhập bàn cờ
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                scanf("%d", &a[i][j]);
            }
        }

        // Reset
        maxScore = 0;

        for (int i = 0; i < 8; i++)
            cot[i] = 0;

        for (int i = 0; i < 15; i++) {
            cheo1[i] = 0;
            cheo2[i] = 0;
        }

        // Bắt đầu đặt từ hàng 0
        Try(0, 0);

        printf("Test %d: %d\n", tc, maxScore);
    }

    return 0;
}