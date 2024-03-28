package timrekelj.fri;

public interface Seznam<G> {
    void add(G e);
    G removeFirst();
    G remove();
    G getFirst();
    G get();
    int size();
    int depth();
    boolean isEmpty();
}
