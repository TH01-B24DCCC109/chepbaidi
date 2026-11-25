import java.util.Scanner;

public class catdoi {
    public static String cutNumber(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0' || c == '1') {
                result.append(c);
            } 
            else if (c == '8' || c == '9') {
                result.append('0');
            } 
            else {
                return "INVALID";
            }
        }

        // Xóa số 0 ở đầu
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Nếu toàn số 0 hoặc rỗng
        if (result.length() == 0) {
            return "INVALID";
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            System.out.println(cutNumber(s));
        }

        sc.close();
    }
    
}
