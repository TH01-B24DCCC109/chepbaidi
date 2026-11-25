#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
    long long sum;
    int cnt;
} Node;

Node left[1 << 15];
Node right[1 << 15];

int cmp(const void *p, const void *q) {
    Node *a = (Node *)p;
    Node *b = (Node *)q;

    if (a->sum < b->sum)
        return -1;
    if (a->sum > b->sum)
        return 1;

    return a->cnt - b->cnt;
}

// Sinh tất cả tập con của một nửa
int generate(long long a[], int n, Node arr[]) {
    int total = 1 << n;

    for (int mask = 0; mask < total; mask++) {
        long long sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (mask & (1 << i)) {
                sum += a[i];
                cnt++;
            }
        }

        arr[mask].sum = sum;
        arr[mask].cnt = cnt;
    }

    return total;
}

// Tìm trong arr một phần tử có sum đúng bằng target
// và có số tờ ít nhất
int binarySearch(Node arr[], int n, long long target) {
    int l = 0, r = n - 1;
    int ans = -1;

    while (l <= r) {
        int mid = (l + r) / 2;

        if (arr[mid].sum == target) {
            ans = mid;
            r = mid - 1;
        }
        else if (arr[mid].sum < target) {
            l = mid + 1;
        }
        else {
            r = mid - 1;
        }
    }

    if (ans == -1)
        return INT_MAX;

    // Có thể có nhiều tập con cùng tổng.
    // Tìm số tờ nhỏ nhất trong nhóm cùng tổng.
    int minCnt = arr[ans].cnt;

    int i = ans + 1;

    while (i < n && arr[i].sum == target) {
        if (arr[i].cnt < minCnt)
            minCnt = arr[i].cnt;
        i++;
    }

    return minCnt;
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        long long S;

        scanf("%d %lld", &n, &S);

        long long a[30];

        for (int i = 0; i < n; i++)
            scanf("%lld", &a[i]);

        int n1 = n / 2;
        int n2 = n - n1;

        long long a1[15], a2[15];

        for (int i = 0; i < n1; i++)
            a1[i] = a[i];

        for (int i = 0; i < n2; i++)
            a2[i] = a[n1 + i];

        // Sinh tập con hai nửa
        int size1 = generate(a1, n1, left);
        int size2 = generate(a2, n2, right);

        // Sắp xếp nửa trái theo tổng
        qsort(left, size1, sizeof(Node), cmp);

        int result = INT_MAX;

        // Duyệt tất cả tập con của nửa phải
        for (int i = 0; i < size2; i++) {

            if (right[i].sum > S)
                continue;

            long long need = S - right[i].sum;

            int cntLeft = binarySearch(left, size1, need);

            if (cntLeft != INT_MAX) {
                int totalCnt = cntLeft + right[i].cnt;

                if (totalCnt < result)
                    result = totalCnt;
            }
        }

        if (result == INT_MAX)
            printf("-1\n");
        else
            printf("%d\n", result);
    }

    return 0;
}