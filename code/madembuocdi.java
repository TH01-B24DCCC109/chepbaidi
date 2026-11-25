import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static class Node {
        int x, y, dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;

        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String l = reader.readLine();
                if (l == null) break;
                tokenizer = new StringTokenizer(l);
            }
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());

            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                    a[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            // BFS tìm đường đi ngắn nhất từ (0, 0) đến (m - 1, n - 1)
            boolean[][] visited = new boolean[m][n];
            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(0, 0, 0));
            visited[0][0] = true;

            int ans = -1;
            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr.x == m - 1 && curr.y == n - 1) {
                    ans = curr.dist;
                    break;
                }

                int jump = a[curr.x][curr.y];
                if (jump == 0) continue; // Tránh kẹt vòng lặp nếu bước nhảy bằng 0

                // 2 hướng di chuyển: sang phải hoặc xuống dưới
                int nextX1 = curr.x;
                int nextY1 = curr.y + jump;
                
                int nextX2 = curr.x + jump;
                int nextY2 = curr.y;

                // Kiểm tra di chuyển theo chiều ngang (sang phải)
                if (nextY1 < n && !visited[nextX1][nextY1]) {
                    visited[nextX1][nextY1] = true;
                    queue.add(new Node(nextX1, nextY1, curr.dist + 1));
                }

                // Kiểm tra di chuyển theo chiều dọc (xuống dưới)
                if (nextX2 < m && !visited[nextX2][nextY2]) {
                    visited[nextX2][nextY2] = true;
                    queue.add(new Node(nextX2, nextY2, curr.dist + 1));
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}