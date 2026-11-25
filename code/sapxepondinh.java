import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int T = sc.nextInt(); // Số lượng bộ test
            while (T-- > 0) {
                int n = sc.nextInt();
                final int X = sc.nextInt();

                // Sử dụng Integer[] để giữ được tính ổn định (stable sort) khi sắp xếp
                Integer[] a = new Integer[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                // Sắp xếp các phần tử theo |X - A[i]| tăng dần
                Arrays.sort(a, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int diff1 = Math.abs(X - o1);
                        int diff2 = Math.abs(X - o2);
                        return Integer.compare(diff1, diff2);
                    }
                });

                // In kết quả
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + (i == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
        sc.close();
    }
}