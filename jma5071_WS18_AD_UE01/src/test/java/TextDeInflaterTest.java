import org.junit.Assert;
import org.junit.Test;

/**
 * @author Janik Mayr on 11.10.2018
 */
public class TextDeInflaterTest {
    @Test
    public void test(){
        String input = "CCCCCCCCCCCBBB12333D";
        String deflate = TextDeInflater.deflate(input);
        String inflate = TextDeInflater.inflate(deflate);
        System.out.println("[INPUT]  " + input);
        System.out.println("[DEFLATE]" + deflate);
        System.out.println("[INFLATE]" + inflate);
        Assert.assertEquals(input, inflate);
    }
}
