public class MyLinkedListExample {
    public static void main(String[] args) {
        
    }

    private Node ROOT;

    class Node {
        int data;
        Node next;

        Node(int key) {

            this.data = key;
            this.next = null;

        }

        Node() {

        }
    }

    MyLinkedListExample() {

    }

    MyLinkedListExample(int[] elements) {

        for (int i = 0; i < elements.length; i++) {
            this.insertAtEnd(elements[i]);
        }

    }

    // Insert At First
    public void insertAtBegin(int value) {
        if (this.ROOT == null) {

            this.ROOT = createNode(value);

        } else {
            Node temp = this.ROOT;
            this.ROOT = createNode(value);
            this.ROOT.next = temp;
        }
    }

    // Insert At End
    public void insertAtEnd(int key) {
        if (this.ROOT == null) {
            this.ROOT = createNode(key);
            return;
        }
        Node temp = this.ROOT;
        while (temp.next != null)
            temp = temp.next;
        temp.next = createNode(key);
    }

    // INSERT AT INDEX :--:.
    public void insertAt(int pos, int value) {
        if (this.ROOT == null)
            return;
        Node temp = ROOT;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        Node nextChain = temp.next;
        temp.next = createNode(value);
        temp.next.next = nextChain;
    }

    // Return element at Index
    public int elementAt(int idx) {
        if (this.ROOT == null)
            return -1;
        Node temp = this.ROOT;
        for (int i = 0; i < idx; i++)
            temp = temp.next;
        return temp.data;
    }

    // Length Of Linked List
    public int length() {
        if (this.ROOT == null)
            return 0;
        int count = 0;
        Node temp = this.ROOT;
        while (temp != null) {
            count++;
            temp = temp.next;

        }
        return count;
    }

    // is contains a key value
    public boolean isContain(int key) {
        if (this.ROOT == null)
            return false;
        Node temp = this.ROOT;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Traverse The Linked List
    public void traverse() {
        if (ROOT == null)
            return;
        Node temp = ROOT;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    // Seek first Element
    public int seekTop() {
        if (this.ROOT == null)
            return -1;
        return this.ROOT.data;
    }

    // Seek Last Element
    public int seekLast() {
        if (this.ROOT == null)
            return -1;
        Node temp = this.ROOT;
        while (temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    // multiply the Linked List
    public void multiplyInplaceBy(int n) {
        if (ROOT == null)
            return;
        Node temp = this.ROOT;
        while (temp != null) {
            temp.data = temp.data * n;
            temp = temp.next;
        }
    }

    // multiply and return Root
    public MyLinkedListExample multiplyNotInplaceBy(int n) {
        if (this.ROOT == null)
            return null;
        MyLinkedListExample root = new MyLinkedListExample();
        Node temp = this.ROOT;
        while (temp != null) {
            root.insertAtEnd(temp.data);
            temp = temp.next;
        }

        root.multiplyInplaceBy(n);
        return root;

    }

    // sum of elements of the linked list
    public int sum() {
        if (this.ROOT == null)
            return 0;
        int sum = 0;
        Node temp = ROOT;
        while (temp != null) {
            sum = sum + temp.data;
            temp = temp.next;
        }
        return sum;
    }

    // DELETE : OPERATIONS
    public int deleteFirst() {
        if (this.ROOT == null)
            return -1;
        Node temp = this.ROOT;
        this.ROOT = this.ROOT.next;
        temp.next = null;

        return temp.data;

    }

    // Delete Last Element
    public int deleteLast() {
        if (this.ROOT == null)
            return -1;
        if (this.ROOT.next == null) {
            int key = this.ROOT.data;
            this.ROOT = null;
            return key;
        }
        Node temp = this.ROOT;
        while (temp.next.next != null)
            temp = temp.next;
        int key = temp.data;
        temp.next = null;
        return key;
    }

    // Delete From Position
    public int delete(int pos) {
        if (this.ROOT == null)
            return -1;
        if (pos == 0)
            return deleteFirst();
        if (pos == this.length() - 1)
            return deleteLast();

        Node temp = this.ROOT;
        for (int i = 0; i < pos; i++)
            temp = temp.next;

        Node nextNode = temp.next.next;
        int key = temp.next.data;
        temp.next = nextNode;
        return key;

    }

    // append new linked list
    public void append(MyLinkedListExample root) {
        if (root.ROOT == null)
            return;
        if (root.ROOT.next == null) {
            this.insertAtEnd(root.ROOT.data);
            return;
        }
        Node temp = root.ROOT;
        while (temp != null) {
            this.insertAtEnd(temp.data);
            temp = temp.next;
        }
    }

    // Reverse The Linked List
    public void reverseInplace() {
        if (this.ROOT == null)
            return;

    }

    // Create a new Node
    public Node createNode(int key) {
        return new Node(key);
    }
}
