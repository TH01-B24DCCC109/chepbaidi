import java.util.Scanner;

public class demquyhoachdong {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bảng quy hoạch động dp[i][j]: số lượng số có i chữ số bắt đầu bằng chữ số j
        long[][] dp = new long[101][10];

        // Khởi tạo trường hợp cơ sở: số có 1 chữ số
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // Tính DP cho các độ dài từ 2 đến 100
        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = 0;
                for (int k = j; k <= 9; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        if (sc.hasNextInt()) {
            int T = sc.nextInt(); // Số lượng bộ test
            while (T-- > 0) {
                int N = sc.nextInt();
                
                // Tính tổng tất cả các số có N chữ số
                long ans = 0;
                for (int j = 1; j <= 9; j++) {
                    ans = (ans + dp[N][j]) % MOD;
                }

                System.out.println(ans);
            }
        }
        sc.close();
    }
}

