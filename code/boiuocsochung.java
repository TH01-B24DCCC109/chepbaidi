import java.util.Scanner;

public class boiuocsochung {
     public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            long ucln = gcd(a, b);
            long bcnn = a * b / ucln;

            System.out.println(bcnn + " " + ucln);
        }

        sc.close();
    }
}
