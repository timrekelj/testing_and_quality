package timrekelj.fri;

public interface Seznam<G> {
    void add(G e);
    G removeFirst();
    G getFirst();
    int size();
    int depth();
    boolean isEmpty();
    G remove(G e);
    boolean exists(G e);
}
