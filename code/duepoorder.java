import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static class Node {
        int val;
        Node left, right;
        Node(int x) {
            val = x;
            left = right = null;
        }
    }

    // Hàm xây dựng cây nhị phân tìm kiếm cân bằng từ mảng đã được sắp xếp
    static Node buildBalancedBST(int[] a, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        Node root = new Node(a[mid]);
        root.left = buildBalancedBST(a, left, mid - 1);
        root.right = buildBalancedBST(a, mid + 1, right);
        return root;
    }

    // Phép duyệt Post-order (Trái - Phải - Gốc)
    static void postOrder(Node root, StringBuilder sb) {
        if (root == null) return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val).append(" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        StringBuilder output = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            // Sắp xếp mảng để tạo cây nhị phân tìm kiếm cân bằng
            Arrays.sort(a);

            Node root = buildBalancedBST(a, 0, n - 1);
            postOrder(root, output);
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}