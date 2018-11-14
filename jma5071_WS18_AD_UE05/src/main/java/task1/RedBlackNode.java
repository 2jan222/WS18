package task1;

import java.io.IOException;
import java.util.function.Function;

/**
 * @author Janik Mayr on 07.11.2018
 */
public class RedBlackNode<T> {

    T key;
    RedBlackNode<T> parent;
    RedBlackNode<T> left,right;
    int numLeft, numRight;
    boolean isBlack;

    Function<RedBlackNode,RedBlackNode> uncle = (var n1) -> {
        if (parent!= null) {
            if (parent.left == n1) {
                return parent.right;
            } else {
                if (parent.right == n1) {
                    return parent.left;
                } else {
                    throw new RuntimeException("task1.RedBlackNode is not a child of its parent");
                }
            }
        } else {
            throw new RuntimeException("task1.RedBlackNode has no parent. Is Root");
        }
    };

    public RedBlackNode() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.isBlack = true;
        this.numLeft = 0;
        this.numRight = 0;
    }

    public RedBlackNode(T key) {
        this();
        this.key = key;
    }

    public void printTree(RedBlackNode nil) throws IOException {
        if (right != nil) {
            right.printTree(true, "",nil);
        }
        printNodeValue(nil);
        if (left != nil) {
            left.printTree(false, "",nil);
        }
    }
    private void printNodeValue(RedBlackNode nil) throws IOException {
        if (key == null) {
            System.out.print("<null>");
        } else {
            System.out.print("V:" + key.toString() + " C:" + isBlackToString());
        }
        System.out.print('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(boolean isRight, String indent, RedBlackNode nil) throws IOException {
        if (right != nil) {
            right.printTree( true, indent + (isRight ? "        " : " |      "),nil);
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(nil);
        if (left != nil) {
            left.printTree( false, indent + (isRight ? " |      " : "        "),nil);
        }
    }

    private String isBlackToString() {
        return (isBlack) ? "B":"R";
    }
}
