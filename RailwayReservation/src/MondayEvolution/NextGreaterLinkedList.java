package MondayEvolution;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of LinkedList : ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            linkedList.add(scan.nextInt());
        linkedList.display();
        System.out.println(Arrays.toString(linkedList.getNextGreater()));
    }

}
