import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mảng lưu số cách nhảy lên từng bậc từ 1 đến 50
        long[] dp = new long[51];

        // Khởi tạo các giá trị cơ sở
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // Tiền tính toán các giá trị DP cho n từ 4 đến 50
        for (int i = 4; i <= 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        if (sc.hasNextInt()) {
            int T = sc.nextInt(); // Số lượng bộ test
            while (T-- > 0) {
                int n = sc.nextInt();
                System.out.println(dp[n]);
            }
        }
        sc.close();
    }
}