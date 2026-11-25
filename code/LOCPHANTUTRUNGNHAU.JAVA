import java.util.HashSet;
import java.util.Scanner;

// Khai báo cấu trúc một Node trong Danh sách liên kết đơn
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    // Hàm lọc các phần tử trùng nhau trong DSLK First
    public static Node removeDuplicates(Node First) {
        if (First == null) return null;

        HashSet<Integer> visited = new HashSet<>();
        Node current = First;
        Node prev = null;

        while (current != null) {
            // Nếu giá trị đã xuất hiện trước đó -> xóa nút current
            if (visited.contains(current.data)) {
                prev.next = current.next;
            } else { // Nếu chưa xuất hiện -> lưu giá trị và tiến con trỏ prev
                visited.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return First;
    }

    // Hàm in các phần tử trong danh sách liên kết
    public static void printList(Node First) {
        Node temp = First;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt(); // Số lượng phần tử trong danh sách

        Node First = null;
        Node last = null;

        // Đọc dữ liệu và xây dựng Danh sách liên kết đơn
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node newNode = new Node(val);
            if (First == null) {
                First = newNode;
                last = First;
            } else {
                last.next = newNode;
                last = newNode;
            }
        }

        // Thực hiện lọc trùng
        First = removeDuplicates(First);

        // In danh sách sau khi lọc
        printList(First);

        sc.close();
    }
}