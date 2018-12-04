package parser;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Janik Mayr on 04.12.2018
 */
public class GraphBuilderParser {
    @SuppressWarnings("Duplicates")
    public GraphParseResult parse(List<Token> tokens) {
        LinkedList<Token> tokenList = (LinkedList<Token>) tokens;
        GraphParseResult graphParseResult = new GraphParseResult();

        Token t = tokenList.removeFirst();
        if (t.getType() == TokenType.VERTEX_IDENTIFIER) {
            t = tokenList.removeFirst();
            if (t.getType() == TokenType.EQUALITY_SIGN) {
                t = tokenList.removeFirst();
                if (t.getType() == TokenType.OPEN_CURLY) {
                    t = tokenList.removeFirst();
                    if (t.getType() == TokenType.NUMBER) {
                        graphParseResult.getVertices().add(new ParsedVertex(Integer.parseInt(t.getText())));
                        t = tokenList.removeFirst();
                        while (t.getType() == TokenType.COMMA) {
                            t = tokenList.peekFirst();          //TODO Wirklich gebraucht ? Fehlschlagender Peek -> Error
                            if (t.getType() == TokenType.NUMBER) {
                                t = tokenList.removeFirst();
                                graphParseResult.getVertices().add(new ParsedVertex(Integer.parseInt(t.getText())));
                            }
                        }
                        t = tokenList.removeFirst();
                        if (t.getType() == TokenType.CLOSE_CURLY) {
                            t = tokenList.removeFirst();
                            if (t.getType() == TokenType.SEMICOLON) {
                                t = tokenList.removeFirst();
                                if (t.getType() == TokenType.EDGE_IDENTIFIER) {
                                    t = tokenList.removeFirst();
                                    if (t.getType() == TokenType.EQUALITY_SIGN) {
                                        t = tokenList.removeFirst();
                                        if (t.getType() == TokenType.OPEN_CURLY) {
                                            t = tokenList.removeFirst();    //Start, End, Weight {, Start, End, Weight}
                                            int start, end, weight;
                                            if (t.getType() == TokenType.OPEN_CURLY || t.getType() == TokenType.OPEN_BRACKET) {
                                                TokenType tupleClose = (t.getType() == TokenType.OPEN_CURLY) ? TokenType.CLOSE_CURLY:TokenType.CLOSE_BRACKET;
                                                t = tokenList.removeFirst();
                                                if (t.getType() == TokenType.NUMBER) {  //START
                                                    start = Integer.parseInt(t.getText());
                                                    t = tokenList.removeFirst();
                                                    if (t.getType() == TokenType.COMMA) {
                                                        t = tokenList.removeFirst();
                                                        if (t.getType() == TokenType.NUMBER) { //END
                                                            end = Integer.parseInt(t.getText());
                                                            t = tokenList.removeFirst();
                                                            if (t.getType() == TokenType.COMMA) {
                                                                t = tokenList.removeFirst();
                                                                int minus = 1;
                                                                if (t.getType() == TokenType.MINUS) {   //Minus is optional
                                                                    minus = -1;
                                                                    t = tokenList.removeFirst();
                                                                }
                                                                if (t.getType() == TokenType.NUMBER) { //WEIGHT
                                                                    weight = minus * Integer.parseInt(t.getText());
                                                                    t = tokenList.removeFirst();
                                                                    if (t.getType() == tupleClose) {
                                                                        graphParseResult.getParsedEdges().add(new ParsedEdge(start, end, weight));
                                                                        if (tupleClose == TokenType.CLOSE_CURLY) {
                                                                            graphParseResult.getParsedEdges().add(new ParsedEdge(end, start, weight));
                                                                        }
                                                                        t = tokenList.removeFirst();

                                                                        while (t.getType() == TokenType.COMMA) {
                                                                            t = tokenList.removeFirst();
                                                                            if (t.getType() == TokenType.OPEN_CURLY || t.getType() == TokenType.OPEN_BRACKET) {
                                                                                tupleClose = (t.getType() == TokenType.OPEN_CURLY) ? TokenType.CLOSE_CURLY:TokenType.CLOSE_BRACKET;
                                                                                t = tokenList.removeFirst();
                                                                                if (t.getType() == TokenType.NUMBER) {  //START
                                                                                    start = Integer.parseInt(t.getText());
                                                                                    t = tokenList.removeFirst();
                                                                                    if (t.getType() == TokenType.COMMA) {
                                                                                        t = tokenList.removeFirst();
                                                                                        if (t.getType() == TokenType.NUMBER) { //END
                                                                                            end = Integer.parseInt(t.getText());
                                                                                            t = tokenList.removeFirst();
                                                                                            if (t.getType() == TokenType.COMMA) {
                                                                                                t = tokenList.removeFirst();
                                                                                                minus = 1;
                                                                                                if (t.getType() == TokenType.MINUS) {   //Minus is optional
                                                                                                    minus = -1;
                                                                                                    t = tokenList.removeFirst();
                                                                                                }
                                                                                                if (t.getType() == TokenType.NUMBER) { //WEIGHT
                                                                                                    weight = minus * Integer.parseInt(t.getText());
                                                                                                    t = tokenList.removeFirst();
                                                                                                    if (t.getType() == tupleClose) {
                                                                                                        graphParseResult.getParsedEdges().add(new ParsedEdge(start, end, weight));
                                                                                                        if (tupleClose == TokenType.CLOSE_CURLY) {
                                                                                                            graphParseResult.getParsedEdges().add(new ParsedEdge(end, start, weight));
                                                                                                        }
                                                                                                        t = tokenList.removeFirst();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }

                                                                        if (t.getType() == TokenType.CLOSE_CURLY) {
                                                                            t = tokenList.removeFirst();
                                                                            if (t.getType() == TokenType.SEMICOLON) {
                                                                                t = tokenList.removeFirst();
                                                                                if (t.getType() == TokenType.SEMICOLON) {
                                                                                    return graphParseResult;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (t.getType() == TokenType.CLOSE_CURLY) {
                                                    t = tokenList.removeFirst();
                                                    if (t.getType() == TokenType.SEMICOLON) {
                                                        t = tokenList.removeFirst();
                                                        if (t.getType() == TokenType.SEMICOLON) {
                                                            return graphParseResult;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        throw new SyntaxException("Wrong Token. Passed Token:" + t.toString());
    }
}