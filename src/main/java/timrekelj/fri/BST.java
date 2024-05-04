package timrekelj.fri;

public class BST<G extends Comparable> implements Seznam<G>{
    private ElementBST<G> root;

    public BST() {
        root = null;
    }

    enum Direction {
        LEFT, RIGHT
    }

    public void insert(G e, ElementBST<G> current, ElementBST<G> parent, Direction direction) {
        if (current == null) {
            if (parent == null) {
                root = new ElementBST<>(e, null);
                return;
            }
            if (direction == Direction.LEFT) {
                parent.leftChild = new ElementBST<>(e, parent);
            } else {
                parent.rightChild = new ElementBST<>(e, parent);
            }
            current = new ElementBST<>(e, parent);
            current.parent = parent;
        } else if (e.compareTo(current.value) < 0) {
            insert(e, current.leftChild, current, Direction.LEFT);
        } else if (e.compareTo(current.value) > 0) {
            insert(e, current.rightChild, current, Direction.RIGHT);
        }
    }

    public G delete(G e, ElementBST<G> current) {
        if (current == null) {
            throw new java.util.NoSuchElementException();
        }

        G res;
        if (e.compareTo(current.value) < 0) {
            return delete(e, current.leftChild);
        } else if (e.compareTo(current.value) > 0) {
            return delete(e, current.rightChild);
        } else {
            if (current.leftChild == null) {
                res = current.value;
                replace(current, current.rightChild);
                return res;
            } else if (current.rightChild == null) {
                res = current.value;
                replace(current, current.leftChild);
                return res;
            } else {
                ElementBST<G> min = findMin(current.rightChild);
                res = current.value;
                current.value = min.value;
                delete(min.value, current.rightChild);
                return res;
            }
        }
    }

    public ElementBST<G> findMin(ElementBST<G> current) {
        if (current.leftChild == null) {
            return current;
        } else {
            return findMin(current.leftChild);
        }
    }

    public void replace(ElementBST<G> current, ElementBST<G> replacement) {
        if (current.parent == null) {
            root = replacement;
        } else if (current == current.parent.leftChild) {
            current.parent.leftChild = replacement;
        } else {
            current.parent.rightChild = replacement;
        }
        if (replacement != null) {
            replacement.parent = current.parent;
        }
    }

    @Override
    public void add(G e) {
        insert(e, root, null, null);
    }

    @Override
    public G removeFirst() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return delete(root.value, root);
    }

    @Override
    public G getFirst() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return root.value;
    }

    private int countNodes(ElementBST<G> node) {
        if (node == null)
            return 0;
        else {
            int count = 1;
            count += countNodes(node.leftChild);
            count += countNodes(node.rightChild);
            return count;
        }
    }

    @Override
    public int size() {
        return countNodes(root);
    }

    private int getDepth(ElementBST<G> node) {
        if (node == null)
            return 0;
        else {
            int lDepth = getDepth(node.leftChild);
            int rDepth = getDepth(node.rightChild);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    @Override
    public int depth() {
        return getDepth(root);
    }

    @Override
    public boolean isEmpty() {
        return countNodes(root) == 0;
    }

    @Override
    public G remove(G e) {
        if (root == null) {
            throw new java.lang.NullPointerException();
        }
        return delete(e, root);
    }

    @Override
    public boolean exists(G e) {
        ElementBST<G> current = root;
        while (current != null) {
            if (e.compareTo(current.value) == 0) {
                return true;
            } else if (e.compareTo(current.value) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return false;
    }

    @Override
    public java.util.List<G> asList() {
        java.util.List<G> list = new java.util.ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(ElementBST<G> current, java.util.List<G> list) {
        if (current != null) {
            inOrder(current.leftChild, list);
            list.add(current.value);
            inOrder(current.rightChild, list);
        }
    }

    private class ElementBST<G> {
        G value;
        ElementBST<G> leftChild;
        ElementBST<G> rightChild;
        ElementBST<G> parent;

        public ElementBST(G value, ElementBST<G> parent) {
            this.value = value;
            this.parent = parent;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
