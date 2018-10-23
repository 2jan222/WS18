import org.junit.Assert;
import org.junit.Test;

/**
 * @author Janik Mayr on 24.10.2018
 */
public class AlgorithmTest {
    @Test
    public void testBF(){
        MatcherImplements algo = new BF();
        Assert.assertEquals("0[5]",algo.findFirst("aaaab","aaaab"));
        Assert.assertEquals("No Match Found",algo.findFirst("aaaab","aaaaa"));
        Assert.assertEquals("2[7]",algo.findFirst("aaaab","ccaaaab"));
    }

    @Test
    public void testBM(){
        MatcherImplements algo = new BM();
        Assert.assertEquals("Strings are equal","0[1]",algo.findFirst("aaaab","aaaab"));
        Assert.assertEquals("No match","No Match Found",algo.findFirst("aaaab","aaaaa"));
        Assert.assertEquals("2[7]", algo.findFirst("aaaab","ccaaaab"));
        Assert.assertEquals("35[12]", algo.findFirst("aaaab","cccccccccccccccccccccccccccccddddddaaaab"));
    }
}
