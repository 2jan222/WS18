import org.junit.Test;

/**
 * @author Janik Mayr on 24.10.2018
 */
public class Tester {
    @Test
    public void algorithmTest(){
        AlgorithmTest algorithmTest = new AlgorithmTest();
        algorithmTest.testBF();
        algorithmTest.testBM();
    }

    @Test
    public void applicationTest(){
        ApplicationTest applicationTest = new ApplicationTest();
        applicationTest.applicationTest();
    }
}
