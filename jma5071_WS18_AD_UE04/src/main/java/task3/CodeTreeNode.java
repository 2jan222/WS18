package task3;

/**
 * @author Janik Mayr on 06.11.2018
 */
public class CodeTreeNode {
    CodeTreeNode parent;
    CodeTreeNode zero;
    CodeTreeNode one;
    Character value;

    public CodeTreeNode(CodeTreeNode parent) {
        this.parent = parent;
    }

    public void insert(String path, int index, Character value, boolean forcePut) {
        if (index < path.length()) {
            if (this.value != null) throw new RuntimeException("Value Placed On Non Leave Node");
            Character current = path.charAt(index);
            if (current.equals('1')) {
                if (one == null) one = new CodeTreeNode(this);
                one.insert(path,index+1,value,forcePut);
            } else {
                if (current.equals(('0'))) {
                    if (zero == null) zero = new CodeTreeNode(this);
                    zero.insert(path,index+1,value,forcePut);
                } else {
                    throw new RuntimeException("Path is not 0 or 1. Actual:" + current);
                }
            }
        } else {
            if (this.value != null && !forcePut) throw new RuntimeException("ForcPut violation");
            this.value = value;
        }
    }

    public String decode(String sequence, int index) {
        if (index+1 == sequence.length()){
            Character current = sequence.charAt(index);
            if (current.equals('0')) {
                if (zero == null || zero.value == null){
                    System.out.println(index);
                    throw new RuntimeException("Sequence is not finished.");
                } else {
                    return "" + zero.value;
                }
            } else {
                if (current.equals('1')){
                    if (one== null || one.value == null){
                        System.out.println(index);
                        throw new RuntimeException("Sequence is not finished.");
                    } else {
                        return "" + one.value;
                    }
                } else {
                    throw new RuntimeException("Path is not 0 or 1. Actual:" + current);
                }
            }
        } else {
            if (this.value != null) {
                return this.getTopRoot().decode(sequence, index) + this.value;
            } else {
                Character current = sequence.charAt(index);
                if (current.equals('0')) {
                    return zero.decode(sequence,index+1);
                } else {
                    if (current.equals('1')){
                        return one.decode(sequence, index+1);
                    } else {
                        throw new RuntimeException("Path is not 0 or 1. Actual:" + current);
                    }
                }
            }
        }
    }

    private CodeTreeNode getTopRoot() {
        if (parent != null) {
            return parent.getTopRoot();
        } else {
            return this;
        }
    }
}
