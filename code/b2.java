import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class b2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Hello.txt");

        Scanner sc = new java.util.Scanner(f);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());

            
        }
        
        sc.close();
    }
    
}
