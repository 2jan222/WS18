package parser;

public class Token {
    private TokenType type;
    private String text;
    private ValuePair<Integer, Integer> textRegion;

    public Token(TokenType type, String text, int regionStart, int regionEnd) {
        this(type, text,new ValuePair<>(regionStart, regionEnd));
    }

    public Token(TokenType type, String text, ValuePair<Integer, Integer> textRegion) {
        this.type = type;
        this.text = text;
        this.textRegion = textRegion;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ValuePair<Integer, Integer> getTextRegion() {
        return textRegion;
    }

    public void setTextRegion(ValuePair<Integer, Integer> textRegion) {
        this.textRegion = textRegion;
    }

    @Override
    public String toString() {
        return "Token{" + "type=" + type + ", text='" + text + "\', textRegion=" + textRegion.toString() + '}';
    }
}
