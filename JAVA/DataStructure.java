public class DataStructure {
    public static void main(String[] args) {

    }
}


//==================================================================================================================
//==========================================MY LINKED LIST==========================================================
//==================================================================================================================
class MyLinkedList {
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

    MyLinkedList() {

    }

    MyLinkedList(int[] elements) {

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
        if (this.ROOT == null)
            return;
        if (this.ROOT.next == null) {
            this.insertAtEnd(this.ROOT.data);
            return;
        }
        Node temp = this.ROOT;
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


//==================================================================================================================
//============================================MY QUEUE==============================================================
//==================================================================================================================
class MyQueue {
    private Node ROOT;

    void enqueue(int key) {
        Node newNode = new Node(key);
        if (this.ROOT == null) {
            this.ROOT = newNode;
            return;
        }

        Node temp = this.ROOT;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;

    }

    int dequeue() {
        if (this.ROOT == null)
            return -1;
        if (this.ROOT.next == null) {
            int elm = this.ROOT.data;
            this.ROOT = null;
            return elm;
        }

        int key = this.ROOT.data;
        this.ROOT = this.ROOT.next;

        return key;
    }

    int seekFront(){
        if(this.ROOT==null)return -1;
        return this.ROOT.data;
    }

    class Node {
        int data;
        Node next;

        Node(int key) {
            this.data = key;
            this.next = null;
        }
    }

}


//==================================================================================================================
//==============================================MY SET==============================================================
//==================================================================================================================
class MySet {

    private Node ROOT;

    MySet(int[] set) {
        for (int i = 0; i < set.length; i++) {
            this.insert(set[i]);
        }
    }

    MySet() {

    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert Operation
    void insert(int key) {
        if (this.ROOT == null)
            this.ROOT = new Node(key);

        if (this.isContain(key))
            return;

        Node temp = this.ROOT;
        this.ROOT = new Node(key);
        this.ROOT.next = temp;

    }

    // TRAVERSE THE SET
    // Traverse The Linked List
    void traverse() {
        if (ROOT == null)
            return;
        Node temp = ROOT;
        System.out.println();
        System.out.print("{ ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next == null ? " " : " , "));
            temp = temp.next;
        }
        System.out.print(" }");
    }

    // INTERSECTION OPERATION
    MySet intersection(MySet set2) {
        MySet ans = new MySet();
        if (set2.ROOT == null || this.ROOT == null)
            return ans;

        Node temp = this.ROOT;
        while (temp != null) {
            if (set2.isContain(temp.data))
                ans.insert(temp.data);
            temp = temp.next;
        }
        return ans;

    }

    // UNION OPERATION
    MySet union(MySet set2) {

        MySet ans = new MySet();
        if (this.ROOT == null) {
            ans.appendSet(set2);
            return ans;
        }

        if (set2.ROOT == null) {
            ans.appendSet(this);
            return ans;
        }

        Node temp1 = this.ROOT;
        Node temp2 = set2.ROOT;
        while (temp1 != null) {

            ans.insert(temp1.data);
            temp1 = temp1.next;

        }
        while (temp2 != null) {

            ans.insert(temp2.data);
            temp2 = temp2.next;

        }
        return ans;

    }

    // Minus operation
    MySet minus(MySet B) {
        MySet ans = new MySet();
        if (this.ROOT == null)
            return ans;
        if (B.ROOT == null) {
            ans.appendSet(this);

        }
        Node temp = this.ROOT;
        while (temp != null) {
            if (!B.isContain(temp.data)) {
                ans.insert(temp.data);
            }
            temp = temp.next;
        }
        return ans;
    }

    // append set
    private void appendSet(MySet set2) {
        if (set2.ROOT == null)
            return;
        Node temp = set2.ROOT;
        while (temp != null) {
            this.insert(temp.data);
            temp = temp.next;
        }

    }

    // Length Of Linked List
    int length() {
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

    // DELETE OPERATION
    void delete(int key) {
        if (this.ROOT == null)
            return;
        if (this.ROOT.next == null)
            if (this.ROOT.data == key)
                this.ROOT = null;
        if (this.ROOT.data == key)
            this.ROOT = this.ROOT.next;
        Node temp = this.ROOT;
        Node prev = null;
        while (temp != null) {
            if (temp.data == key) {

                prev.next = temp.next;

            }
            prev = temp;
            temp = temp.next;
        }
    }

    // is Contain Operation
    boolean isContain(int key) {
        if (this.ROOT == null)
            return false;
        if (this.ROOT.next == null)
            return this.ROOT.data == key;

        Node temp = this.ROOT;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }

        return false;

    }

    // Set Difference Operator
    MySet delta(MySet B) {

        return this.minus(B).union(B.minus(this));

    }

}
//==================================================================================================================
//========================================MY STACK EXAMPLE==========================================================
//==================================================================================================================

class MyStack {
    private Node ROOT;
    private int top;

    class Node {
        int data;
        Node next;

        Node(int key) {

            this.data = key;
            this.next = null;

        }
    }

    void push(int key){
        Node temp=new Node(key);
        if(this.ROOT==null){
            this.ROOT=temp;
        }
        temp.next=this.ROOT;
        this.ROOT=temp;
        this.top=this.ROOT.data;
    }

    int pop(){
        if(this.ROOT==null)return -1;
        int data=this.ROOT.data;
        this.ROOT=this.ROOT.next;
        this.top=this.ROOT.data;
        return data;
    }

    int seekTop(){
        if(this.ROOT==null)return -1;
        return this.top;
    }
}