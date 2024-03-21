package timrekelj.fri;

public class Sklad<G> {
    private int size;
    private Element<G> root;

    public Sklad(){
        size = 0;
    }

    public void push(G value) {
        Element<G> newElement = new Element<>(value);
        newElement.next = root;
        root = newElement;
        size++;
    }

    public G pop() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        G result = root.value;
        root = root.next;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return (root == null);
    }

    public G top() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return root.value;
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
