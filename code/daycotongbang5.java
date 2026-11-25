import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int T = sc.nextInt(); // Số lượng bộ test
            while (T-- > 0) {
                int N = sc.nextInt();
                int S = sc.nextInt();

                int[] a = new int[N];
                for (int i = 0; i < N; i++) {
                    a[i] = sc.nextInt();
                }

                // Mảng DP đánh dấu các tổng có thể tạo ra được
                boolean[] dp = new boolean[S + 1];
                dp[0] = true; // Tổng bằng 0 luôn luôn tạo ra được

                // Cập nhật mảng DP với từng phần tử a[i]
                for (int i = 0; i < N; i++) {
                    for (int j = S; j >= a[i]; j--) {
                        if (dp[j - a[i]]) {
                            dp[j] = true;
                        }
                    }
                }

                // In kết quả
                if (dp[S]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}