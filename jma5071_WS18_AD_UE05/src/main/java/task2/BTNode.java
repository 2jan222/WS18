package task2;

/**
 * @author Janik Mayr on 14.11.2018
 */
public class BTNode<E> {
    private E key = null;

    public BTNode(E key) {
        this.key = key;
    }

    public E getKey() {
        return key;
    }

    public boolean add(E e) {
        return false;
    }
}
