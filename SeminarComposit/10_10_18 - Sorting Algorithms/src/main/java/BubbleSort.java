import java.util.Comparator;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(Object[] input, Comparator comparator) {
        for (int i = input.length; i >0; i--) {
            for(int j = 0; j < i-1; j++) {
                if (comparator.compare(input[j], input[j + 1]) > 0) {
                    Object temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }
}
