import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] a;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Sắp xếp mảng tăng dần
        Arrays.sort(a);

        List<Integer> currentSubset = new ArrayList<>();
        
        // Bắt đầu quay lui từ vị trí index 0 với tổng ban đầu là 0
        solve(0, 0, currentSubset);

        // Dòng cuối cùng in số lượng dãy con tìm được
        System.out.println(count);

        sc.close();
    }

    /**
     * Duyệt qua từng phần tử theo nhánh: KHÔNG CHỌN trước, CHỌN sau
     * để ra đúng thứ tự kết quả như ví dụ mẫu:
     * (10 15 25 -> 5 20 25 -> 5 10 15 20)
     */
    static void solve(int index, int currentSum, List<Integer> currentSubset) {
        // Nếu tổng hiện tại đạt đúng bằng K
        if (currentSum == k) {
            // In dãy con tìm được
            for (int i = 0; i < currentSubset.size(); i++) {
                System.out.print(currentSubset.get(i));
                if (i < currentSubset.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            count++;
            return;
        }

        // Nếu đã duyệt hết mảng hoặc tổng đã vượt quá K
        if (index == n || currentSum > k) {
            return;
        }

        // Nhánh 1: KHÔNG CHỌN phần tử a[index]
        solve(index + 1, currentSum, currentSubset);

        // Nhánh 2: CHỌN phần tử a[index] (nếu cộng vào không vượt quá K)
        if (currentSum + a[index] <= k) {
            currentSubset.add(a[index]);
            solve(index + 1, currentSum + a[index], currentSubset);
            // Backtrack: bỏ phần tử vừa thêm ra để thử trường hợp khác
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}