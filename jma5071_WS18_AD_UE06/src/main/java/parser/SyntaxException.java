package parser;

/**
 * @author Janik Mayr on 01.12.2018
 */
public class SyntaxException extends RuntimeException {
    public SyntaxException() {
    }

    public SyntaxException(String message) {
        super(message);
    }
}
