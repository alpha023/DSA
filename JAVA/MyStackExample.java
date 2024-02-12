public class MyStackExample {

    public static void main(String args[]){
        MyStack stk=new MyStack();
        stk.push(23);
        stk.push(8);

        System.out.println(stk.seekTop());
        stk.pop();
        System.out.println(stk.seekTop());

        stk.push(10);
        stk.push(99);
        stk.push(78);

        System.out.println(stk.seekTop());
        stk.pop();
        stk.pop();

        System.out.println(stk.seekTop());
    }

    

}

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