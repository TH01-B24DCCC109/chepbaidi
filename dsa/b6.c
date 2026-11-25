#include <stdio.h>
#include <string.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        char x[1005];
        scanf("%s", x);

        int n = strlen(x);   
        int i = n - 1;

        while (i >= 0 && x[i] == '1') {
            x[i] = '0';
            i--;
        }

        if (i >= 0) {
            x[i] = '1';
        }

        printf("%s\n", x);
    }

    return 0;
}