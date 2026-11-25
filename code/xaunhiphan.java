import java.util.Scanner;

public class xaunhiphan {
        static long[] len = new long[93];

    public static char find(int n, long k) {

        if (n == 1) {
            return '0';
        }

        if (n == 2) {
            return '1';
        }

        if (k <= len[n - 2]) {
            return find(n - 2, k);
        } else {
            return find(n - 1, k - len[n - 2]);
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        len[1] = 1;
        len[2] = 1;

        for (int i = 3; i <= 92; i++) {
            len[i] = len[i - 1] + len[i - 2];
        }

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();
            long K = sc.nextLong();

            System.out.println(find(N, K));
        }

        sc.close();
    }
}
