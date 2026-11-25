import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int start;
    int finish;

    Job(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class Main {
    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
        }

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(s[i], f[i]);
        }

        // Sắp xếp theo thời gian kết thúc tăng dần
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return Integer.compare(a.finish, b.finish);
            }
        });

        int count = 1;
        int lastFinish = jobs[0].finish;

        for (int i = 1; i < n; i++) {
            if (jobs[i].start >= lastFinish) {
                count++;
                lastFinish = jobs[i].finish;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }
}  