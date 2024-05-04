package timrekelj.fri;

import java.util.List;

public interface Seznam<G> {
    void add(G e);
    G removeFirst();
    G getFirst();
    int size();
    int depth();
    boolean isEmpty();
    G remove(G e);
    boolean exists(G e);
    List<G> asList();
}
