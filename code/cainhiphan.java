import java.util.Scanner;

public class Main {
    static class Node {
        int val;
        Node left, right;
        Node(int x) {
            val = x;
            left = right = null;
        }
    }

    static Node buildTree(int[] a, int i, int n) {
        if (i >= n) return null;
        Node root = new Node(a[i]);
        root.left = buildTree(a, 2 * i + 1, n);
        root.right = buildTree(a, 2 * i + 2, n);
        return root;
    }

    static void inorder(Node root, StringBuilder sb) {
        if (root == null) return;
        inorder(root.left, sb);
        sb.append(root.val).append(" ");
        inorder(root.right, sb);
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

            Node root = buildTree(a, 0, n);
            inorder(root, output);
            output.append("\n");
        }
        System.out.print(output.toString());
    }
}