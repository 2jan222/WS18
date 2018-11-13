package task1and2;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Janik Mayr on 05.11.2018
 */
public class BinarySearchTree extends Tree {

    public BinarySearchTree(){
        super();
    }

    public static BinarySearchTree getInstance(int... values) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        if (!nullity.test(values)) IntStream.of(values).forEach(binarySearchTree::insertValue);
        return binarySearchTree;
    }

    public void insertValue(int value) {
        if (root==null) setRoot(new Node(value));
        else root.insertValueStrict(value);
    }

    @Override
    public List<Node> toNodeList() {
        return null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
