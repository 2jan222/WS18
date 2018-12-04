package graph;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface AdjacencyStructure {
    default String print() {
        String toString = toString();
        System.out.println(toString);
        return toString;
    }

    boolean addVertex(Vertex vertex);

    default void addAllVertices(Vertex... vertices) {
        Stream.of(vertices).forEach(this::addVertex);
    }

    boolean addEdge(int startVertex, int endVertex, int weight);


}
