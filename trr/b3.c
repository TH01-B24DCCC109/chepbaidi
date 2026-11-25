#include <stdio.h>
#include <math.h>

int main() {
    double a, b, c;
    scanf("%lf %lf %lf", &a, &b, &c);

    int result = 0;

    if (a == 0) {
        // Phương trình bậc nhất bx + c = 0
        if (b == 0) {
            if (c == 0)
                result = 1; // vô số nghiệm
        } else {
            double x = -c / b;
            if (x > 0)
                result = 1;
        }
    } else {
        // Phương trình bậc hai
        double delta = b * b - 4 * a * c;

        if (delta >= 0) {
            double x1 = (-b + sqrt(delta)) / (2 * a);
            double x2 = (-b - sqrt(delta)) / (2 * a);

            if (x1 > 0 || x2 > 0)
                result = 1;
        }
    }

    printf("%d", result);

    return 0;
}