import java.util.Scanner;

public class sapxepchen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // In bước 0
        System.out.print("Buoc 0: " + a[0]);
        System.out.println();

        // Sắp xếp chèn
        for (int i = 1; i < n; i++) {
            int x = a[i];
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn x sang phải
            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }

            // Chèn x vào vị trí đúng
            a[j + 1] = x;

            // In kết quả bước i
            System.out.print("Buoc " + i + ": ");
            for (int k = 0; k <= i; k++) {
                System.out.print(a[k]);
                if (k < i)
                    System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}