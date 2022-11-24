package NonLinearDataStrunctures;

public class Tree {
    Node root;

    class Node {

        int value;
        Node leftChild, rightChild;

        Node(int data) {
            this.value = data;

        }

        @Override
        public String toString() {
            return "Name=" + value;
        }

    }

    public Tree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node curr = root;
            while (true) {
                if (data > curr.value) {
                    if (curr.rightChild == null) {
                        curr.rightChild = newNode;
                        break;
                    }
                    curr = curr.rightChild;
                } else {
                    if (curr.leftChild == null) {
                        curr.leftChild = newNode;
                        break;
                    }
                    curr = curr.leftChild;
                }
            }

        }
    }

    public boolean find(int data) {
        Node curr = root;
        while (curr != null) {
            if (curr.value > data)
                curr = curr.leftChild;
            else if (curr.value < data)
                curr = curr.rightChild;
            else {
                return true;
            }
        }
        return false;
    }

    public void travesePreorder() {
        traversePreOrder(root);
    }

    protected void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);

    }

    public void traverseInorder() {
        System.out.print("Ascendin : ");
        traverseInorder(root);
        System.out.println();
        System.out.print("Descending : ");
        traverseInorderRev(root);
        System.out.println();
    }

    protected void traverseInorder(Node root) {
        if (root == null)
            return;
        traverseInorder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInorder(root.rightChild);
    }

    protected void traverseInorderRev(Node root) {
        if (root == null)
            return;
        traverseInorderRev(root.rightChild);
        System.out.print(root.value + " ");
        traverseInorderRev(root.leftChild);
    }

    public void travesePostOrder() {
        System.out.print("PostOrder : ");
        traversePostOrder(root);
        System.out.println();

    }

    protected void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + " ");

    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;
        int ans = 1 + Math.max(height(root.leftChild), height(root.rightChild));
        return ans;
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;

    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        // if BST exists go to left most side

        if (root.leftChild == null)
            return root.value;

        return min(root.leftChild);

        // Its for equal nodes in both side of the tree not for BST
        /**if (isLeaf(root))
         return root.value;
         var l = min(root.leftChild);
         var r = min(root.rightChild);
         return Math.min(Math.min(l, r), root.value);
         **/
    }

    public boolean equal(Tree other) {
        if (other == null)
            return false;
        return equals(this.root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;
    }

    public boolean isValidBST(Tree tree) {
        return isValidBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    protected boolean isValidBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isValidBST(root.leftChild, min, root.value - 1) &&
                isValidBST(root.rightChild, root.value + 1, max);
    }

    public int KNode(Node root, int distance) {
        if(root == null)
            return 0;
        if (distance == 0) {
            return root.value;
        }
        KNode(root.leftChild, distance - 1);
        KNode(root.rightChild, distance - 1);
        return 0;
    }

    public void KNode(Tree tree, int distance) {
        KNode(tree.root, distance);
    }
    public void LevelOrder(){
        for(int i=0;i<height();i++){
            System.out.println(KNode(root,i));
        }
    }

}
