import java.util.Scanner;

public class solienke {
    public static boolean check(String n) {

        for (int i = 0; i < n.length() - 1; i++) {

            int a = n.charAt(i) - '0';
            int b = n.charAt(i + 1) - '0';

            if (Math.abs(a - b) != 1) {
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
