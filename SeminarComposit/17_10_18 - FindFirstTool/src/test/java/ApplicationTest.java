import org.junit.Test;

/**
 * @author Janik Mayr on 24.10.2018
 */
public class ApplicationTest {
    @Test
    public void applicationTest() {
        FindFirstCommandLine.main("-p","hendrerit","-f","D:\\Bibliotheken (D)\\Java Projects\\WS18\\SeminarComposit\\17_10_18 - FindFirstTool\\src\\test\\resources\\text.txt","-a","BF");
        FindFirstCommandLine.main("-p","hendrerit","-f","D:\\Bibliotheken (D)\\Java Projects\\WS18\\SeminarComposit\\17_10_18 - FindFirstTool\\src\\test\\resources\\text.txt","-a","BM");
        //FindFirstCommandLine.main("-p","hendrerit","-f","SeminarComposit/17_10_18 - FindFirstTool/src/test/resources/text.txt","-a","KMP");
    }
}
