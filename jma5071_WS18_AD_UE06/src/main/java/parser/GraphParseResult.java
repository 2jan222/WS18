package parser;

import java.util.List;

/**
 * @author Janik Mayr on 01.12.2018
 */
public class GraphParseResult {
    List<ParsedVertex> vertices;
    List<ParsedEdge> parsedEdges;

    public GraphParseResult(List<ParsedVertex> vertices, List<ParsedEdge> parsedEdges) {
        this.vertices = vertices;
        this.parsedEdges = parsedEdges;
    }

    public List<ParsedVertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<ParsedVertex> vertices) {
        this.vertices = vertices;
    }

    public List<ParsedEdge> getParsedEdges() {
        return parsedEdges;
    }

    public void setParsedEdges(List<ParsedEdge> parsedEdges) {
        this.parsedEdges = parsedEdges;
    }
}
