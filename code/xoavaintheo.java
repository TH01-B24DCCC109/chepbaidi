import java.util.Scanner;

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
    Node First; // Con trỏ First quản lý danh sách

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

    // Hàm xóa tất cả các phần tử có giá trị bằng x và trả về số lượng phần tử đã xóa
    public int removeAllX(int x) {
        int count = 0;

        // Xóa các nút ở đầu danh sách nếu chúng có giá trị bằng x
        while (First != null && First.data == x) {
            First = First.next;
            count++;
        }

        // Xóa các nút còn lại trong danh sách
        Node current = First;
        while (current != null && current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next; // Bỏ qua nút có giá trị x
                count++;
            } else {
                current = current.next;
            }
        }

        return count;
    }

    // Hàm in các phần tử còn lại trong danh sách[cite: 1]
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

        // 2. Nhập n phần tử của danh sách
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.append(value);
        }

        // 3. Nhập giá trị x cần xóa
        int x = scanner.nextInt();

        // Thực hiện xóa x và nhận số lượng đã xóa[cite: 1]
        int deletedCount = list.removeAllX(x);

        // In ra các phần tử còn lại trong danh sách[cite: 1]
        list.printList();
        
        scanner.close();
    }
}