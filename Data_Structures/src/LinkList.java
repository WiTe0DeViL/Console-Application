public class LinkList<T> {
    Node head;

    public LinkList() {
        head = null;
    }

    class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }


    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void InsertAtBegining(T data) {
        Node newNode = new Node(data);
        /*  if (head == null) {          Not Extracted
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }*/
        if (head != null) {   /* Extracted */
            newNode.next = head;
        }
        head = newNode;
    }

    public void InserAt(int Position, T data) {
        // When we need to insert at the 0 index
        if (Position == 0) {
            InsertAtBegining(data);
            return;
        }
        //filling data in a newNode
        Node newNode = new Node(data);

        // inside the LinkedList
        Node temp = head;
        for (int i = 1; i < Position; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IllegalArgumentException("Invalid Position");
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;


    }

    public void add(T data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (temp == null) {
            InsertAtBegining(data);
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void delete(int pos) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is Empty");
        }

        if (pos == 0) {
            head = head.next;
        }

        Node temp = head;
        Node prev = temp;
        for (int i = 1; i <= pos; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }


    public void DeleAtBegining() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is Empty");
        }
        head = head.next;
    }

    public int search(T data) {
        Node temp = head;
        int size = 0;
        while (temp.data != data) {
            temp = temp.next;
            if (temp.data != data && temp.next == null) {
                throw new IndexOutOfBoundsException("Not present");
            }
            size++;
        }
        return size;
    }

    public boolean contains(T data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) return true;
        }
        return false;
    }

    public void revese() {
        Node prev = null;
        Node current = head;
        Node Next;

        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }
        head = prev;
    }

    public void reverseBetween(int left, int right) {
        Node Head = null, tail = null;
        Node cu = head;
        Node Before_left = null;
        int count = 1;
        //Finding first value
        WHILE:
        while (cu != null) {
            if (count == left) {
                Head = cu;
                break WHILE;
            }
            count++;
            Before_left = cu;
            cu = cu.next;
        }

        //Finding last value and getting the next of it
        Node temp1 = Head;
        WHILE:
        while (temp1 != null) {
            if (count == right) {
                if (temp1.next != null) tail = temp1.next;
                else tail = temp1;
                break WHILE;
            }
            count++;
            temp1 = temp1.next;

        }

        // Reversing inner LinkedList
        Node temp_head = Head;
        Node prev = null;
        Node curr = temp_head;
        Node Next = null;

        while (curr != tail) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        Head.next = tail;

        if (Before_left != null)
            Before_left.next = prev;

    }
}