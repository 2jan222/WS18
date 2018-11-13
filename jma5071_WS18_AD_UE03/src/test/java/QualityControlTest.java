import org.junit.jupiter.api.Test;
import task1.QualittyControl;

/**
 * @author Janik Mayr on 30.10.2018
 */
public class QualityControlTest {
    @Test
    void numberOfSinglePoints() {
        char[][] mat = new char[][]{
                "+----+".toCharArray(),
                "|*---|".toCharArray(),
                "|----|".toCharArray(),
                "|---*|".toCharArray(),
                "|----|".toCharArray(),
                "+----+".toCharArray()};
        QualittyControl.check(mat);
    }
}
