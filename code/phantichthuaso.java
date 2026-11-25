import java.util.Scanner;

public class phantichthuaso {

    public static void primeFactorization(int n, int test) {

        System.out.print("Test " + test + ": ");

        for (int i = 2; i * i <= n; i++) {

            int count = 0;

            while (n % i == 0) {
                count++;
                n /= i;
            }

            if (count > 0) {
                System.out.print(i + "(" + count + ") ");
            }
        }

        // Nếu còn lại n là số nguyên tố
        if (n > 1) {
            System.out.print(n + "(1)");
        }

        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();

            primeFactorization(n, i);
        }

        sc.close();
    }
}