import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

class UE05Tester {
    @Test
    @DisplayName("RBTreeTest")
    public void test(){
        RBTree<Integer> tree = new RBTree<>(Integer::compare);
        Random rng = new Random();
        int num = 16;
        for (int i = 0; i < num; i++) {
            tree.insert(Math.abs(rng.nextInt()%num));
        }
        tree.print();
    }
}
