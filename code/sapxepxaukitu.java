import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void solve(Scanner sc) {
        String s = sc.next();
        int n = s.length();
        
        // Đếm tần suất xuất hiện của từng ký tự
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));
        }
        
        // Kiểm tra điều kiện: maxFreq <= (n + 1) / 2
        if (maxFreq <= (n + 1) / 2) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}