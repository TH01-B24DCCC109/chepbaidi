import java.util.Scanner;

public class Main {
    static int n;
    static char[] a;
    static StringBuilder sb;

    // Hàm quay lui sinh các xâu AB
    static void Backtrack(int i) {
        if (i == n) {
            sb.append(new String(a)).append(" ");
            return;
        }

        // Thử chọn 'A'
        a[i] = 'A';
        Backtrack(i + 1);

        // Thử chọn 'B'
        a[i] = 'B';
        Backtrack(i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int T = sc.nextInt(); // Số lượng test case
        while (T-- > 0) {
            n = sc.nextInt(); // Độ dài xâu n[cite: 4]
            a = new char[n];
            sb = new StringBuilder();

            Backtrack(0);

            // In kết quả mỗi test trên 1 dòng[cite: 4]
            System.out.println(sb.toString().trim());
        }

        sc.close();
    }
}