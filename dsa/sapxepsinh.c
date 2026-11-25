#include <stdio.h>
#include <string.h>

char s[11];
char x[11];
int used[11];
int n;

void Try(int k) {
    if (k == n) {
        x[k] = '\0';
        printf("%s ", x);
        return;
    }

    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            used[i] = 1;
            x[k] = s[i];

            Try(k + 1);

            used[i] = 0;
        }
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%s", s);

        n = strlen(s);

        memset(used, 0, sizeof(used));

        Try(0);
        printf("\n");
    }

    return 0;
}