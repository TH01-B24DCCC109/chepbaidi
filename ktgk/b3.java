import java.util.Scanner;

public class b3 {
    static int n,k ;
    static int a[] = new int[105];
    static int dem = 0;
    
    static void  Try(int start, int pos, int last){
        if (pos ==k) {
            dem ++;
            return;
        }      
        for (int = start;i < n;i++){
            if (pos ==0 || a[i]> last){
                Try(i +1, pos +1, ;last +1);
            }

        }

    }
    
    public void main (String[] args){
        Scanner sc = new Scanner(null)
    }
    
}
