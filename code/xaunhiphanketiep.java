import java.util.Scanner;

public class XauNhiPhanKeTiep {

  
    public static String nextBinaryString(String s) {
        char[] bits = s.toCharArray();
        int n = bits.length;
        int i = n - 1;

       
        while (i >= 0 && bits[i] == '1') {
            bits[i] = '0';
            i--;
        }

       
        if (i >= 0) {
            bits[i] = '1';
        }
       
        return new String(bits);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int t = sc.nextInt(); 
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(nextBinaryString(s));
        }
        sc.close();
    }
}