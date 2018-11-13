import java.util.function.Function;

/**
 * @author Janik Mayr on 07.11.2018
 */
public abstract class AbstrNode implements RBNode {
    Node parent;
    AbstrNode left,right;
    boolean isBlack;
    Function<Node,AbstrNode> uncle = (var n1) -> {
        if (parent!= null) {
            if (parent.left == n1) {
                return parent.right;
            } else {
                if (parent.right == n1) {
                    return parent.left;
                } else {
                    throw new RuntimeException("Node is not a child of its parent");
                }
            }
        } else {
            throw new RuntimeException("Node has no parent. Is Root");
        }
    };

    public AbstrNode(Node parent, AbstrNode left, AbstrNode right, boolean isBlack) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.isBlack = isBlack;
    }


}
