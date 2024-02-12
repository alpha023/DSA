public class MyQueueExample {
    public static void main(String[] args) {

        MyQueue q1=new MyQueue();

        q1.enqueue(98);
        q1.enqueue(23);
        q1.enqueue(71);

        System.out.println(q1.seekFront());
        q1.dequeue();
        System.out.println(q1.seekFront());

        q1.enqueue(101);
        System.out.println(q1.seekFront());

        q1.dequeue(); q1.dequeue();
        System.out.println(q1.seekFront());

        q1.enqueue(0);
        System.out.println(q1.seekFront());


    }
}

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