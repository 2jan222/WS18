/**
 * @author Janik Mayr on 07.11.2018
 */
public class NullNode extends AbstrNode {

    public NullNode(Node parent) {
        super(parent,null,null,false);
    }

    public NullNode(Node parent, AbstrNode left, AbstrNode right, boolean isBlack) {
        super(parent, left, right, isBlack);
    }
}
