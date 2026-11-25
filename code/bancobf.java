import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static class Point {
        int x, y, dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // 8 hướng di chuyển của quân mã
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

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
            
            String startStr = tokenizer.nextToken();
            String endStr = tokenizer.nextToken();

            // Chuyển đổi tọa độ xâu (vd: 'e2') sang dạng số (row, col)
            // 'a'-'h' -> cột 0-7, '1'-'8' -> hàng 0-7
            int startY = startStr.charAt(0) - 'a';
            int startX = startStr.charAt(1) - '1';
            
            int endY = endStr.charAt(0) - 'a';
            int endX = endStr.charAt(1) - '1';

            // BFS tìm đường đi ngắn nhất
            boolean[][] visited = new boolean[8][8];
            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(startX, startY, 0));
            visited[startX][startY] = true;

            int ans = -1;
            while (!queue.isEmpty()) {
                Point curr = queue.poll();

                if (curr.x == endX && curr.y == endY) {
                    ans = curr.dist;
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, curr.dist + 1));
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
