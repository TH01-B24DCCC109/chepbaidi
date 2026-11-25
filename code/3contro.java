import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int T = sc.nextInt(); // Số lượng test case
        
        while (T-- > 0) {
            int n = sc.nextInt(); // Kích thước mảng A
            int m = sc.nextInt(); // Kích thước mảng B[cite: 1]
            int k = sc.nextInt(); // Kích thước mảng C[cite: 1]
            
            long[] A = new long[n];
            long[] B = new long[m];
            long[] C = new long[k];
            
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextLong();
            }
            for (int i = 0; i < m; i++) {
                B[i] = sc.nextLong();
            }
            for (int i = 0; i < k; i++) {
                C[i] = sc.nextLong();
            }
            
            // Kỹ thuật 3 con trỏ
            int p1 = 0, p2 = 0, p3 = 0;
            boolean found = false;
            StringBuilder sb = new StringBuilder();
            
            while (p1 < n && p2 < m && p3 < k) {
                if (A[p1] == B[p2] && B[p2] == C[p3]) {
                    sb.append(A[p1]).append(" ");
                    found = true;
                    p1++;
                    p2++;
                    p3++;
                } else if (A[p1] < B[p2]) {
                    p1++;
                } else if (B[p2] < C[p3]) {
                    p2++;
                } else {
                    p3++;
                }
            }
            
            // In kết quả theo yêu cầu[cite: 1]
            if (found) {
                System.out.println(sb.toString().trim());
            } else {
                System.out.println("NO");[cite: 1]
            }
        }
        
        sc.close();
    }
}