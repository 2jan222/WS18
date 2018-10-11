import java.util.Comparator;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class Sorter<E> {
    public E[] sort(E[]input, Comparator<E> comp, SortingAlgorithm algo) {
        algo.sort(input,comp);
        return input;
    }
}
