package task2;

import java.util.Comparator;

public class HeapHBLTp<E> {
    private final Comparator<E> comparator;
    private HeapNodeP<E> root = null;


    public HeapHBLTp(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void insert(E key) {
        if (root == null) {
            root = new HeapNodeP<>(key);
        } else {
            HeapNodeP<E> nodeP = new HeapNodeP<>(key);
            insertRec(root, nodeP);
            swapValues(nodeP);
        }
    }

    private void insertRec(HeapNodeP<E> root, HeapNodeP<E> node) {
        root.setrH(root.getrH()+1);
        if (root.getR() == null) {
            root.setR(node);
        } else {
            insertRec(root.getR(),node);
        }
    }

    private void swapValues(HeapNodeP<E> start) {
        if (start.getParent() != null) {
            if (comparator.compare(start.getKey(), start.getParent().getKey()) > 0) {

            }
            swapValues(start.getParent());
        }
    }

    public void print() {
        if (root != null) root.printTree();
    }
}
