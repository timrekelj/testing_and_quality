package timrekelj.fri;

import java.lang.ref.WeakReference;

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
    public G remove(G e) {
        if (root == null) {
            throw new java.lang.NullPointerException();
        }

        G res;
        Element<G> current = root;
        while (current.next != null) {
            System.out.println(current.next.value + " " + e);
            if (current.next.value.equals(e)) {
                res = e;
                current.next = current.next.next;
                size--;
                return res;
            }
            current = current.next;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override
    public boolean exists(G e) {
        if (root == null)
            return false;

        Element<G> current = root;
        while (current.next != null) {
            if (current.value.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public G getFirst() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return root.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    public int search(G value) {
        int count = 0;
        Element<G> current = root;
        while (current != null) {
            if (current.value.equals(value)) {
                return count;
            }
            current = current.next;
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
