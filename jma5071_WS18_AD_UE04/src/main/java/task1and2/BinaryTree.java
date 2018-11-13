package task1and2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;


/**
 * @author Janik Mayr on 05.11.2018
 */
public class BinaryTree extends Tree {
    public BinaryTree(){
        super();
    }
    public BinaryTree(int... values){
        super();
        if (values!=null){
            IntStream.of(values).forEach(this::insertValue);
        }
    }
    @Override
    public void insertValue(int value) {
        if (!nullity.test(root)) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node pollNode = q.poll();
                if (pollNode.getLeft()!=null) q.add(pollNode.getLeft());
                else {
                    pollNode.setLeft(new Node(value));
                    return;
                }
                if (pollNode.getRight()!=null) q.add(pollNode.getRight());
                else {
                    pollNode.setRight(new Node(value));
                    return;
                }
            }
        } else {
            root = new Node(value);
        }
    }

    @Override
    public List<Node> toNodeList() {
        LinkedList<Node> nodes = new LinkedList<>();
        if (!nullity.test(root)) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node pollNode = q.poll();
                nodes.addLast(pollNode);
                if (pollNode.getLeft()!=null) q.add(pollNode.getLeft());
                if (pollNode.getRight()!=null) q.add(pollNode.getRight());
            }
        }
        return nodes;
    }

    public BinarySearchTree toSearchTree(){
        return BinarySearchTree.getInstance(this.toNodeList().stream().mapToInt(Node::getValue).toArray());
    }

    public static BinaryTree getInstance(int... values) {
        BinaryTree binaryTree = new BinaryTree();
        IntStream.of(values).forEach(binaryTree::insertValue);
        return binaryTree;
    }
}
