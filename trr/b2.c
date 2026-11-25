#include <stdio.h>

int main() {
    double a, b;
    scanf("%lf %lf", &a, &b);

    if (a == 0) {
        if (b == 0)
            printf("1");
        else
            printf("0");
    } else {
        double x = -b / a;
        if (x < 0)
            printf("1");
        else
            printf("0");
    }

    return 0;
}