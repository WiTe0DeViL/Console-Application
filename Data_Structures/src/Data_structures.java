import NonLinearDataStrunctures.Tree;

public class Data_structures {

    public static void main(String[] args) {
        // Linked List
//        LinkList<Integer> ll = new LinkList<>();
//        ll.add(3);
//        ll.add(5);
//        ll.add(3);
//        ll.add(4);
//        ll.add(5);
//        ll.display();
//        System.out.println(ll.reverseBetween(2,4));
//        ll.reverseBetween(1,2);
//        ll.revese();
//        ll.display();
        // Doubly Linked List
//        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
//        dll.InsertAtbegining(2);
//        dll.InsertAtbegining(1);
//        dll.add(3);
//        dll.add(4);
//        dll.add(5);
//        dll.display();
//        System.out.println(dll.contains(0));
//        System.out.println(dll.contains(1));
//        dll.InsertAtbegining(0);
//        System.out.println(dll.length());
//        dll.Insert(5    ,7);
//        dll.Insert(2    ,20);
//        dll.display();
//        dll.delete(2);
//        dll.delete(5);
//        dll.DeleteAtEnd();
//        dll.display();
//        System.out.println(dll.length());
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(5));
        tree.travesePreorder();
        tree.traverseInorder();
        tree.travesePostOrder();
        tree.insert(12);
        tree.insert(13);
        tree.insert(11);
        Tree tree1 = new Tree();
        tree1.insert(7);
        tree1.insert(9);
        tree1.insert(4);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);
        System.out.println(tree.height());
        System.out.println(tree.min());
        System.out.println(tree.equal(tree1));
        System.out.println(tree.isValidBST(tree));
        tree.KNode(tree, 3);
        Integer a = 10, b = 20;
        Integer n = 20;
        n = 5;
        System.out.println(n);

    }

    public static void swap(Integer A, Integer B) {
        Integer tem = A;
        A = B;
        B = tem;
        System.out.println(A + " " + B);
    }

}
