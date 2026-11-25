import java.util.Scanner;


public class fibonnaci {
    public static long fibonacci(int n) {
        if (n ==1 || n ==2 ) {
            return 1;
        }

        long f1 =1 ;
        long f2 =1;
        long fn =0;

        for(int i= 3; i<=n;i++) {
            fn= f1  + f2;
            f1= f2;
            f2= fn;
        }
        return fn; 

    }
    

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        while (t-- >0) {
            int n = sc.nextInt();
            System.out.println(fibonacci(n));
            
        }
        sc.close();
    }
   
}
