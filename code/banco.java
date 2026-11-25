import java.util.Scanner;

public class Main {
    static int[][] board = new int[8][8];
    static int maxScore;
    static boolean[] cols;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                // Đọc dữ liệu bàn cờ 8x8 cho mỗi test case
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        board[i][j] = sc.nextInt();
                    }
                }
                
                // Khởi tạo lại các biến cho test case mới
                maxScore = 0;
                cols = new boolean[8];
                diag1 = new boolean[15]; // Đường chéo phụ (row + col)
                diag2 = new boolean[15]; // Đường chéo chính (row - col + 7)
                
                // Bắt đầu đặt quân hậu từ hàng 0
                solve(0, 0);
                
                // In kết quả theo yêu cầu (Thứ tự test và điểm lớn nhất)
                System.out.printf("Test %d: %d\n", t, maxScore);
            }
        }
        sc.close();
    }

    static void solve(int row, int currentScore) {
        // Nếu đã đặt thành công 8 quân hậu (từ hàng 0 đến 7)
        if (row == 8) {
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
            return;
        }

        // Thử đặt quân hậu vào từng cột ở hàng hiện tại (row)
        for (int col = 0; col < 8; col++) {
            // Kiểm tra xem vị trí (row, col) có bị khống chế hay không
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + 7]) {
                
                // Đánh dấu vị trí đã bị khống chế bởi quân hậu mới
                cols[col] = true;
                diag1[row + col] = true;
                diag2[row - col + 7] = true;

                // Đệ quy để đặt quân hậu ở hàng tiếp theo và cộng dồn điểm
                solve(row + 1, currentScore + board[row][col]);

                // Backtrack: Gỡ đánh dấu để thử trường hợp khác
                cols[col] = false;
                diag1[row + col] = false;
                diag2[row - col + 7] = false;
            }
        }
    }
}