package udemy.trees.course;

public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if (subTreeRoot == null) {
            return null;
        }

        if (value < subTreeRoot.getData()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (value > subTreeRoot.getData()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            subTreeRoot.setData(subTreeRoot.getRightChild().min());
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }
        return subTreeRoot;
    }

    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public int max() {
        if (root != null) {
            return root.max();
        } else
            return Integer.MAX_VALUE;
    }

    public int min() {
        if (root != null) {
            return root.min();
        } else
            return Integer.MIN_VALUE;
    }
}
