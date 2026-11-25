import java.util.*;

public class b1 {
    static int n;
    static int k;
    static int[] a;
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;


        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = sc.nextInt();

        }

        Arrays.sort(a);

        List<Integer> currentSubset = new ArrayList<>();
        System.out.println(count);

        sc.close();


    }

        
}



