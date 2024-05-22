public class BinSearchTree {
    Node root = null;
    private Node lastFind = null;
    private Node lastMax;
    private Node lastMin;

    public Node recFind(Node currentNode, int val) {

        if (currentNode.value > val && currentNode.left != null) {
            return recFind(currentNode.left, val);
        }
        if (currentNode.value < val && currentNode.right != null) {
            return recFind(currentNode.right, val);
        }
        return currentNode;
    }


    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node currentNode = recFind(root, value);
            if (currentNode.value >= value) {
                currentNode.left = new Node(value);
            } else {
                currentNode.right = new Node(value);
            }
        }
    }

    public boolean find(Node currentNode, int value) {
        if (currentNode.value == value) return true;
        if (currentNode.left != null && currentNode.value > value) return find(currentNode.left, value);
        if (currentNode.right != null && currentNode.value < value) return find(currentNode.right, value);
        return false;


    }

    private Node searchMin(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        }
        return searchMin(currentNode.left);
    }

    public Node searchPrev(Node currentNode, Node search) {
        if (currentNode.left == search || currentNode.right == search) {
            return currentNode;
        }
        if (currentNode.left.value > search.value) return searchPrev(currentNode.left, search);
        return searchPrev(currentNode.right, search);
    }


    public Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            current.value = searchMin(current.right).value;
            current.right = deleteRecursive(current.right, current.value);
        } else if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }
        return current;
    }

    public void printTree(Node currentNode) {
        System.out.print(currentNode.value + " ");
        if (currentNode.left != null) printTree(currentNode.left);
        if (currentNode.right != null) printTree(currentNode.right);
    }
}

