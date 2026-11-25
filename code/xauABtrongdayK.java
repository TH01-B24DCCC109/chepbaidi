import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, K;
    static List<String> result = new ArrayList<>();

    // Hàm kiểm tra xâu s có chứa DUY NHẤT một dãy K ký tự 'A' liên tiếp hay không
    static boolean check(String s) {
        int countK = 0;    // Đếm số đoạn A liên tiếp có độ dài đúng bằng K
        int currentLen = 0; // Độ dài đoạn A liên tiếp đang xét

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'A') {
                currentLen++;
            } else {
                if (currentLen == K) {
                    countK++;
                } else if (currentLen > K) {
                    return false; // Có đoạn 'A' dài hơn K => Không thỏa mãn
                }
                currentLen = 0;
            }
        }

        // Kiểm tra đoạn 'A' ở cuối xâu
        if (currentLen == K) {
            countK++;
        } else if (currentLen > K) {
            return false;
        }

        return countK == 1;
    }

    // Hàm quay lui sinh xâu AB
    static void Try(String s) {
        if (s.length() == N) {
            if (check(s)) {
                result.add(s);
            }
            return;
        }

        // Thử thêm 'A' trước để đảm bảo thứ tự từ điển
        Try(s + 'A');
        // Thử thêm 'B'
        Try(s + 'B');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            N = sc.nextInt();
            K = sc.nextInt();

            Try("");

            // In kết quả
            System.out.println(result.size());
            for (String s : result) {
                System.out.println(s);
            }
        }
        sc.close();
    }
}