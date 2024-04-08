package timrekelj.fri;

public class PrioritetnaVrsta<G extends Comparable> implements Seznam<G> {
    private Object[] heap;
    private int end = 0;

    public PrioritetnaVrsta() { this(100); }
    public PrioritetnaVrsta(int maxSize) { heap = new Object[maxSize]; }

    @Override
    public void add (G e) {
        if (end == heap.length)
            heap = java.util.Arrays.copyOf(heap, heap.length * 2);
        heap[end++] = e;
        bubbleUp();
    }

    @Override
    public G removeFirst() {
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        G elt = (G) heap[0];
        swap(0, --end);
        bubbleDown(0);
        return elt;
    }

    @Override
    public G remove(G e) {
        if (this.isEmpty())
            throw new java.lang.NullPointerException();

        for (int i = 0; i < end; i++)
            if (heap[i].equals(e)) {
                swap(i, --end);
                bubbleDown(i);
                return (G) heap[i];
            }

        throw new java.util.NoSuchElementException();
    }

    @Override
    public boolean exists(G e) {
        for (int i = 0; i < end; i++)
            if (heap[i].equals(e))
                return true;
        return false;
    }

    @Override
    public G getFirst() {
        if(this.isEmpty()) throw new
                java.util.NoSuchElementException();
        return (G) heap[0];
    }

    @Override
    public int depth() {
        if(end==0) return 0;
        return (int)
                (Math.log(end) / Math.log(2)) +1;
    }

    @Override
    public boolean isEmpty() {
        return end==0;
    }

    @Override
    public int size() {
        return end;
    }

    private void swap(int i, int j) {
        Object tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void bubbleUp() {
        int eltIdx = end - 1;
        while (eltIdx >= 0) {
            G elt = (G) heap[eltIdx];
            int childIdx = eltIdx * 2 + 1;
            if (childIdx < end) {
                G child = (G) heap[childIdx];
                if (childIdx + 1 < end && child.compareTo(heap[childIdx+1]) < 0)
                    child = (G) heap[++childIdx];
                if (elt.compareTo(child) >= 0)
                    return;
                swap(eltIdx, childIdx);
            }
            eltIdx = eltIdx % 2 == 1 ? (eltIdx - 1) / 2 : (eltIdx - 2) / 2;
        }
    }

    private void bubbleDown(int start) {
        int eltIdx = start;
        int childIdx = eltIdx * 2 + 1;
        while (childIdx < end) {
            G elt = (G) heap[eltIdx];
            G child = (G) heap[childIdx];
            if (childIdx + 1 < end && child.compareTo(heap[childIdx+1]) < 0)
                child = (G) heap[++childIdx];
            if (elt.compareTo(child) >= 0)
                return;
            swap(eltIdx, childIdx);
            eltIdx = childIdx;
            childIdx = eltIdx * 2 + 1;
        }
    }
}
