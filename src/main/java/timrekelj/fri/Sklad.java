package timrekelj.fri;

public class Sklad<G> implements Seznam<G> {
    private int size;
    private Element<G> root;

    public Sklad(){
        size = 0;
    }

    @Override
    public void add(G e) {
        Element<G> newElement = new Element<>(e);
        newElement.next = root;
        root = newElement;
        size++;
    }

    @Override
    public G removeFirst() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        G result = root.value;
        root = root.next;
        size--;
        return result;
    }

    @Override
    public G remove() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public G getFirst() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return root.value;
    }

    @Override
    public G get() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    public int search(G value) {
        int count = 0;
        while (root != null) {
            if (root.value.equals(value)) {
                return count;
            }
            root = root.next;
            count++;
        }
        return -1;
    }

    static class Element<G> {
       public G value;
       public Element<G> next;

       public Element(G value) {
           this.value = value;
       }
    }
}
