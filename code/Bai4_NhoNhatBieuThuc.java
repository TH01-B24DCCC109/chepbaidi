import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bai4_NhoNhatBieuThuc {
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
            int n = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                a[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                b[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            // Tích A[i] * B[i] với A[i], B[i] <= 10^18 có thể lên tới 10^36, dùng BigInteger để tránh tràn số
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < n; i++) {
                BigInteger valA = BigInteger.valueOf(a[i]);
                BigInteger valB = BigInteger.valueOf(b[n - 1 - i]);
                sum = sum.add(valA.multiply(valB));
            }

            sb.append(sum.toString()).append("\n");
        }
        System.out.print(sb);
    }
}