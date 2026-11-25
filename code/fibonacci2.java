import java.util.Scanner;

public class fibonacci2 {

     public static boolean isFibonacci(long n) {

        if (n == 0 || n == 1) {
            return true;
        }

        long a = 0;
        long b = 1;

        while (b < n) {
            long c = a + b;

            // tránh tràn số
            a = b;
            b = c;
        }

        return b == n;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long n = sc.nextLong();

            if (isFibonacci(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}