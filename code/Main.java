import java.util.Scanner;


public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- >0) {
            long n = sc.nextLong();

            long s = n * (n+1) / 2;

            System.out.println(s);
        }
        
        sc.close();
    }
}