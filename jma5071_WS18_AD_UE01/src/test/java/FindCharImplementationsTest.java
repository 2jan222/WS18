import org.junit.Assert;
import org.junit.Test;

/**
 * @author Janik Mayr on 11.10.2018
 */
public class FindCharImplementationsTest {
    @Test
    public void test() {
        String input = "aaaaaaaaaaaabaaa";
        String input2 = "aaabaaaaaaaaaaab";
        Assert.assertEquals(12,FindCharImplementations.findCharLeft(input,'b'));
        Assert.assertEquals(12,FindCharImplementations.findCharRight(input,'b'));
        Assert.assertEquals(3,FindCharImplementations.findCharLeft(input2,'b'));
        Assert.assertEquals(input2.length()-1,FindCharImplementations.findCharRight(input2,'b'));
        Assert.assertEquals(12,FindCharImplementations.findCharRandom(input,'b'));


        Assert.assertEquals(-1,FindCharImplementations.findCharLeft(input,'c'));
        Assert.assertEquals(-1,FindCharImplementations.findCharRight(input,'c'));
        Assert.assertEquals(-1,FindCharImplementations.findCharRandom(input,'c'));
    }
}
