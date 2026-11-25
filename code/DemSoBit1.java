import java.io.*;
import java.util.StringTokenizer;

public class DemSoBit1 {

    // Tìm độ dài của dãy tạo bởi n
    static long getLength(long n) {
        if (n <= 1) return 1;
        long len = 1;
        while (len <= n) {
            len <<= 1;
        }
        return len - 1;
    }

    // Tìm giá trị tại vị trí pos (1-indexed) trong dãy sinh ra bởi n
    static long getValue(long n, long pos) {
        if (n <= 1) {
            return n;
        }

        long mid = (getLength(n) / 2) + 1;

        if (pos == mid) {
            return n % 2;
        } else if (pos < mid) {
            return getValue(n / 2, pos);
        } else {
            return getValue(n / 2, pos - mid);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }

            long n = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            long count = 0;
            // Duyệt qua đoạn [l, r], với mỗi vị trí tìm giá trị 0 hoặc 1
            for (long i = l; i <= r; i++) {
                if (getValue(n, i) == 1) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}