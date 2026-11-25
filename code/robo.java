import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    // Lớp đại diện cho một tọa độ (x, y)
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // Lớp lưu trạng thái trong Queue gồm Tọa độ và số bước đi
    static class Node {
        Point p;
        int dist;

        public Node(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }
    }

    // 8 hướng di chuyển
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

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
            long xA = Long.parseLong(tokenizer.nextToken());
            long yA = Long.parseLong(tokenizer.nextToken());
            long xB = Long.parseLong(tokenizer.nextToken());
            long yB = Long.parseLong(tokenizer.nextToken());

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            int n = Integer.parseInt(tokenizer.nextToken());

            HashSet<Point> validCells = new HashSet<>();
            for (int i = 0; i < n; i++) {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                long x = Long.parseLong(tokenizer.nextToken());
                long y1 = Long.parseLong(tokenizer.nextToken());
                long y2 = Long.parseLong(tokenizer.nextToken());

                for (long y = y1; y <= y2; y++) {
                    validCells.add(new Point(x, y));
                }
            }

            Point start = new Point(xA, yA);
            Point target = new Point(xB, yB);

            // Kiểm tra điểm đầu hoặc cuối không có trên vạch
            if (!validCells.contains(start) || !validCells.contains(target)) {
                sb.append(-1).append("\n");
                continue;
            }

            if (start.equals(target)) {
                sb.append(0).append("\n");
                continue;
            }

            // BFS tìm đường đi ngắn nhất
            Queue<Node> queue = new LinkedList<>();
            HashSet<Point> visited = new HashSet<>();

            queue.add(new Node(start, 0));
            visited.add(start);

            int ans = -1;
            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr.p.equals(target)) {
                    ans = curr.dist;
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    long nx = curr.p.x + dx[i];
                    long ny = curr.p.y + dy[i];
                    Point nextPoint = new Point(nx, ny);

                    if (validCells.contains(nextPoint) && !visited.contains(nextPoint)) {
                        visited.add(nextPoint);
                        queue.add(new Node(nextPoint, curr.dist + 1));
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}