import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // Hàm đọc nhanh một chuỗi tiếp theo
        // (lambda hoặc hàm phụ trợ để xử lý token nhanh)
        
        // Đọc số n
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine(); // Phòng hờ dòng trống
            }
            if (line == null) break;
            
            st = new StringTokenizer(line);
            boolean first = true;
            for (int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    if (!first) {
                        sb.append(" ");
                    }
                    sb.append(j);
                    first = false;
                }
            }
            sb.append("\n");
        }
        
        // In toàn bộ kết quả một lần duy nhất để tối ưu I/O
        System.out.print(sb);
    }
}
    }
}