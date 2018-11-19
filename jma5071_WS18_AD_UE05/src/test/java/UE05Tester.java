import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task1.RBTree;
import task2.HeapHBLT;
import task2.HeapHBLTp;
import task2.HeapNode;

import java.util.Random;

class UE05Tester {
    @Test
    @DisplayName("RBTreeTest")
    public void test(){
        RBTree<Integer> tree = new RBTree<>(Integer::compare);
        Random rng = new Random();
        int num = 20;
        for (int i = 0; i < num; i++) {
            tree.insert(Math.abs(rng.nextInt()%num));
        }
        tree.print();
    }

    @Test
    @DisplayName("HBLT Heap Test")
    public void testHeap(){
        HeapHBLTp<Integer> integerHeapHBLT = new HeapHBLTp<>(Integer::compareTo);
        integerHeapHBLT.insert(3);
        integerHeapHBLT.insert(4);
        ///*
        Random rng = new Random();
        int num = 20;
        for (int i = 0; i < num; i++) {
            integerHeapHBLT.insert(Math.abs(rng.nextInt()%num));
        }
        //*/
        integerHeapHBLT.print();
    }
}
