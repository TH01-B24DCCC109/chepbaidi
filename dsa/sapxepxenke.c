#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d", &n);

        int a[1000];

        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }

   
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

     
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }


        int left = 0;
        int right = n - 1;

        while (left <= right) {

    
            printf("%d", a[right]);
            right--;

            if (left <= right) {
                printf(" ");
            }


            if (left <= right) {
                printf("%d", a[left]);
                left++;
            }

            if (left <= right) {
                printf(" ");
            }
        }

        printf("\n");
    }

    return 0;
}