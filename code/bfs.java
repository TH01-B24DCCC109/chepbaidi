import java.util.*;

public class Main {

    // Kiểm tra biểu thức có hợp lệ hay không
    private static boolean isValid(String s) {
        int openCount = 0;
        boolean hasParentheses = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                hasParentheses = true;
            } else if (c == ')') {
                openCount--;
                hasParentheses = true;
                if (openCount < 0) return false;
            }
        }

        // Biểu thức phải cân bằng và phải chứa ít nhất 1 cặp ngoặc
        return openCount == 0 && hasParentheses;
    }

    private static void solve(Scanner sc) {
        String s = sc.next();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (isValid(curr)) {
                    result.add(curr);
                    found = true;
                }

                if (found) continue;

                // Sinh các chuỗi con bằng cách loại bỏ 1 ký tự '(' hoặc ')'
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if (c == '(' || c == ')') {
                        String nextStr = curr.substring(0, j) + curr.substring(j + 1);
                        if (!visited.contains(nextStr)) {
                            visited.add(nextStr);
                            queue.add(nextStr);
                        }
                    }
                }
            }

            if (found) break;
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            // Sắp xếp các kết quả theo thứ tự từ điển
            Collections.sort(result);
            System.out.println(String.join(" ", result));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Đã dùng đúng System.in
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}