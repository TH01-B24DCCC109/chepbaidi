import java.util.*;

class Main {

    static boolean match(String pattern, int x) {
        String s = Integer.toString(x);
        for (int i = 0; i < 2; i++) {
            if (pattern.charAt(i) != '?' && pattern.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }

    static ArrayList<Integer> generate(String pattern) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 10; i <= 99; i++) {
            if (match(pattern, i))
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String A = sc.next();
            String op = sc.next();
            String B = sc.next();
            sc.next(); // =
            String C = sc.next();

            ArrayList<Integer> la = generate(A);
            ArrayList<Integer> lb = generate(B);
            ArrayList<Integer> lc = generate(C);

            char[] ops;
            if (op.equals("?"))
                ops = new char[]{'+', '-', '*', '/'};
            else
                ops = new char[]{op.charAt(0)};

            boolean found = false;

            outer:
            for (char o : ops) {
                for (int a : la) {
                    for (int b : lb) {
                        for (int c : lc) {

                            boolean ok = false;

                            if (o == '+') ok = (a + b == c);
                            else if (o == '-') ok = (a - b == c);
                            else if (o == '*') ok = (a * b == c);
                            else if (o == '/') {
                                ok = (b != 0 && a % b == 0 && a / b == c);
                            }

                            if (ok) {
                                System.out.println(a + " " + o + " " + b + " = " + c);
                                found = true;
                                break outer;
                            }
                        }
                    }
                }
            }

            if (!found)
                System.out.println("WRONG PROBLEM!");
        }
    }
}