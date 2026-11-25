import java.util.Scanner;

public class soklienke {
    public static boolean check(String n) {

        int sum = 0;

        // Kiểm tra tổng chữ số
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        if (sum % 10 != 0) {
            return false;
        }

        // Kiểm tra các chữ số cạnh nhau
        for (int i = 0; i < n.length() - 1; i++) {

            int a = n.charAt(i) - '0';
            int b = n.charAt(i + 1) - '0';

            if (Math.abs(a - b) != 2) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            String n = sc.next();

            if (check(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
