package task1and2;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Janik Mayr on 05.11.2018
 */
public abstract class Tree implements Treeable {
    Node root;
    static Predicate<Object> nullity = obj -> (obj==null);

    public Tree() {
        root = null;
    }

    public void actionInOrder(Consumer<Object> action) {
        if (!nullity.test(root)) root.actionInOrder(action);
    }
    public void actionPreOrder(Consumer<Object> action) {
        if (!nullity.test(root)) root.actionPreOrder(action);
    }
    public void actionPostOrder(Consumer<Object> action) {
        if (!nullity.test(root)) root.actionPostOrder(action);
    }
    public void actionLevelByLevel(Consumer<Object> action) {
        if (!nullity.test(root)) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node pollNode = q.poll();
                action.accept(pollNode);
                if (pollNode.getLeft()!=null) q.add(pollNode.getLeft());
                if (pollNode.getRight()!=null) q.add(pollNode.getRight());
            }
        }
    }

    public int calcHeight(){
        if (nullity.test(root)) return 0;
        else return root.calcHeight();
    }

    public int calcLeafs(){
        if (nullity.test(root)) return 0;
        else return root.calcLeafs();
    }

    public Node getRoot() {
        return root;
    }



}
