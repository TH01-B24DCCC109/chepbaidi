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
            String s = reader.readLine();
            if (s == null) break;
            
            Stack<Integer> st = new Stack<>();
            st.push(-1);
            int maxLen = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(i);
                } else {
                    st.pop();
                    if (st.isEmpty()) {
                        st.push(i);
                    } else {
                        maxLen = Math.max(maxLen, i - st.peek());
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
}