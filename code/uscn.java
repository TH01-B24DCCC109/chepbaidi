import java.util.Scanner;

public class uscn {

    public static int countEvenDivisors(long n) {
        int count = 0;

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {

                // Ước i
                if (i % 2 == 0) {
                    count++;
                }

                // Ước n/i (khác i)
                long j = n / i;
                if (j != i && j % 2 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();

            System.out.println(countEvenDivisors(N));
        }

        sc.close();
    }
}