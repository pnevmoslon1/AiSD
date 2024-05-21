public class BinSearchTree {
    Node root = null;
    private Node lastFind = null;


    public Node recFind(Node currentNode, int val) {

        if (currentNode.value > val && currentNode.left != null) {
            lastFind = currentNode;
            return recFind(currentNode.left, val);
        }
        if (currentNode.value < val && currentNode.right != null) {
            lastFind = currentNode;
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

    private Node searchMax(Node currentNode) {
        if (currentNode.right == null) return currentNode;
        return searchMax(currentNode.right);
    }

    private Node searchMin(Node currentNode) {
        if (currentNode.left == null) return currentNode;
        return searchMin(currentNode.left);
    }

    public boolean delete(int value) {
        if (recFind(root, root.value) == null) return false;
        Node currentNode = recFind(root, value);
        if (currentNode.left != null) {
            currentNode.value = searchMax(currentNode.left).value;

        } else if (currentNode.right != null) {
            currentNode.value = searchMin(currentNode.right).value;


        } else if (lastFind != null) {
            if (lastFind.left == currentNode) lastFind.left = null;
            else lastFind.right = null;
        }
        return true;
    }

    public void printTree(Node currentNode) {
        System.out.print(currentNode.value + " ");
        if (currentNode.left != null) printTree(currentNode.left);
        if (currentNode.right != null) printTree(currentNode.right);
    }
}

