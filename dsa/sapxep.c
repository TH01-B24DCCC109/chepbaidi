#include <stdio.h>

int main() {
    int t;
    scanf("%d", &t);

    while (t--) {
        int n;
        scanf("%d", &n);

  
        int cnt[10000] = {0};

     
        for (int i = 0; i < n; i++) {
            int x;
            scanf("%d", &x);
            cnt[x]++;
        }

   
        int first = 1;

        for (int i = 1000; i <= 9999; i++) {
            while (cnt[i] > 0) {
                if (!first)
                    printf(" ");

                printf("%d", i);

                first = 0;
                cnt[i]--;
            }
        }

        printf("\n");
    }

    return 0;
}