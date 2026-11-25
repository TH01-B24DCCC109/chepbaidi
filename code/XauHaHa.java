import java.util.Scanner;

public class XauHAHA {
    static int n;
    static char[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new char[n];
            // Ký tự đầu bắt buộc là 'H'
            a[0] = 'H';
            // Thử các ký tự tiếp theo từ vị trí 1
            Try(1);
        }
        sc.close();
    }

    static void Try(int i) {
        // Duyệt theo thứ tự từ điển: 'A' trước, 'H' sau
        char[] options = {'A', 'H'};
        for (char c : options) {
            // Không được có hai chữ 'H' đứng cạnh nhau
            if (c == 'H' && a[i - 1] == 'H') {
                continue;
            }
            a[i] = c;

            if (i == n - 1) {
                // Ký tự cuối cùng phải là 'A'
                if (a[n - 1] == 'A') {
                    System.out.println(new String(a));
                }
            } else {
                Try(i + 1);
            }
        }
    }
}