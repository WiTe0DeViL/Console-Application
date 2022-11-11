package MondayEvolution;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedList {
    Node head;
    int size;

    public LinkedList() {
        head = null;
    }

    class Node {

        private Integer val;
        private Node next;

        public Node(Integer val) {
            this.val = val;
        }

    }

    public void insertAtBeginning(Integer data) {
        Node newNode = new Node(data);
        if (head != null)
            newNode.next = head;
        head = newNode;
    }

    public void add(Integer data) {
        Node newNode = new Node(data);
        Node temp = head;
        size++;
        if (temp == null) {
            insertAtBeginning(data);
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public int[] getNextGreater() {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        int[] array = new int[size];
        int elementIndex = 0;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
            // Monotonic Stack
//            if (!stack.isEmpty() && stack.peek() < temp.val) {
//                while (!stack.isEmpty()) {
//                    array[elementIndex++] = temp.val;
//                    stack.pop();
//                }
//            } else if (stack.isEmpty()) {
//                stack.push(temp.val);
//            } else if (stack.peek() > temp.val) {
//                stack.push(temp.val);
//                elementIndex++;
//            } else
//                array[elementIndex++] = 0;
        }
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                array[stack.peek()] = list.get(i);
                stack.pop();
            }
            stack.push(i);
        }
        return array;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


}


