import java.util.Scanner;

public class sodep2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            boolean ok = true;

            // Kiểm tra bắt đầu và kết thúc bằng 8
            if (s.charAt(0) != '8' || s.charAt(s.length() - 1) != '8') {
                ok = false;
            }

            // Kiểm tra số thuận nghịch
            if (ok) {
                int left = 0;
                int right = s.length() - 1;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        ok = false;
                        break;
                    }
                    left++;
                    right--;
                }
            }

            // Kiểm tra tổng chữ số chia hết cho 10
            if (ok) {
                int sum = 0;

                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i) - '0';
                }

                if (sum % 10 != 0) {
                    ok = false;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}