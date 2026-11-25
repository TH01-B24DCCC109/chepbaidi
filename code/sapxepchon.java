import java.util.Scanner;

public class sapxepchon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            // Tìm phần tử nhỏ nhất
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            // Đổi chỗ
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;

            // In bước thực hiện
            System.out.print("Buoc " + (i + 1) + ": ");

            for (int j = 0; j < n; j++) {
                System.out.print(a[j]);

                if (j < n - 1)
                    System.out.print(" ");
            }

            System.out.println();
        }

        sc.close();
    }
}