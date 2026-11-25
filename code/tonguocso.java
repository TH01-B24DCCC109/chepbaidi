import java.util.Scanner;

public class tonguocso {
     static int MAX = 2000000;
    static int[] spf = new int[MAX + 1];

    // Sàng lưu ước nguyên tố nhỏ nhất
    public static void sieve() {

        for (int i = 1; i <= MAX; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= MAX; i++) {

            if (spf[i] == i) {

                for (int j = i * i; j <= MAX; j += i) {

                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }


    public static long primeSum(int n) {

        long sum = 0;

        while (n > 1) {

            int p = spf[n];

            sum += p;

            n /= p;
        }

        return sum;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        sieve();

        int N = sc.nextInt();

        long ans = 0;

        while (N-- > 0) {

            int x = sc.nextInt();

            ans += primeSum(x);
        }

        System.out.println(ans);

        sc.close();
    }
}
