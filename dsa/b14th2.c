#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int a[15];
int x[15];
int n;

typedef struct {
    int b[15];
    int len;
} Sequence;

Sequence ds[20000];
int cnt;

// Sắp xếp A giảm dần
int cmpDesc(const void *p, const void *q) {
    return *(int *)q - *(int *)p;
}

// So sánh 2 dãy theo thứ tự từ điển
int cmpSequence(const void *p, const void *q) {
    Sequence *x = (Sequence *)p;
    Sequence *y = (Sequence *)q;

    int len = x->len < y->len ? x->len : y->len;

    for (int i = 0; i < len; i++) {
        if (x->b[i] != y->b[i])
            return x->b[i] - y->b[i];
    }

    // Nếu một dãy là tiền tố của dãy kia
    return x->len - y->len;
}

// Sinh tất cả dãy con
void Try(int pos, int start, int sum) {
    // Có ít nhất 1 phần tử và tổng lẻ
    if (pos > 0 && sum % 2 != 0) {
        ds[cnt].len = pos;

        for (int i = 0; i < pos; i++)
            ds[cnt].b[i] = x[i];

        cnt++;
    }

    // Chọn phần tử tiếp theo
    for (int i = start; i < n; i++) {
        x[pos] = a[i];

        Try(pos + 1, i + 1, sum + a[i]);
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d", &n);

        for (int i = 0; i < n; i++)
            scanf("%d", &a[i]);

        // Bước 1: sắp xếp giảm dần
        qsort(a, n, sizeof(int), cmpDesc);

        // Bước 2: sinh các dãy con
        cnt = 0;
        Try(0, 0, 0);

        // Bước 3: sắp xếp các dãy con theo từ điển
        qsort(ds, cnt, sizeof(Sequence), cmpSequence);

        // Bước 4: in kết quả
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < ds[i].len; j++) {
                printf("%d", ds[i].b[j]);

                if (j < ds[i].len - 1)
                    printf(" ");
            }

            printf("\n");
        }
    }

    return 0;
}