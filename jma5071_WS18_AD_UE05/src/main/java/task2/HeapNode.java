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
        /*rH++; //Increment right height on each layer
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
        }*/
        return insert(new HeapNode<E>(key),comparator);
    }

    private HeapNode<E> insert(HeapNode<E> node, Comparator<E> comparator) {
        rH++;
        if (r != null) {
            if (comparator.compare(node.getKey(),key) < 0) {
                //Swap return child
                HeapNode<E> t = node.l;
                node.l = l;
                l = t;
                t = node.r;
                node.r = r;
                r = t;
                int temp = node.rH;
                node.rH = rH;
                rH = temp;
                temp = node.lH;
                node.lH = lH;
                lH = temp;
                node.r = node.insert(this,comparator);
                if (rH > lH) {
                    t = node.r;
                    node.r = node.l;
                    node.l = t;
                    temp = node.rH;
                    node.rH = lH;
                    node.lH = temp;
                } else {
                    r = node;
                }
                return node;
            } else {
                //Return this
                r = insert(node, comparator);
                if (rH > lH) {
                    HeapNode<E> t = r;
                    r = l;
                    l = t;
                    int temp = rH;
                    rH = lH;
                    lH = temp;
                } else {
                    r = node;
                }
                return this;
            }
        } else { //R is empty -> with height restructure
            if (rH > lH) {
                r = l;
                l = node;
                int temp = rH;
                rH = lH;
                lH = temp;
            } else {
                r = node;
            }
            return this;
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
