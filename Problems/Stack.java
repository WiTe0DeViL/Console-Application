import java.util.*;

public class Stack {

    private Node top;
    public int size;

    private class Node {
        private int val;
        private Node next;

        public Node(int data) {
            this.val = data;
        }
    }

    Stack() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        int result = top.val;
        top = top.next;
        size--;
        return result;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int[] toArray(){
        int[] arr = new int[size];
        Node temp = top;
        int i=0;
        while(temp != null){
            arr[i] = temp.val;
            temp = temp.next;
        }
        return arr;
    }

}