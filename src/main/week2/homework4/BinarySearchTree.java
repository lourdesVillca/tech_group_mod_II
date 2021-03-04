package week2.homework4;


public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        E value;
        Node leftChild = null;
        Node rightChild = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj instanceof BinarySearchTree.Node) == false)
                return false;
            @SuppressWarnings("unchecked")
            Node other = (BinarySearchTree<E>.Node) obj;
            return other.value.compareTo(value) == 0 &&
                    other.leftChild == leftChild && other.rightChild == rightChild;
        }
    }


    protected Node root = null;

    protected void visit(Node n) {
        System.out.println(n.value);
    }

    public boolean contains(E val) {
        return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
        if (n == null) return false;

        if (n.value.equals(val)) {
            return true;
        } else if (n.value.compareTo(val) > 0) {
            return contains(n.leftChild, val);
        } else {
            return contains(n.rightChild, val);
        }
    }

    public boolean add(E val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    protected boolean add(Node n, E val) {
        if (n == null) {
            return false;
        }
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return false; // this ensures that the same value does not appear more than once
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    public boolean remove(E val) {
        return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
        if (n == null) return false;

        if (val.compareTo(n.value) == -1) {
            return remove(n.leftChild, n, val);
        } else if (val.compareTo(n.value) == 1) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent == null) {
                root = n.leftChild != null ? n.leftChild : n.rightChild;
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected E maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }


    /*********************************************
     *
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    /**
     * Method 1 - Find a Node given the value to search.
     *
     * @param val Value to be searched
     * @return Node that we found.
     */
    public Node findNode(E val) {
        return getNode(root, val);
    }

    /**
     * Method that Search a node and return it.
     *
     * @param node Node to search.
     * @param val  Value of the Node
     * @return the found Node.
     */
    public Node getNode(Node node, E val) {
        if (node == null || val == null) return null;
        if (node.value.equals(val)) {
            return node;
        } else if (node.value.compareTo(val) > 0) {
            return getNode(node.leftChild, val);
        } else {
            return getNode(node.rightChild, val);
        }
    }

    /**
     * Method that calculate the depth of the tree.
     *
     * @param val Node value to check the depth.
     * @return the depth of the tree node.
     */
    protected int depth(E val) {
        int count = 0;
        return calculateDepth(root, val, count);
    }

    /**
     * Method that Calculate the depth of the tree.
     *
     * @param node  Represents the node from where to calculate the depth.
     * @param val   Value to Search.
     * @param count Counter of the Depth
     * @return Depth of the Tree
     */
    protected int calculateDepth(Node node, E val, int count) {
        if (node == null || val == null) return -1;
        if (node.value.equals(val)) return count++;
        if (node.value.compareTo(val) > 0) {
            count++;
            return calculateDepth(node.leftChild, val, count);
        } else {
            count++;
            return calculateDepth(node.rightChild, val, count);
        }
    }

    /**
     * Method that calculate the height of the Tree given a Node
     *
     * @param val Represents the value to search
     * @return the height of the tree
     */
    protected int height(E val) {
        Node node = findNode(val);
        return calculateHeight(node);
    }

    /**
     * Method that given a node calculate the height of the tree
     *
     * @param node Node from where to start to check the height
     * @return Height of the tree.
     */
    private int calculateHeight(Node node) {
        if (node == null) return -1;
        if (node.leftChild == null && node.rightChild == null) return 0;
        int leftCount = calculateHeight(node.leftChild);
        int rightCount = calculateHeight(node.rightChild);
        return Math.max(leftCount, rightCount) + 1;
    }


    /**
     * Method that given a node verify if the tree children are balanced
     *
     * @param node Represents the Node from where to start to check if the tree is balanced.
     * @return True if the child tree is balanced. False otherwise.
     */
    protected boolean isBalanced(Node node) {
        if (node == null || !contains(node.value)) return false;
        int heightDiff = Math.abs(calculateHeight(node.leftChild) - calculateHeight(node.rightChild));
        if (heightDiff <= 1) return true;
        return isBalanced(node.leftChild) && isBalanced(node.rightChild);
    }

    /**
     * Method that verify if a tree is balanced.
     *
     * @return True if the Tree is balanced, False otherwise.
     */
    public boolean isBalanced() {
        return isBalanced(root.leftChild) && isBalanced(root.rightChild);
    }
}
