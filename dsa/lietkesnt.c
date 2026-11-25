#include <stdio.h>

int n, k;
int x[20];
int stt = 0;

// Kiểm tra số nguyên tố
int isPrime(int n) {
    if (n < 2)
        return 0;

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return 0;
    }

    return 1;
}

// Sinh tổ hợp
void Try(int pos, int start) {
    // Đã chọn đủ K số
    if (pos == k) {
        stt++;

        // Chỉ in nếu số thứ tự là số nguyên tố
        if (isPrime(stt)) {
            for (int i = 0; i < k; i++) {
                printf("%d", x[i]);

                if (i < k - 1)
                    printf(" ");
            }
            printf("\n");
        }

        return;
    }

    // Chọn phần tử tiếp theo
    for (int i = start; i <= n - (k - pos); i++) {
        x[pos] = i;
        Try(pos + 1, i + 1);
    }
}

int main() {
    scanf("%d %d", &n, &k);

    Try(0, 1);

    return 0;
}