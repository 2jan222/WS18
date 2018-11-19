package task2;

import java.util.Comparator;

public class HeapNode<E> {
    private HeapNode<E> l;
    private HeapNode<E> r;
    private int lH = 0;
    private int rH = 0;
    private final E key;


    public HeapNode(E key) {
        this.key = key;
        l = null;
        r = null;
    }

    public HeapNode<E> insert(E key, Comparator<E> comparator) {
        rH++; //Increment right height on each layer
        if(r == null) { //Right space is free
            HeapNode<E> insertNode = new HeapNode<>(key);
            r = insertNode;
            if (valueBasedSwitch(comparator)) {
                insertNode.r = this;
                r.heightBasedSwitch();
                return insertNode;
            } else {
                heightBasedSwitch();
                return this;
            }
        } else {
            //[Decent]
            HeapNode<E> insertNode = insert(key, comparator);
            //[Ascent]
            if (insertNode != r) {
                r = insertNode;
                if (valueBasedSwitch(comparator)) {
                    insertNode.r = this;
                    r.heightBasedSwitch();
                    return insertNode;
                } else {
                    heightBasedSwitch();
                    return this;
                }
            } else {
                heightBasedSwitch();
                return this;
            }
        }
    }

    private boolean valueBasedSwitch(Comparator<E> comparator ) {
        if (comparator.compare(key, r.getKey()) < 0) {
            //Transfer left child
            swap(l, r.l);
            //Transfer right child
            swap(r, r.r);
            //Transfer left child
            if (r != null) {
                swap(r.lH,lH);
            } else {
                lH = 0;
            }
            //Transfer right height
            if (r != null) {
                swap(r.rH,rH);
            } else {
                rH = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean heightBasedSwitch() {
        if (rH > lH) {
            swap(r,l);
            swap(rH,lH);
            return true;
        } else {
            return false;
        }
    }

    private void swap(Object o0, Object o1) {
        Object temp = o0;
        o0 = o1;
        o1 = temp;
    }

    public HeapNode<E> getL() {
        return l;
    }

    public void setL(HeapNode<E> l) {
        this.l = l;
    }

    public HeapNode<E> getR() {
        return r;
    }

    public void setR(HeapNode<E> r) {
        this.r = r;
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
