#include <stdio.h>

long long countMultiples( long long n, long long x ) {
    if(x == 0) return 0;
    return n / x;
}

long long gcd(long long a, long long b ) {
    while(b != 0) {
        long long temp = b;
        b = a % b;
        a = temp;

    }
    return a;
}

long long lcm(long long a, long long b) {
    if(a == 0 || b == 0) return 0;
    return (a/gcd(a,b) *b);
}

int main() {
    long long a,b,k,m;
    
    if(scanf("%lld %lld %lld %lld",&a,&b,&k,&m) == 4) {

        long long countB = countMultiples(b,k) + countMultiples(b,m)- countMultiples(b,lcm(k,m));
    
        long long countA_minus_1 = countMultiples(a-1,k) + countMultiples(a-1,m) - countMultiples(a-1, lcm(k,m));
        long long t = countB - countA_minus_1;
        printf("%lld\n", t);

    }
    return 0;
}
