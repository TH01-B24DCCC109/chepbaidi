#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n, m;
        scanf("%d %d", &n, &m);

        int A[100000];
        int B[100000];

        for (int i = 0; i < n; i++) {
            scanf("%d", &A[i]);
        }

        for (int i = 0; i < m; i++) {
            scanf("%d", &B[i]);
        }

        // TÌM UNION
        

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (A[i] < B[j]) {
                printf("%d ", A[i]);
                i++;
            }
            else if (A[i] > B[j]) {
                printf("%d ", B[j]);
                j++;
            }
            else {
  
                printf("%d ", A[i]);
                i++;
                j++;
            }
        }

     
        while (i < n) {
            printf("%d ", A[i]);
            i++;
        }

   
        while (j < m) {
            printf("%d ", B[j]);
            j++;
        }

        printf("\n");

        i = 0;
        j = 0;

        while (i < n && j < m) {
            if (A[i] < B[j]) {
                i++;
            }
            else if (A[i] > B[j]) {
                j++;
            }
            else {
                // A[i] == B[j]
                printf("%d ", A[i]);
                i++;
                j++;
            }
        }

        printf("\n");
    }

    return 0;
}