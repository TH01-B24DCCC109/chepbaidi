import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] A;
    static int result = 0;

    public static void tryBacktrack(int startIndex, int count, int lastValue) {
        // Nếu đã chọn đủ K phần tử
        if (count == K) {
            result++;
            return;
        }

        // Duyệt các phần tử tiếp theo
        for (int j = startIndex; j < N; j++) {
            if (A[j] > lastValue) {
                tryBacktrack(j + 1, count + 1, A[j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
            K = scanner.nextInt();

            A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            // Gọi đệ quy quay lui từ chỉ số 0, đã chọn 0 phần tử, giá trị trước đó = -1
            tryBacktrack(0, 0, -1);

            System.out.println(result);
        }
        scanner.close();
    }
}