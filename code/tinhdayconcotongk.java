import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] a;
    static List<List<Integer>> result;

    // Hàm quay lui tìm các dãy con có tổng bằng K
    static void backtrack(int index, int currentSum, List<Integer> currentList) {
        // Nếu tổng bằng K, lưu dãy con tìm được vào kết quả
        if (currentSum == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Nếu tổng vượt quá K hoặc đã xét hết phần tử thì dừng
        if (currentSum > k || index == n) {
            return;
        }

        // Thử chọn phần tử a[index] vào dãy con
        currentList.add(a[index]);
        backtrack(index + 1, currentSum + a[index], currentList);

        // Bỏ chọn phần tử a[index] (quay lui)
        currentList.remove(currentList.size() - 1);
        
        // Thử không chọn a[index]
        backtrack(index + 1, currentSum, currentList);
    }

    public static void solve(Scanner sc) {
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Sắp xếp mảng tăng dần để đảm bảo kết quả sinh ra theo thứ tự từ điển
        Arrays.sort(a);

        result = new ArrayList<>();
        backtrack(0, 0, new ArrayList<>());

        // Nếu không có dãy con nào thỏa mãn, in ra -1
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            // In các dãy con theo định dạng [val1, val2, ...]
            StringBuilder sb = new StringBuilder();
            for (List<Integer> list : result) {
                sb.append("[");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i < list.size() - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("] ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt(); // Số lượng bộ test
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}