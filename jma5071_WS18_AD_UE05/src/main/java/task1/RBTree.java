package task1;

import java.io.IOException;
import java.util.Comparator;

/**
 * @author Janik Mayr on 07.11.2018
 */
public class RBTree<T> {
    private final RedBlackNode<T> nil = new RedBlackNode<>();
    private RedBlackNode<T> root = nil;
    private Comparator<T> comp;

    public RBTree(Comparator<T> comp) {
        this.comp = comp;
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }

    public void insert(T key) {
        insert(new RedBlackNode<>(key));
    }

    private void insert(RedBlackNode<T> node) {
        RedBlackNode<T> adoptiveFather = nil;
        RedBlackNode<T> trav = root;

        while (!isNil(trav)) {
            adoptiveFather = trav;
            if (comp.compare(node.key, trav.key) < 0) {
                trav.numLeft++;
                trav = trav.left;
            } else {
                trav.numRight++;
                trav = trav.right;
            }
        }
        node.parent = adoptiveFather;
        if (isNil(adoptiveFather)) {
            root = node;
        } else {
            if (comp.compare(node.key, adoptiveFather.key) < 0) {
                adoptiveFather.left = node;
            } else {
                adoptiveFather.right = node;
            }
        }
        node.left = nil;
        node.right = nil;
        node.isBlack = false;

        insertionReorder(node);
    }

    private void insertionReorder(RedBlackNode<T> node) {
        RedBlackNode<T> y;
        while (!node.parent.isBlack){

            // If node's parent is the the left child of it's parent.
            if (node.parent == node.parent.parent.left){

                // Initialize y to z 's cousin
                y = node.parent.parent.right;

                // Case 1: if y is red...recolor
                if (!y.isBlack){
                    node.parent.isBlack = true;
                    y.isBlack = true;
                    node.parent.parent.isBlack = false;
                    node = node.parent.parent;
                }
                // Case 2: if y is black & node is a right child
                else if (node == node.parent.right){

                    // leftRotaet around node's parent
                    node = node.parent;
                    leftRotate(node);
                }

                // Case 3: else y is black & z is a left child
                else{
                    // recolor and rotate round node's grandpa
                    node.parent.isBlack = true;
                    node.parent.parent.isBlack = false;
                    rightRotate(node.parent.parent);
                }
            }

            // If node's parent is the right child of it's parent.
            else{

                // Initialize y to node's cousin
                y = node.parent.parent.left;

                // Case 1: if y is red...recolor
                if (!y.isBlack){
                    node.parent.isBlack = true;
                    y.isBlack = true;
                    node.parent.parent.isBlack = false;
                    node = node.parent.parent;
                }

                // Case 2: if y is black and node is a left child
                else if (node == node.parent.left){
                    // rightRotate around node's parent
                    node = node.parent;
                    rightRotate(node);
                }
                // Case 3: if y  is black and node is a right child
                else{
                    // recolor and rotate around node's grandpa
                    node.parent.isBlack = true;
                    node.parent.parent.isBlack = false;
                    leftRotate(node.parent.parent);
                }
            }
        }
        // Color root black at all times
        root.isBlack = true;

    }

    private void rightRotate(RedBlackNode<T> node) {
        // Case 1: Only node, node.left and node.left.left exists.
        if (isNil(node.right) && isNil(node.left.right)){
            node.numRight = 0;
            node.numLeft = 0;
            node.left.numRight = 1;
        }

        // Case 2: node.left.right also exists in addition to Case 1
        else if (isNil(node.right) && !isNil(node.left.right)){
            node.numRight = 0;
            node.numLeft = 1 + node.left.right.numRight +
                    node.left.right.numLeft;
            node.left.numRight = 2 + node.left.right.numRight +
                    node.left.right.numLeft;
        }

        // Case 3: node.right also exists in addition to Case 1
        else if (!isNil(node.right) && isNil(node.left.right)){
            node.numLeft = 0;
            node.left.numRight = 2 + node.right.numRight +node.right.numLeft;

        }

        // Case 4: node.right & node.left.right exist in addition to Case 1
        else{
            node.numLeft = 1 + node.left.right.numRight +
                    node.left.right.numLeft;
            node.left.numRight = 3 + node.right.numRight +
                    node.right.numLeft +
                    node.left.right.numRight + node.left.right.numLeft;
        }
        RedBlackNode<T> x = node.left;
        node.left = x.right;

        // Check for existence of x.right
        if (!isNil(x.right))
            x.right.parent = node;
        x.parent = node.parent;

        // node.parent is nil
        if (isNil(node.parent))
            root = x;

            // node is a right child of it's parent.
        else if (node.parent.right == node)
            node.parent.right = x;

            // node is a left child of it's parent.
        else
            node.parent.left = x;
        x.right = node;

        node.parent = x;
    }

    private void leftRotate(RedBlackNode<T> node) {
        // Case 1: Only node, node.right and node.right.right always are not nil.
        if (isNil(node.left) && isNil(node.right.left)){
            node.numLeft = 0;
            node.numRight = 0;
            node.right.numLeft = 1;
        }

        // Case 2: node.right.left also exists in addition to Case 1
        else if (isNil(node.left) && !isNil(node.right.left)){
            node.numLeft = 0;
            node.numRight = 1 + node.right.left.numLeft +
                    node.right.left.numRight;
            node.right.numLeft = 2 + node.right.left.numLeft +
                    node.right.left.numRight;
        }

        // Case 3: node.left also exists in addition to Case 1
        else if (!isNil(node.left) && isNil(node.right.left)){
            node.numRight = 0;
            node.right.numLeft = 2 + node.left.numLeft + node.left.numRight;

        }
        // Case 4: node.left and node.right.left both exist in addition to Case 1
        else{
            node.numRight = 1 + node.right.left.numLeft +
                    node.right.left.numRight;
            node.right.numLeft = 3 + node.left.numLeft + node.left.numRight +
                    node.right.left.numLeft + node.right.left.numRight;
        }

        RedBlackNode<T> y;
        y = node.right;
        node.right = y.left;

        // Check for existence of y.left and make pointer changes
        if (!isNil(y.left))
            y.left.parent = node;
        y.parent = node.parent;

        // node's parent is nul
        if (isNil(node.parent))
            root = y;

            // node is the left child of it's parent
        else if (node.parent.left == node)
            node.parent.left = y;

            // node is the right child of it's parent.
        else
            node.parent.right = y;

        // Finish of the leftRotate
        y.left = node;
        node.parent = y;
    }


    public int calcHeight(){
        return Math.max(root.numLeft, root.numRight);
    }

    private boolean isNil(RedBlackNode nil) {
        return this.nil == nil;
    }


    public void print() {
        try {
            root.printTree(nil);
        } catch (IOException e) {
            System.out.print("Error");
            e.printStackTrace();
        }
    }


}
