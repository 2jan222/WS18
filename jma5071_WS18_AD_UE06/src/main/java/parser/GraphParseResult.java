package parser;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Janik Mayr on 01.12.2018
 */
public class GraphParseResult {
    private List<ParsedVertex> vertices;
    private List<ParsedEdge> parsedEdges;

    public GraphParseResult(List<ParsedVertex> vertices, List<ParsedEdge> parsedEdges) {
        this.vertices = vertices;
        this.parsedEdges = parsedEdges;
    }

    public GraphParseResult() {
        vertices = new LinkedList<>();
        parsedEdges = new LinkedList<>();
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

    @Override
    public String toString() {
        return "GraphParseResult{" +
                "vertices=" + vertices +
                ", parsedEdges=" + parsedEdges +
                '}';
    }
}
