#include <stdio.h>

int main() {
    long long n, m, p;

    scanf("%lld %lld %lld", &n, &m, &p);

    long long cnt = 0; // số có dư p

    if (p == 0) {
        cnt = n / m;
    } else {
        if (n >= p)
            cnt = (n - p) / m + 1;
    }

    printf("%lld", cnt + 1);

    return 0;
}