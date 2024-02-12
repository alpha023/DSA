public class MySetExample {

    public static void main(String[] args) {
        MySet A = new MySet(new int[] { 1, 4, 4, 5, 5, 9 });
        MySet B = new MySet(new int[] { 1, 6, 10, 5, 5, 3 });

        // A.delta(B).traverse();
        A.traverse();
        B.traverse();
        A.intersection(B).traverse();
        
        // C.traverse();

        A.delta(B).traverse();
    }

}

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

// class MySampleSpace {
//     private Node SAMPLESPACEROOT;

//     MySampleSpace(int[] arr){

//     }

//     class Node {
//         Node next;
//         int data;

//         Node() {

//         }

//         Node(int key) {
//             this.next=null;
//             this.data=key;
//         }
//     }

//     class MySet {

//         private Node ROOT;
        
    
//         MySet(int[] set) {
//             for (int i = 0; i < set.length; i++) {
//                 this.insert(set[i]);
//             }
//         }
    
//         MySet() {
    
//         }

        
    
//         private class Node {
//             int data;
//             Node next;
    
//             Node(int data) {
//                 this.data = data;
//                 this.next = null;
//             }
//         }
    
//         // Insert Operation
//         void insert(int key) {
//             if (this.ROOT == null)
//                 this.ROOT = new Node(key);
    
//             if (this.isContain(key))
//                 return;
    
//             Node temp = this.ROOT;
//             this.ROOT = new Node(key);
//             this.ROOT.next = temp;
    
//         }
    
//         // TRAVERSE THE SET
//         // Traverse The Linked List
//         void traverse() {
//             if (ROOT == null)
//                 return;
//             Node temp = ROOT;
//             System.out.println();
//             System.out.print("{ ");
//             while (temp != null) {
//                 System.out.print(temp.data + (temp.next == null ? " " : " , "));
//                 temp = temp.next;
//             }
//             System.out.print(" }");
//         }
    
//         // INTERSECTION OPERATION
//         MySet intersection(MySet set2) {
//             MySet ans = new MySet();
//             if (set2.ROOT == null || this.ROOT == null)
//                 return ans;
    
//             Node temp = this.ROOT;
//             while (temp != null) {
//                 if (set2.isContain(temp.data))
//                     ans.insert(temp.data);
//                 temp = temp.next;
//             }
//             return ans;
    
//         }
    
//         // UNION OPERATION
//         MySet union(MySet set2) {
    
//             MySet ans = new MySet();
//             if (this.ROOT == null) {
//                 ans.appendSet(set2);
//                 return ans;
//             }
    
//             if (set2.ROOT == null) {
//                 ans.appendSet(this);
//                 return ans;
//             }
    
//             Node temp1 = this.ROOT;
//             Node temp2 = set2.ROOT;
//             while (temp1 != null) {
    
//                 ans.insert(temp1.data);
//                 temp1 = temp1.next;
    
//             }
//             while (temp2 != null) {
    
//                 ans.insert(temp2.data);
//                 temp2 = temp2.next;
    
//             }
//             return ans;
    
//         }
    
//         // Minus operation
//         MySet minus(MySet B) {
//             MySet ans = new MySet();
//             if (this.ROOT == null)
//                 return ans;
//             if (B.ROOT == null) {
//                 ans.appendSet(this);
    
//             }
//             Node temp = this.ROOT;
//             while (temp != null) {
//                 if (!B.isContain(temp.data)) {
//                     ans.insert(temp.data);
//                 }
//                 temp = temp.next;
//             }
//             return ans;
//         }
    
//         // append set
//         private void appendSet(MySet set2) {
//             if (set2.ROOT == null)
//                 return;
//             Node temp = set2.ROOT;
//             while (temp != null) {
//                 this.insert(temp.data);
//                 temp = temp.next;
//             }
    
//         }
    
//         // Length Of Linked List
//         int length() {
//             if (this.ROOT == null)
//                 return 0;
//             int count = 0;
//             Node temp = this.ROOT;
//             while (temp != null) {
//                 count++;
//                 temp = temp.next;
    
//             }
//             return count;
//         }
    
//         // DELETE OPERATION
//         void delete(int key) {
//             if (this.ROOT == null)
//                 return;
//             if (this.ROOT.next == null)
//                 if (this.ROOT.data == key)
//                     this.ROOT = null;
//             if (this.ROOT.data == key)
//                 this.ROOT = this.ROOT.next;
//             Node temp = this.ROOT;
//             Node prev = null;
//             while (temp != null) {
//                 if (temp.data == key) {
    
//                     prev.next = temp.next;
    
//                 }
//                 prev = temp;
//                 temp = temp.next;
//             }
//         }
    
//         // is Contain Operation
//         boolean isContain(int key) {
//             if (this.ROOT == null)
//                 return false;
//             if (this.ROOT.next == null)
//                 return this.ROOT.data == key;
    
//             Node temp = this.ROOT;
//             while (temp != null) {
//                 if (temp.data == key)
//                     return true;
//                 temp = temp.next;
//             }
    
//             return false;
    
//         }
    
//         // Set Difference Operator
//         MySet delta(MySet B) {
    
//             return this.minus(B).union(B.minus(this));
    
//         }
    
//     }

// }