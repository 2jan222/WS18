package parser;

import fileReader.FileReader;
import org.jetbrains.annotations.Contract;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Lexer {
    public List<Token> lexFromFile(String path, @SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<Charset> charset) throws IOException {
        String text;
        if (charset.isPresent()) {
            text = FileReader.readFile(path, charset.get());
        } else {
            text = FileReader.readFile(path);
        }
        return lex(text,0);
    }

    @Contract("null,_ -> null; !null,_ -> _")
    public List<Token> lex(String text, int indexStart) {
        if (text == null||text.equals("")) return null;
        LinkedList<Token> tokens = new LinkedList<>();
        while (indexStart < text.length()) {
            Token t = getLexeme(text, indexStart);
            assert t != null;
            tokens.addLast(t);
            indexStart = t.getTextRegion().getValue2() + 1;
        }
        return tokens;
    }

    @Contract("null,_ -> null; !null,_ -> _")
    private Token getLexeme(String text, int indexStart) {
        if (text == null||text.equals("")) return null;
        int currentPos = indexStart;
        TokenType currentType = null;
        StringBuilder sb = new StringBuilder();
        while (currentPos < text.length()) {
            char ch = text.charAt(currentPos);
            if (ch != '\t' && ch != ' ' && ch != '\n') { //Ignore indent, line break and whitespace
                if (currentType == TokenType.NUMBER) { //When last Type is a NUMBER a new one gets added.
                    if (ch >= '0' && ch <= '9') {
                        sb.append(ch);
                    } else {
                        return new Token(TokenType.NUMBER, sb.toString(), indexStart, currentPos - 1); //pos-1 because the current num was not evaluated yet
                    }
                } else {
                    switch (ch) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            sb.append(ch);
                            currentType = TokenType.NUMBER;
                            break;
                        case 'V':
                            return new Token(TokenType.VERTEX_IDENTIFIER, "V", indexStart, currentPos);
                        case 'E':
                            return new Token(TokenType.EDGE_IDENTIFIER, "E", indexStart, currentPos);
                        case '{':
                            return new Token(TokenType.OPEN_CURLY, "{", indexStart, currentPos);
                        case '}':
                            return new Token(TokenType.CLOSE_CURLY, "}", indexStart, currentPos);
                        case '(':
                            return new Token(TokenType.OPEN_BRACKET, "(", indexStart, currentPos);
                        case ')':
                            return new Token(TokenType.CLOSE_BRACKET, ")", indexStart, currentPos);
                        case '=':
                            return new Token(TokenType.EQUALITY_SIGN, "=", indexStart, currentPos);
                        case ';':
                            return new Token(TokenType.SEMICOLON, ";", indexStart, currentPos);
                        case '-':
                            return new Token(TokenType.MINUS, "-", indexStart, currentPos);
                        case ',':
                            return new Token(TokenType.COMMA, ",", indexStart, currentPos);
                        default:
                            throw new SyntaxException("Unknown Symbol found Symbol = " + ch + " - at position = " + currentPos);
                    }
                }
            }
            currentPos++;
        }
        if (currentType == TokenType.NUMBER) {
            return new Token(TokenType.NUMBER, sb.toString(), indexStart, currentPos);
        }
        return null;
    }

}
