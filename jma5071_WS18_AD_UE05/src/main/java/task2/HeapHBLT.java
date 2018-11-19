package task2;

import java.util.Comparator;

public class HeapHBLT<E> {
    private final Comparator<E> comparator;
    private HeapNode<E> root = null;


    public HeapHBLT(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void insert(E key) {
        root = (root == null) ? new HeapNode<>(key): root.insert(key, comparator);
    }

    public void print() {
        if (root != null) root.printTree();
    }
}
