#include <stdio.h>
#include <limits.h>

#define MAXN 31

int n;
long long c[MAXN][MAXN];

int visited[MAXN];
int path[MAXN];
int bestPath[MAXN];

long long bestCost = LLONG_MAX;
long long count = 0;

void savePath() {
    for (int i = 0; i < n; i++)
        bestPath[i] = path[i];
}

void printPath() {
    for (int i = 0; i < n; i++)
        printf("%d ", path[i]);
    printf("\n");
}

void Try(int k, long long cost) {
    if (k == n) {
        long long total = cost + c[path[n - 1]][1];

        if (total < bestCost) {
            bestCost = total;
            count = 1;
            savePath();
        } else if (total == bestCost) {
            count++;
        }
        return;
    }

    for (int v = 2; v <= n; v++) {
        if (!visited[v]) {
            visited[v] = 1;
            path[k] = v;

            Try(k + 1, cost + c[path[k - 1]][v]);

            visited[v] = 0;
        }
    }
}

void printAll(int k, long long cost) {
    if (k == n) {
        long long total = cost + c[path[n - 1]][1];
        if (total == bestCost)
            printPath();
        return;
    }

    for (int v = 2; v <= n; v++) {
        if (!visited[v]) {
            visited[v] = 1;
            path[k] = v;

            printAll(k + 1, cost + c[path[k - 1]][v]);

            visited[v] = 0;
        }
    }
}

int main() {
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            scanf("%lld", &c[i][j]);

    path[0] = 1;
    visited[1] = 1;

    Try(1, 0);

    if (count == 1) {
        printf("%lld\n", bestCost);
        for (int i = 0; i < n; i++)
            printf("%d ", bestPath[i]);
    } else {
        printf("%lld %lld\n", bestCost, count);

        for (int i = 1; i <= n; i++)
            visited[i] = 0;
        visited[1] = 1;
        path[0] = 1;

        printAll(1, 0);
    }

    return 0;
}