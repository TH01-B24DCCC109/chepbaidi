import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Lớp đại diện cho một nút (Node) trong danh sách liên kết đơn
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Lớp quản lý Danh sách liên kết đơn
class LinkedList {
    Node First; // Con trỏ First quản lý danh sách[cite: 2]

    public LinkedList() {
        this.First = null;
    }

    // Hàm thêm nút vào cuối danh sách
    public void append(int data) {
        Node newNode = new Node(data);
        if (First == null) {
            First = newNode;
            return;
        }
        Node temp = First;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Hàm lọc tất cả các phần tử trùng nhau, giữ lại 1 đại diện[cite: 2]
    public void removeDuplicates() {
        if (First == null) return;

        Set<Integer> seen = new HashSet<>();
        Node current = First;
        
        // Phần tử đầu tiên luôn được giữ lại
        seen.add(current.data);

        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                // Đã xuất hiện trước đó -> xóa nút trùng bằng cách bỏ qua nó
                current.next = current.next.next;
            } else {
                // Chưa xuất hiện -> ghi nhận vào HashSet và chuyển sang nút tiếp theo
                seen.add(current.next.data);
                current = current.next;
            }
        }
    }

    // Hàm in các phần tử còn lại trong danh sách[cite: 2]
    public void printList() {
        Node temp = First;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        // 1. Nhập số lượng phần tử
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // 2. Nhập n phần tử của danh sách[cite: 2]
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.append(value);
        }

        // 3. Lọc danh sách loại bỏ trùng[cite: 2]
        list.removeDuplicates();

        // 4. In ra các phần tử còn lại trong danh sách[cite: 2]
        list.printList();

        scanner.close();
    }
}