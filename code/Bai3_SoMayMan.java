public import java.io.*;

public class Bai3_SoMayMan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int count4 = -1;
            int count7 = -1;

            // Tìm số lượng số 7 nhiều nhất có thể để tổng số chữ số là ít nhất
            for (int b = n / 7; b >= 0; b--) {
                int rem = n - b * 7;
                if (rem % 4 == 0) {
                    count7 = b;
                    count4 = rem / 4;
                    break;
                }
            }

            if (count4 == -1) {
                sb.append("-1\n");
            } else {
                for (int i = 0; i < count4; i++) sb.append('4');
                for (int i = 0; i < count7; i++) sb.append('7');
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
} {
    
}
