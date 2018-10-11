import org.junit.Test;

import java.util.Random;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class Simulation {
    @Test
    public void bubbleSort() {
        TESTDATA[] input = new TESTDATA[1000];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = new TESTDATA(random.nextInt()%input.length);
        }
        Sorter<TESTDATA> sorter = new Sorter<>();
        TESTDATA[] sort = sorter.sort(input.clone(), new TESTDATAComp(), new BubbleSort());
        printConsole(input,sort,true);
    }
    @Test
    public void quickSort() {
        TESTDATA[] input = new TESTDATA[100000];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = new TESTDATA(random.nextInt()%input.length);
        }
        long time = System.currentTimeMillis();
        Sorter<TESTDATA> sorter = new Sorter<>();
        TESTDATA[] sort = sorter.sort(input.clone(), new TESTDATAComp(), new QuickSort());
        long time2 = System.currentTimeMillis();
        long t3 = time2 -time;
        System.out.println("Milli: " + t3);
        printConsole(input,sort,false);
    }

    private void printConsole(TESTDATA[] unsorted, TESTDATA[] sorted, boolean sort) {
        if (sort) {
            for (int i = 0; i < unsorted.length; i++) {
                System.out.println("INDEX[" + i + "] OLD: " + unsorted[i].number + " NEW: " + sorted[i].number);
            }
        }
    }
}
