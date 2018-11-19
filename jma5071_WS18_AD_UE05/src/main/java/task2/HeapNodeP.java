package task2;

public class HeapNodeP<E> {
    private HeapNodeP<E> parent;
    private HeapNodeP<E> l;
    private HeapNodeP<E> r;
    private int lH = 0;
    private int rH = 0;
    private final E key;

    public HeapNodeP(E key) {
        this.key = key;
        l = null;
        r = null;
        parent = null;
    }

    public HeapNodeP<E> getParent() {
        return parent;
    }

    public void setParent(HeapNodeP<E> parent) {
        this.parent = parent;
    }

    public HeapNodeP<E> getL() {
        return l;
    }

    public void setL(HeapNodeP<E> l) {
        this.l = l;
    }

    public HeapNodeP<E> getR() {
        return r;
    }

    public void setR(HeapNodeP<E> r) {
        this.r = r;
    }

    public int getlH() {
        return lH;
    }

    public void setlH(int lH) {
        this.lH = lH;
    }

    public int getrH() {
        return rH;
    }

    public void setrH(int rH) {
        this.rH = rH;
    }

    public E getKey() {
        return key;
    }

    public void printTree() {
        if (r != null) {
            r.printTree(true, "");
        }
        printNodeValue();
        if (l != null) {
            l.printTree(false, "");
        }
    }
    private void printNodeValue() {
        if (key == null) {
            System.out.println("<null>");
        } else {
            System.out.println(key.toString());
        }
        System.out.println('\n');
    }

    private void printTree(boolean isRight, String indent) {
        if (r != null) {
            r.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        System.out.println(indent);
        if (isRight) {
            System.out.println(" /");
        } else {
            System.out.println(" \\");
        }
        System.out.println("----- ");
        printNodeValue();
        if (l != null) {
            l.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }
}
