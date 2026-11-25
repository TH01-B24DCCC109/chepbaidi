import java.util.Scanner;

public class sodep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            boolean ok = true;

            // Kiểm tra chỉ chứa chữ số chẵn
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c != '0' && c != '2' && c != '4'
                        && c != '6' && c != '8') {
                    ok = false;
                    break;
                }
            }

            // Kiểm tra thuận nghịch
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