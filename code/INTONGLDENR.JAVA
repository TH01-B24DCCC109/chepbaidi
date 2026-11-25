import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
    // Lớp FastReader giúp đọc dữ liệu nhanh hơn Scanner để tránh TLE
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024 * 32];
        private int head = 0;
        private int tail = 0;

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (Exception e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return -1;
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                c = read();
            }
            return res * sgn;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        if (N == -1) return;
        int Q = sc.nextInt();

        // Mảng prefixSum lưu tổng cộng dồn của các giá trị dương
        long[] P = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            long val = sc.nextInt();
            // Chỉ cộng nếu giá trị > 0
            P[i] = P[i - 1] + Math.max(0L, val);
        }

        // Xử lý Q truy vấn
        for (int q = 0; q < Q; q++) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            // Đáp án trong O(1)
            long ans = P[R] - P[L - 1];
            out.println(ans);
        }

        out.flush();
    }
}