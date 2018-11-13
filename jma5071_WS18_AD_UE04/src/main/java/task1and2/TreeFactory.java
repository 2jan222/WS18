package task1and2;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author Janik Mayr on 06.11.2018
 */
public class TreeFactory {
    private static final TreeFactory singleton = new TreeFactory();

    public static BiFunction<String,Supplier<Integer[]>,Tree> getTreeInstance(){
        return (input,valueSupplier) -> {
            int[] unboxedValues = Arrays.stream(valueSupplier.get()).mapToInt(i -> i).toArray();
            switch (input.toLowerCase()) {
                case "binarysearchtree": return BinarySearchTree.getInstance(unboxedValues);
                case "binarytree": return BinaryTree.getInstance(unboxedValues);
                case "codetree": return null;
                default: return null;
            }
        };
    }
    public static Supplier<TreeFactory> getSupplier(){
        return () -> TreeFactory.singleton;
    }

    public static TreeFactory getInstance(){
        return singleton;
    }
}
