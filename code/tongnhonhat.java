import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int T = sc.nextInt(); // Số lượng bộ test
            while (T-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                // Sắp xếp mảng theo thứ tự tăng dần
                Arrays.sort(a);

                long num1 = 0;
                long num2 = 0;

                // Tạo 2 số bằng cách chia luôn phiên các chữ số
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        num1 = num1 * 10 + a[i];
                    } else {
                        num2 = num2 * 10 + a[i];
                    }
                }

                // In ra tổng nhỏ nhất
                System.out.println(num1 + num2);
            }
        }
        sc.close();
    }
}