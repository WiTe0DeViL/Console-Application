public class DoublyLinkedList<T> {
    private Node head;
    private Node tail;
    private static int size = 0;

    class Node {
        Node prev = null;
        Node next = null;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // contains method to check
    public boolean contains(T data) {
        Node temp = head;
        while (temp != null) {
            if (data == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Inserting At Begining
    public void InsertAtbegining(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    //adding node at last
    public void add(T data) {
        if (head == null) {
            InsertAtbegining(data);
            return;
        }
        Node newNode = new Node(data);
        tail = newNode;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        newNode.prev = temp;
        temp.next = newNode;

        size++;
    }

    //Displaying doubly linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int length() {
        return size;
    }

    //Deleteing a Node
    public void delete(int pos) {
        Node temp = head;
        if (pos > size) {
            throw new NullPointerException("Exception out of bound");
        }
        if (pos == 0) {
            head = head.next;
            head.prev = null;
            return;
        }
        Node previous = null;
        for (int i = 1; i <= pos; i++) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = temp.next;
        temp.next.prev = previous;
        size--;
    }

    public void Insert(int pos, T data) {
        if (pos == 0) {
            InsertAtbegining(data);
            return;
        }
        if (pos == size) {
            add(data);
            return;
        }
        if (pos > size) {
            throw new NullPointerException("No place heheheheh");
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = temp;

        size++;
    }
    public void DeleteAtEnd(){
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = null;

    }

}
