import java.util.Scanner;

public class Main {

    // Hàm tìm hoán vị kế tiếp của mảng ký tự
    public static boolean nextPermutation(char[] s) {
        int n = s.length;
        
        // Bước 1: Tìm vị trí i đầu tiên từ phải sang trái sao cho s[i] < s[i + 1]
        int i = n - 2;
        while (i >= 0 && s[i] >= s[i + 1]) {
            i--;
        }

        // Nếu không tìm thấy, nghĩa là dãy đã là lớn nhất (ví dụ: 987)
        if (i < 0) {
            return false;
        }

        // Bước 2: Tìm vị trí j từ phải sang trái sao cho s[j] > s[i]
        int j = n - 1;
        while (s[j] <= s[i]) {
            j--;
        }

        // Bước 3: Đổi chỗ s[i] và s[j]
        swap(s, i, j);

        // Bước 4: Đảo ngược đoạn từ i + 1 đến hết chuỗi
        reverse(s, i + 1, n - 1);

        return true;
    }

    // Đổi chỗ 2 phần tử
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    // Đảo ngược mảng từ vị trí left đến right
    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int t = sc.nextInt();
        while (t-- > 0) {
            int testId = sc.nextInt();
            String str = sc.next();

            char[] digits = str.toCharArray();

            if (nextPermutation(digits)) {
                System.out.println(testId + " " + new String(digits));
            } else {
                System.out.println(testId + " BIGGEST");
            }
        }
        sc.close();
    }
}