import java.util.Scanner;

public class usntmax {
      public static long largestPrimeFactor(long n) {

        long max = 0;

        // Tách các thừa số 2
        while (n % 2 == 0) {
            max = 2;
            n /= 2;
        }

        // Tách các thừa số lẻ
        for (long i = 3; i * i <= n; i += 2) {

            while (n % i == 0) {
                max = i;
                n /= i;
            }
        }

        // Nếu còn lại n > 1 thì n là số nguyên tố lớn nhất
        if (n > 1) {
            max = n;
        }

        return max;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long N = sc.nextLong();

            System.out.println(largestPrimeFactor(N));
        }

        sc.close();
    }
}
