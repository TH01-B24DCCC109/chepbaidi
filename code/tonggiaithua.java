import java.util.Scanner;

public class tonggiaithua {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long sum = 0;
        long product = 1;

        for (int i = 1; i <= n; i++) {
            product *= i;
            sum += product;
        }

        System.out.println(sum);

        sc.close();
    }
}
