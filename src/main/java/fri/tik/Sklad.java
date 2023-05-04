package fri.tik;

public class Sklad<Tip> implements Seznam<Tip>{
    class Element<Tip> {
        public Tip vrednost;
        public Element<Tip> vezava;

        public Element(Tip e) {
            vrednost = e;
        }
    }

    private Element<Tip> vrh;


    public void push(Tip e) {
        Element<Tip> novVrh = new Element<>(e);
        novVrh.vezava = vrh;
        vrh = novVrh;
    }

    public Tip pop() {
        if (null == vrh) {
            throw new java.util.NoSuchElementException("No such element");
        }

        Tip e = vrh.vrednost;
        vrh = vrh.vezava;
        return e;
    }

    public Tip top() {
        if (vrh == null) {
            throw new java.util.NoSuchElementException("No such element");
        }
        return vrh.vrednost;
    }

    @Override
    public void add(Tip e) {
        push(e);
    }

    @Override
    public Tip removeFirst() {
        return pop();
    }

    @Override
    public Tip getFirst() {
        return top();
    }

    public int size() {
        int result = 0;
        Element<Tip> temp = vrh;
        while (null != temp) {
            ++result;
            temp = temp.vezava;
        }
        return result;
    }

    @Override
    public int depth() {
        return size();
    }

    public boolean isTop(Tip niz) {
        if (null == vrh) {
            throw new java.util.NoSuchElementException("No such element");
        }
        return niz.equals(vrh.vrednost);
    }

    public int search(Tip niz) {
        var trenutna = vrh;
        int i = 0;

        while (trenutna != null) {
            if (niz.equals(trenutna.vrednost))
                return i;
            i++;
            trenutna = trenutna.vezava;
        }
        return -1;
    }

    public boolean isEmpty() {
        return (vrh == null);
    }

    @Override
    public Tip remove(Tip e) {
        if (null == vrh) {
            throw new java.util.NoSuchElementException("No such element");
        }

        if (e.equals(vrh.vrednost)) {
            return pop();
        }

        Element<Tip> temp = vrh;
        while (null != temp.vezava) {
            if (e.equals(temp.vezava.vrednost)) {
                Element<Tip> toRemove = temp.vezava;
                temp.vezava = temp.vezava.vezava;
                return toRemove.vrednost;
            }
            temp = temp.vezava;
        }
        throw new java.util.NoSuchElementException("No such element");
    }

    @Override
    public boolean exists(Tip e) {
        return search(e) != -1;
    }
}