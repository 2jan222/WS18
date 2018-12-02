package parser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Janik Mayr on 01.12.2018
 */
public class GraphBuilderParser {
    private String workingString;
    private int position;
    public void parseGraphFromFile(File input) {
        //TODO read file and turn into string parser method;
    }

    public GraphParseResult parseGraphFromString(final String input) {
        workingString = input;
        position = 0;
        List<ParsedVertex> vertices = vertices();
        List<ParsedEdge> parsedEdges = edges();
        if (!expect(';')) {
            throw new SyntaxException("Finishing semicolon missing");
        }
        return new GraphParseResult(vertices, parsedEdges);
    }

    private char nextChar() {
        position++;
        if (workingString.length() == position) throw new SyntaxException("End of input reached");
        else return workingString.charAt(position);
    }

    /**
     * Checks if current char is the expected char.
     * @param ch expected char
     * @return true, if current and expected are the same
     */
    private boolean expect(char ch) {
        return (getCurrentChar() == ch);
    }

    private List<ParsedVertex> vertices() {
        LinkedList<ParsedVertex> vertices = new LinkedList<>();
        expectSequence("V={");
        //TODO Get Vertices
        expectSequence("};");
        return vertices;
    }

    private List<ParsedEdge> edges() {
        LinkedList<ParsedEdge> parsedEdges = new LinkedList<>();
        expectSequence("E={");
        //TODO Get Edges
        expectSequence("};");
        return parsedEdges;
    }

    private ParsedEdge[] edge(){
        boolean directed = false;
        ParsedEdge[] rValue;

        if (expect('(')) {
            directed = true;
        } else {
            if (!expect('{')) {
                throw new SyntaxException("Node definition started with unexpected character");
            }
        }


        //TODO Get Start
        int start = 0;
        //TODO Get End
        int end = 0;
        //TODO Get Weight
        int weight = 0;

        if (directed) {
            if (expect(')')) {
                rValue = new ParsedEdge[]{new ParsedEdge(start, end, weight)};
            } else {
                throw new SyntaxException("Node definition ended with unexpected character or wrong closing parenthesis. Expected: ) Actual:" + getCurrentChar());
            }
        } else {
            if (expect('}')) {
                rValue = new ParsedEdge[]{new ParsedEdge(start, end, weight), new ParsedEdge(end, start, weight)};
            } else {
                throw new SyntaxException("Node definition ended with unexpected character or wrong closing parenthesis. Expected: } Actual:" + getCurrentChar());
            }
        }
        //End Close Edge
        return rValue;
    }

    private ParsedVertex node() {
        return null; //TODO retrieve number and return
    }

    private int extractNumber() {
        int start = position;
        if (isDigit(getCurrentChar())) {
            char c = nextChar();
            while (isDigitWithZero(c)) {
                c = nextChar();
            }
        }
        return Integer.parseInt(workingString, start, position, 10);
    }

    private void expectSequence(final String sequence) {
        for (Character ch: sequence.toCharArray()) {
            if (!expect(ch)){
                throw new SyntaxException("Unexpected character. Details: [Expected]=" + ch + "|| [Actual]=" + getCurrentChar());
            }
            nextChar();
        }
    }

    private char getCurrentChar() {
        if (workingString.length() == position) throw new SyntaxException("End of input reached");
        return workingString.charAt(position);
    }

    private boolean isDigitWithZero(final char c) {
        return (c == '0') || isDigit(c);
    }

    private boolean isDigit(final char c) {
        return (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9');
    }
}
