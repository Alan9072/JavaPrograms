class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a node at the end of the doubly linked list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
public void delete(int data) {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    Node current = head;
    while (current != null) {
        if (current.data == data) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            return;
        }
        current = current.next;
    }
    System.out.println("Element not found in the list");
}

    // Method to display the doubly linked list
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1);
        dll.insertEnd(2);
        dll.insertEnd(3);
        dll.insertEnd(4);
        dll.display();
    }
}