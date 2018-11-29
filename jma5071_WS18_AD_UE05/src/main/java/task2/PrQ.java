package task2;

/**
 * @author Janik Mayr on 14.11.2018
 */
public class PrQ<E>  {

    BTNode<E> root = null;

    public boolean add(E e) {
        if (root==null){
            root = new BTNode<>(e);
            return true;
        } else {
            return root.add(e);
        }
    }

    public E poll() {
        return null;
    }

    public E peek() {
        return (root == null)? null:root.getKey();
    }
}
