import graph.AdjacencyList;
import graph.AdjacencyMatrix;
import graph.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parser.*;

import java.util.Comparator;
import java.util.List;

public class UE06Tester {
    Comparator<ParsedEdge> edgeComparator = (e1, e2) -> (e1.getStart()==e2.getStart() && e2.getEnd() == e2.getEnd() && e1.getWeight() == e2.getWeight())? 0:-1;
    Comparator<ParsedVertex> vertexComparator = (v1, v2) -> (v1.getNumber() == v2.getNumber())? 0:-1;

    @Test
    @DisplayName("Tests for Lexer")

    public void lexerTest() {
        Lexer lexer = new Lexer();
        String text = "V={454,5\t} ;E={(2,2,-2),(3,2,3)};;";
        List<Token> lex = lexer.lex(text, 0);
        for (Token t : lex) {
            System.out.println(t.toString());
        }
    }

    @Test
    void graphPrint() {
        Graph graph = new Graph(AdjacencyList.class, 4);
        graph.print();
    }

    @Test
    void parserTest() {
        List<Token> lex = rightTokens();
        GraphBuilderParser parser = new GraphBuilderParser();
        GraphParseResult parse = parser.parse(lex);
        System.out.println("parse.getParsedEdges().size() = " + parse.getParsedEdges().size());
        System.out.println("parse.getVertices().size(); = " + parse.getVertices().size());
    }

    private List<Token> rightTokens() {
        String text = "V={454,5\t} ;E={(2,2,2),(3,2,3)};;";
        return new Lexer().lex(text, 0);
    }

    private List<Token> wrongTokens(TokenType error) {
        String text = null;
        switch (error) {
            case COMMA:
                text = "V={(454,,   5\t} ;E={(2,2,  2),(3,2,3)};;";
                break;
            case SEMICOLON:
                text = "V={(454,   5\t} E={(2,2,  2),(3,2,3)};;";
                break;
            case OPEN_CURLY:
                text = "V={(454,5\t} ;E={(2,2,2),(3,2,3)};;";
                break;
            case CLOSE_CURLY:
                text = "V={454,5\t} ;E={(2,2,2),(3,2,3);;";
                break;
            case OPEN_BRACKET:
                text = "V={454,5\t} ;E={2,2,2),(3,2,3)};;";
                break;
            case CLOSE_BRACKET:
                text = "V={454,5\t} ;E={(2,2,2,(3,2,3)};;";
                break;
            case MINUS:
                text = "V={454,5\t} ;E={(--2,2,2),(3,2,3)};;";
                break;
            case NUMBER:
                text = "V={,5\t} ;E={(2,2,2),(3,2,3)};;";
                break;
            case EDGE_IDENTIFIER:
                text = "V={454,5\t} ;={(2,2,2),(3,2,3)};;";
                break;
            case VERTEX_IDENTIFIER:
                text = "={454,5\t} ;E={(2,2,2),(3,2,3)};;";
                break;
            case EQUALITY_SIGN:
                text = "V{454,5\t} ;E{(2,2,2),(3,2,3)};;";
                break;
            default:
                text = "There is no token";
                break;
        }
        return new Lexer().lex(text, 0);
    }
}
