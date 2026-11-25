import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        sc.nextLine(); // Đọc bỏ phần dư của dòng chứa n
        
        // Khởi tạo ma trận kề kích thước (n+1) x (n+1) gán giá trị 0
        int[][] a = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--; // Bỏ qua nếu dòng bị trống
                continue;
            }
            // Tách các đỉnh kề dựa vào khoảng trắng
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    int v = Integer.parseInt(part);
                    a[i][v] = 1;
                }
            }
        }
        
        // In ma trận kết quả từ 1 đến n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + (j == n ? "" : " "));
            }
            System.out.println();
        }
        
        sc.close();
    }
}