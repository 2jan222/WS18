package task1and2;

import java.util.function.Consumer;

/**
 * @author Janik Mayr on 05.11.2018
 */
public class Node {
    private Node right;
    private Node left;
    private int value;

    public Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public Node(Node right, Node left, int value) {
        this.right = right;
        this.left = left;
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void insertValueStrict(int value) {
        if (value > this.value) {
            if (right == null) right = new Node(value);
            else right.insertValueStrict(value);
        } else {
            if (left == null) left = new Node(value);
            else  left.insertValueStrict(value);
        }
    }

    public void actionInOrder(Consumer<Object> action) {
        if (left!=null) left.actionInOrder(action);
        action.accept(this);
        if (right!=null) right.actionInOrder(action);
    }

    public void actionPreOrder(Consumer<Object> action) {
        action.accept(this);
        if (left!=null) left.actionPreOrder(action);
        if (right!=null) right.actionPreOrder(action);
    }

    public void actionPostOrder(Consumer<Object> action) {
        if (left!=null) left.actionPostOrder(action);
        if (right!=null) right.actionPostOrder(action);
        action.accept(this);
    }

    public int calcHeight() {
        return Math.max((left == null) ? 0 : left.calcHeight(), (right == null) ? 0 : right.calcHeight()) + 1;
    }

    public int calcLeafs() {
        return (left == null && right == null) ? 1:((left == null) ? 0 : left.calcLeafs()) + ((right == null) ? 0:right.calcLeafs());
    }
}
