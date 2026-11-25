import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static String solve(String s) {
        // 1. Loại bỏ khoảng trắng thừa
        s = s.replaceAll("\\s+", "");

        boolean changed = true;
        while (changed) {
            changed = false;
            int n = s.length();
            int[] pair = new int[n];
            Arrays.fill(pair, -1);
            Stack<Integer> st = new Stack<>();

            // Tìm các cặp ngoặc ứng với nhau
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    st.push(i);
                } else if (s.charAt(i) == ')') {
                    if (!st.isEmpty()) {
                        int open = st.pop();
                        pair[open] = i;
                    }
                }
            }

            boolean[] remove = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(' && pair[i] != -1) {
                    int l = i;
                    int r = pair[i];

                    // Trường hợp 1: Ngoặc bao quanh đúng 1 biến duy nhất, ví dụ (A)
                    if (r == l + 2 && Character.isUpperCase(s.charAt(l + 1))) {
                        remove[l] = true;
                        remove[r] = true;
                        changed = true;
                        continue;
                    }

                    // Trường hợp 2: Ngoặc ở đầu biểu thức hoặc sau dấu '+'
                    if (l == 0 || s.charAt(l - 1) == '+') {
                        remove[l] = true;
                        remove[r] = true;
                        changed = true;
                        continue;
                    }

                    // Trường hợp 3: Ngoặc đứng ngay sau ngoặc '(' khác
                    if (l > 0 && s.charAt(l - 1) == '(') {
                        remove[l] = true;
                        remove[r] = true;
                        changed = true;
                        continue;
                    }

                    // Trường hợp 4: Ngoặc bao toàn bộ biểu thức
                    if (l == 0 && r == n - 1) {
                        remove[l] = true;
                        remove[r] = true;
                        changed = true;
                        continue;
                    }
                }
            }

            // Dựng lại chuỗi sau khi đánh dấu xóa ngoặc thừa
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!remove[i]) {
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int M = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc M

        while (M-- > 0) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.trim().isEmpty()) {
                    System.out.println(solve(line));
                }
            }
        }
        sc.close();
    }
}