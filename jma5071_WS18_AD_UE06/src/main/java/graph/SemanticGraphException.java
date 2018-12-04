package graph;

public class SemanticGraphException extends RuntimeException {
    public SemanticGraphException() {
    }

    public SemanticGraphException(String message) {
        super(message);
    }

    public SemanticGraphException(String message, Throwable cause) {
        super(message, cause);
    }

    public SemanticGraphException(Throwable cause) {
        super(cause);
    }

    public SemanticGraphException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
