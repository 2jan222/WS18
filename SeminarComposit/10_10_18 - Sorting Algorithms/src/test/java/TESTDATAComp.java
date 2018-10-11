import java.util.Comparator;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class TESTDATAComp implements Comparator<TESTDATA> {
    @Override
    public int compare(TESTDATA o1, TESTDATA o2) {
        if (o1.number == o2.number) {
            return 0;
        } else {
            if (o1.number < o2.number) {
                return -1;
            } else {
                return  1;
            }
        }
    }
}
