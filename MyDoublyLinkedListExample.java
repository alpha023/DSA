public class MyDoublyLinkedListExample {

    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList();
        dll.insertAtBegin(56);
        dll.insertAtBegin(89);
        dll.insertAtEnd(89);
        dll.insertAt(2, 99);

        dll.insertAt(1, 101);

        dll.traverse();
    }

}

class MyDoublyLinkedList {
    Node ROOT;

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // ADD ELEMENT TO FRONT
    void insertAtBegin(int key) {
        Node temp = new Node(key);
        if (this.ROOT == null) {
            this.ROOT = temp;
            return;
        }
        this.ROOT.prev = temp;
        temp.next = this.ROOT;
        this.ROOT = temp;
    }

    // ADD ELEMENT TO FRONT
    void insertAtEnd(int key) {
        Node newNode = new Node(key);
        if (this.ROOT == null) {
            this.ROOT = newNode;
            return;
        }

        Node temp = this.ROOT;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;

    }

    // TRAVERSE ELEMENT
    void traverse() {
        if (this.ROOT == null)
            return;
        Node temp = this.ROOT;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    // INSERT ELEMENT AT INDEX pos
    void insertAt(int pos, int key) {
        if (this.ROOT == null)
            this.insertAtBegin(key);
        if (pos == 0)
            this.insertAtBegin(key);
        if (pos == this.length() - 1)
            this.insertAtEnd(key);
        Node newNode=new Node(key);
        Node temp = this.ROOT;
        for (int i = pos - 1; i > 0; i--) {
            temp = temp.next;

        }

        newNode.next=temp.next;
        temp.next.prev=newNode;
        newNode.prev=temp;
        temp.next=newNode;




    }

    // LENGTH OF DOUBLY LINKED LIST
    int length() {
        if (this.ROOT == null)
            return -1;
        Node temp = this.ROOT;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

}