package task1and2;


import java.util.List;
import java.util.function.Consumer;

/**
 * @author Janik Mayr on 05.11.2018
 */
public interface Treeable {

    void insertValue(int value);

    void actionInOrder(Consumer<Object> action);
    void actionPreOrder(Consumer<Object> action);
    void actionPostOrder(Consumer<Object> action);
    void actionLevelByLevel(Consumer<Object> action);

    default void printInOrder() {
        actionInOrder(printAction);
    }
    default void printPreOrder() {
        actionPreOrder(printAction);
    }
    default void printPostOrder() {
        actionPostOrder(printAction);
    }
    default void printLevelByLevel() {
        actionLevelByLevel(printAction);
    }

    int calcHeight();

    int calcLeafs();

    Node getRoot();

    List<Node> toNodeList();

    Consumer<Object> printAction = objectOfInterest -> System.out.print(((Node) objectOfInterest).getValue());
}
