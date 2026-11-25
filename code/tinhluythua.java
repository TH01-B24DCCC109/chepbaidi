import java.util.Scanner;

public class tinhluythua {
     static final long MOD = 1000000007L;

    public static long powMod(long a, long b) {

        long result = 1;

        a = a % MOD;

        while (b > 0) {

            // Nếu b lẻ
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }

            // Bình phương cơ số
            a = (a * a) % MOD;

            // Chia đôi số mũ
            b /= 2;
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            long a = sc.nextLong();
            long b = sc.nextLong();

            // Điều kiện kết thúc
            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(powMod(a, b));
        }

        sc.close();
    }
    
}
