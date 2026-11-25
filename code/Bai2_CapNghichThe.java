import java.io.*;
import java.util.StringTokenizer;

public class Bai2_CapNghichThe {
    static long countInversions;

    static void merge(long[] arr, int left, int mid, int right, long[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Mọi phần tử từ i đến mid đều lớn hơn arr[j]
                countInversions += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    static void mergeSort(long[] arr, int left, int right, long[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int n = Integer.parseInt(st.nextToken());

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    line = br.readLine();
                    st = new StringTokenizer(line);
                }
                a[i] = Long.parseLong(st.nextToken());
            }

            countInversions = 0;
            long[] temp = new long[n];
            mergeSort(a, 0, n - 1, temp);

            sb.append(countInversions).append("\n");
        }
        System.out.print(sb);
    }
}