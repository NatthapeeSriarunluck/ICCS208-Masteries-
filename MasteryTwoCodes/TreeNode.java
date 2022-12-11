public class TreeNode<E> {
    E key;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E key, TreeNode<E> left, TreeNode<E> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    TreeNode(E key) { // Call the constructor above
        this(key, null, null);
    }

    int depth(TreeNode<E> u) {
        if (u == null)
            return 0;
        else
            return 1 + Math.max(depth(u.left), depth(u.right));
    }

    void printInorder(TreeNode<E> node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printPreorder(TreeNode<E> node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(TreeNode<E> node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }
}
