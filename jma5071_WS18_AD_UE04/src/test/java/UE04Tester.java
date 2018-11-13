import org.junit.jupiter.api.*;
import task1and2.BinarySearchTree;
import task1and2.BinaryTree;
import task1and2.Node;
import task1and2.TreeFactory;
import task3.CodeTree;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Janik Mayr on 05.11.2018
 */
class UE04Tester {
    private Supplier<Integer[]> valueSupplier1 = () -> new Integer[]{4, 7, 1, 3, 9, 0, 2, 3, 6, 8};
    static StringBuilder treeSemanticMemory = new StringBuilder();

    @DisplayName("Tests for Task #1")
    @Nested
    class UE04Task1 {
        BinaryTree tree;

        @BeforeEach
        public void generate(TestInfo info) {
            tree = (BinaryTree) TreeFactory.getTreeInstance().apply("BinaryTree", valueSupplier1);
            System.out.println("\n[Start] " + info.getDisplayName());
            String hey = "hey";
            String repeat = hey.repeat(5);
            System.out.println("repeat = " + repeat);
        }

        @AfterEach
        public void finish(TestInfo info) {
            System.out.println("\n[End]   " + info.getDisplayName());
        }

        @Test
        @DisplayName("HeightCheck")
        void heightCheck() {
            assertEquals(4, tree.calcHeight());
        }

        @Test
        @DisplayName("LeafsCheck")
        void leafsCheck() {
            assertEquals(5, tree.calcLeafs());
        }

        @Test
        @DisplayName("Print Tree")
        void printTree() {
            System.out.println("\n");
            tree.printLevelByLevel();
        }

        Consumer<Object> consumerForSemanticStringChecks = objectOfInterest -> UE04Tester.treeSemanticMemory.append(((Node) objectOfInterest).getValue());

        @Test
        @DisplayName("Print Tree Semantic")
        void printTreeSemantic() {
            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.actionLevelByLevel(consumerForSemanticStringChecks);
            assertEquals("4713902368", UE04Tester.treeSemanticMemory.toString());
        }

        @Test
        @DisplayName("To SearchTree")
        void toSearchTree() {
            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.toSearchTree().actionInOrder(consumerForSemanticStringChecks);
            StringBuilder sb = new StringBuilder();
            Arrays.stream(valueSupplier1.get()).sorted().forEachOrdered(sb::append);
            assertEquals(sb.toString(), UE04Tester.treeSemanticMemory.toString());
        }
    }

    @DisplayName("Tests for Task #2")
    @Nested
    class UE04Task2 {
        BinarySearchTree tree;
        @BeforeEach
        public void generate(TestInfo info) {
            tree = (BinarySearchTree) TreeFactory.getTreeInstance().apply("BinarySearchTree", valueSupplier1);
            System.out.println("\n[Start] " + info.getDisplayName());
        }

        @AfterEach
        public void finish(TestInfo info) {
            System.out.println("\n[End]   " + info.getDisplayName());
        }

        @Test
        @DisplayName("HeightCheck")
        void heightCheck() {
            assertEquals(5, tree.calcHeight());
        }

        @Test
        @DisplayName("LeafsCheck")
        void leafsCheck() {
            assertEquals(4, tree.calcLeafs());
        }


        Consumer<Object> consumerForSemanticStringChecks = objectOfInterest -> UE04Tester.treeSemanticMemory.append(((Node) objectOfInterest).getValue());

        @Test
        @DisplayName("Print Tree Semantic")
        void printTreeSemantic() {
            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.actionInOrder(consumerForSemanticStringChecks);
            StringBuilder sb = new StringBuilder();
            Arrays.stream(valueSupplier1.get()).sorted().forEachOrdered(sb::append);
            assertEquals(sb.toString(), UE04Tester.treeSemanticMemory.toString());

            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.actionLevelByLevel(consumerForSemanticStringChecks);
            assertEquals("4170369283", UE04Tester.treeSemanticMemory.toString(), "Hard Coded Test");

            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.actionPreOrder(consumerForSemanticStringChecks);
            assertEquals("4103237698", UE04Tester.treeSemanticMemory.toString(), "Hard Coded Test");

            UE04Tester.treeSemanticMemory.delete(0, UE04Tester.treeSemanticMemory.length());
            tree.actionPostOrder(consumerForSemanticStringChecks);
            assertEquals("0323168974", UE04Tester.treeSemanticMemory.toString(), "Hard Coded Test");
        }

        @Test
        @DisplayName("All Prints")
        void task2() {
            System.out.println("In Order");
            tree.printInOrder();
            System.out.println("\nLevel By Level");
            tree.printLevelByLevel();
            System.out.println("\nPost Order");
            tree.printPostOrder();
            System.out.println("\nPre Order");
            tree.printPreOrder();
        }

    }

    @DisplayName("Tests for Task #3")
    @Nested
    class UE04Task3 {
        @BeforeEach
        public void generate(TestInfo info) {
            System.out.println("\n[Start] " + info.getDisplayName());
        }

        @AfterEach
        public void finish(TestInfo info) {
            System.out.println("\n[End]   " + info.getDisplayName());
        }

        @Test
        @DisplayName("Insert & Decode Test")
        void task3() {
            CodeTree codeTree = new CodeTree();
            codeTree.insert("1011", 'S').insert("0", 'E').insert("100", 'N').insert("11", 'T').insert("1010", 'I');
            assertEquals("S", codeTree.decode("1011"));
            assertEquals("E", codeTree.decode("0"));
            assertEquals("N", codeTree.decode("100"));
            assertEquals("T", codeTree.decode("11"));
            assertEquals("SENT", codeTree.decode("1011010011"));
            assertEquals("TENNIS", codeTree.decode("11010010010101011"));
            assertEquals("NEST", codeTree.decode("1000101111"));
        }
    }
}