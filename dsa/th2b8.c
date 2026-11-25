#include <stdio.h>
#include <stdlib.h>

int a[20];
int used[20];
int n, k;
int target;

// Sắp xếp giảm dần
int cmp(const void *x, const void *y) {
    return *(int *)y - *(int *)x;
}

int Try(int group, int start, int sum) {
    // Đã tạo đủ K nhóm
    if (group == k)
        return 1;

    // Nhóm hiện tại đã đủ tổng
    if (sum == target) {
        return Try(group + 1, 0, 0);
    }

    for (int i = start; i < n; i++) {

        if (used[i])
            continue;

        // Không được vượt quá tổng cần có
        if (sum + a[i] > target)
            continue;

        // Tránh thử các phần tử giống nhau
        // ở cùng một trạng thái
        if (i > 0 && a[i] == a[i - 1] && !used[i - 1])
            continue;

        used[i] = 1;

        if (Try(group, i + 1, sum + a[i]))
            return 1;

        used[i] = 0;

        // Nếu nhóm đang rỗng mà phần tử này
        // không tạo được đáp án thì thử phần tử
        // khác cũng không cần thiết trong một số trường hợp
        if (sum == 0)
            return 0;
    }

    return 0;
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%d %d", &n, &k);

        int total = 0;

        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
            total += a[i];
        }

        // Không thể chia nếu tổng không chia hết cho K
        if (total % k != 0) {
            printf("0\n");
            continue;
        }

        // Có nhiều nhóm hơn số phần tử
        if (k > n) {
            printf("0\n");
            continue;
        }

        target = total / k;

        // Trường hợp tất cả đều bằng 0
        if (target == 0) {
            printf("1\n");
            continue;
        }

        qsort(a, n, sizeof(int), cmp);

        for (int i = 0; i < n; i++)
            used[i] = 0;

        if (Try(0, 0, 0))
            printf("1\n");
        else
            printf("0\n");
    }

    return 0;
}