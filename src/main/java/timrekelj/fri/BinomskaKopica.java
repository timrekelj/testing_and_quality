package timrekelj.fri;

import java.util.List;

public class BinomskaKopica<G extends Comparable> implements Seznam<G>{

    private BinomialHeapNode topNode;

    @Override
    public void add(G e) {
        BinomialHeapNode newNode = new BinomialHeapNode(e);
        newNode.sibling = this.topNode;
        this.topNode = newNode;
        build(this.topNode, null);
    }

    @Override
    public G removeFirst() {
        if (this.topNode == null)
            throw new java.util.NoSuchElementException();
        return remove(this.getFirst());
    }

    @Override
    public G getFirst() {
        if (this.topNode == null)
            throw new java.util.NoSuchElementException();
        BinomialHeapNode node = this.topNode;
        G max = this.topNode.key;
        while (node.sibling != null) {
            if (node.sibling.key.compareTo(max) > 0)
                max = node.sibling.key;
            node = node.sibling;
        }
        return max;
    }

    @Override
    public int size() {
        int size = 0;
        BinomialHeapNode node = this.topNode;
        while (node != null) {
            size = (int)Math.pow(2, node.degree);
            node = node.sibling;
        }
        return size;
    }

    @Override
    public int depth() {
        if (this.topNode == null)
            return 0;
        int maxDegree = 0;
        BinomialHeapNode node = this.topNode;
        while (node != null) {
            if (node.degree > maxDegree)
                maxDegree = node.degree;
            node = node.sibling;
        }
        return maxDegree + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.topNode == null;
    }

    @Override
    public G remove(G e) {
        if (this.topNode == null)
            throw new java.lang.NullPointerException();
        BinomialHeapNode node = this.topNode;
        while (node != null) {
            if (node.key.compareTo(e) == 0) { //is root
                if (node.children.isEmpty()) { // is root without children
                    this.topNode = node.sibling;
                    return node.key;
                } else { // is root with children
                    BinomialHeapNode child = node.children.getFirst();
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        child = node.children.get(i);
                        orphanAChild(child);
                    }

                    child.sibling = (node.sibling == null) ? null : node.sibling;

                    build(this.topNode, null);
                    return node.key;
                }
            } else if (node.key.compareTo(e) > 0 && existsInChildren(node, e)) { // is in children
                // find in children and swap it with tree root
                // orphan children of the root
                // sort
                // build
                findInChildrenAndSwap(node, node, e);
                BinomialHeapNode child = node.children.getFirst();
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    child = node.children.get(i);
                    orphanAChild(child);
                }
                child.sibling = (node.sibling == null) ? null : node.sibling;

                // sort all trees
                BinomialHeapNode temp = this.topNode;
                while (temp != null) {
                    sortTree(temp);
                    temp = temp.sibling;
                }
                build(this.topNode, null);
                return node.key;
            }
            node = node.sibling;
        }
        throw new java.util.NoSuchElementException();
    }

    private void findInChildrenAndSwap(BinomialHeapNode root, BinomialHeapNode node, G e) {
        for (BinomialHeapNode child : node.children) {
            if (child.key.compareTo(e) == 0) {
                G tempKey = root.key;
                root.key = child.key;
                child.key = tempKey;
                return;
            }
            if (existsInChildren(child, e)) {
                findInChildrenAndSwap(node, child, e);
            }
        }
    }

    private void sortTree(BinomialHeapNode node) {
        if (node.children.isEmpty())
            return;
        for (BinomialHeapNode child : node.children) {
            if (node.key.compareTo(child.key) < 0) {
                G tempKey = node.key;
                node.key = child.key;
                child.key = tempKey;
                sortTree(node);
            }
            sortTree(child);
        }
    }

    private void orphanAChild(BinomialHeapNode child) {
        child.parent = null;
        BinomialHeapNode node = this.topNode;
        BinomialHeapNode prev = null;
        while (true) {
            if (node.degree > child.degree) {
                if (prev != null)
                    prev.sibling = child;
                else
                    this.topNode = child;
                child.sibling = node;
                return;
            }
            prev = node;
            node = node.sibling;
        }
    }

    @Override
    public boolean exists(G e) {
        BinomialHeapNode node = this.topNode;
        while (node != null) {
            if (node.key.compareTo(e) < 0) {
                node = node.sibling;
                continue;
            }
            if (node.key.compareTo(e) == 0)
                return true;
            if (existsInChildren(node, e))
                return true;
            node = node.sibling;
        }
        return false;
    }

    private boolean existsInChildren(BinomialHeapNode node, G e) {
        for (BinomialHeapNode child : node.children) {
            if (child.key.compareTo(e) < 0)
                continue;
            if (child.key.compareTo(e) == 0)
                return true;
            if (existsInChildren(child, e))
                return true;
        }
        return false;
    }

    @Override
    public List<G> asList() {
        List<G> list = new java.util.ArrayList<>();
        BinomialHeapNode node = this.topNode;
        while (node != null) {
            addToList(list, node);
            node = node.sibling;
        }
        return list;
    }

    private void addToList(List<G> list, BinomialHeapNode node) {
        list.add(node.key);
        for (BinomialHeapNode child : node.children) {
            addToList(list, child);
        }
    }

    private void build(BinomialHeapNode node, BinomialHeapNode prev) {
        if (node.sibling == null) return;
        if (node.degree > node.sibling.degree) {
            this.topNode = node.sibling;
            BinomialHeapNode temp = node.sibling.sibling;
            node.sibling.sibling = node;
            node.sibling = temp;
            build(node, this.topNode);
            return;
        }
        if (node.degree != node.sibling.degree) {
            build(node.sibling, node);
            return;
        }

        BinomialHeapNode maxTemp;
        BinomialHeapNode minTemp;
        if (node.key.compareTo(node.sibling.key) > 0) {
            maxTemp = node;
            minTemp = node.sibling;
        } else {
            maxTemp = node.sibling;
            minTemp = node;
        }

        maxTemp.degree++;
        maxTemp.children.add(minTemp);
        sortChildren(maxTemp);
        if (maxTemp != minTemp.sibling){
            maxTemp.sibling = minTemp.sibling;
        }

        minTemp.parent = maxTemp;
        minTemp.sibling = null;
        node = maxTemp;

        if (prev != null)
            prev.sibling = node;
        else
            this.topNode = node;

        build(this.topNode, null);
    }

    private void sortChildren(BinomialHeapNode node) {
        for (int i = 0; i < node.children.size(); i++) {
            for (int j = i; j < node.children.size(); j++) {
                if (node.children.get(i).degree < node.children.get(j).degree) {
                    BinomialHeapNode temp = node.children.get(i);
                    node.children.set(i, node.children.get(j));
                    node.children.set(j, temp);
                }
            }
        }
    }

    class BinomialHeapNode {
        private G key;
        private int degree;
        private BinomialHeapNode parent;
        private List<BinomialHeapNode> children;
        private BinomialHeapNode sibling;

        BinomialHeapNode(G key) {
            this.key = key;
            this.degree = 0;
            this.children = new java.util.ArrayList<>();
        }
    }
}
