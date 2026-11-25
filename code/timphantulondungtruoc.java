import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            long[] a = new long[n];
            
            // Đọc mảng a (dùng StringTokenizer để tối ưu đọc nhiều số trên một dòng)
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            long[] res = new long[n];
            Stack<Integer> stack = new Stack<>();
            
            // Duyệt từ phải qua trái
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = a[stack.peek()];
                }
                stack.push(i);
            }
            
            // Ghi kết quả của test hiện tại
            for (int i = 0; i < n; i++) {
                out.append(res[i]).append(i == n - 1 ? "" : " ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}