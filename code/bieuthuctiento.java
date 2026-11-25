import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            String exprLine = reader.readLine();
            if (exprLine == null) break;
            
            String[] tokens = exprLine.trim().split("\\s+");
            Stack<Long> st = new Stack<>();
            
            // Duyệt từ phải sang trái đối với biểu thức tiền tố
            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    long op1 = st.pop();
                    long op2 = st.pop();
                    long res = 0;
                    if (token.equals("+")) {
                        res = op1 + op2;
                    } else if (token.equals("-")) {
                        res = op1 - op2;
                    } else if (token.equals("*")) {
                        res = op1 * op2;
                    } else if (token.equals("/")) {
                        res = op1 / op2;
                    }
                    st.push(res);
                } else {
                    // Là toán hạng (có thể là số âm)
                    st.push(Long.parseLong(token));
                }
            }
            System.out.println(st.peek());
        }
    }
}