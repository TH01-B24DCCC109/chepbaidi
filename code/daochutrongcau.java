import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            String s = reader.readLine();
            if (s == null) break;
            
            // Tách xâu thành các từ dựa trên khoảng trắng
            String[] words = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            
            // Duyệt từ cuối về đầu để đảo ngược thứ tự từ
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}