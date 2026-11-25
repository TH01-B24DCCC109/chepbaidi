import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            String[] tokens = new String[n];
            for (int i = 0; i < n; i++) {
                tokens[i] = sc.next();
            }

            Stack<Long> st = new Stack<>();

            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    long b = st.pop();
                    long a = st.pop();
                    long res = 0;
                    if (token.equals("+")) {
                        res = a + b;
                    } else if (token.equals("-")) {
                        res = a - b;
                    } else if (token.equals("*")) {
                        res = a * b;
                    } else if (token.equals("/")) {
                        res = a / b;
                    }
                    st.push(res);
                } else {
                    // Là toán hạng (có thể là số âm hoặc nhiều chữ số)
                    st.push(Long.parseLong(token));
                }
            }

            System.out.println(st.peek());
        }
        sc.close();
    }
}