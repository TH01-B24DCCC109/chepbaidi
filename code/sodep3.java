import java.util.Scanner;

public class sodep3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            boolean ok = true;

            // Kiểm tra chỉ chứa chữ số nguyên tố
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c != '2' && c != '3' && c != '5' && c != '7') {
                    ok = false;
                    break;
                }
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

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}