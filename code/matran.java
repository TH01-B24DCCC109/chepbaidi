import java.util.*;

public class Main {
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int K, M, N;
    private static Set<String> dictionary;
    private static Set<String> result;
    private static char[][] board;
    private static boolean[][] visited;

    private static void dfs(int r, int c, String currentWord) {
        visited[r][c] = true;
        currentWord += board[r][c];

        if (dictionary.contains(currentWord)) {
            result.add(currentWord);
        }

        for (int i = 0; i < 8; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc]) {
                dfs(nr, nc, currentWord);
            }
        }

        visited[r][c] = false;
    }

    private static void solve(Scanner sc) {
        K = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();

        dictionary = new HashSet<>();
        for (int i = 0; i < K; i++) {
            dictionary.add(sc.next());
        }

        board = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        result = new LinkedHashSet<>();
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, "");
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(String.join(" ", result));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Đã sửa System.class thành System.in
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}