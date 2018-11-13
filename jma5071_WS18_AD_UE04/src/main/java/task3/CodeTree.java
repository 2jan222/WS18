package task3;

/**
 * @author Janik Mayr on 06.11.2018
 */
public class CodeTree {
    CodeTreeNode root = new CodeTreeNode(null);

    public CodeTree insert(String path, Character value) {
        return insert(path, value, false);
    }

    public CodeTree insert(String path, Character value, boolean forcePut) {
        root.insert(path,0,value,forcePut);
        return this;
    }

    public String decode(final String sequence) {
        return new StringBuilder(root.decode(sequence,0)).reverse().toString();
    }

    public static String decode(final String sequence,final CodeTree tree) {
        return tree.decode(sequence);
    }
}
