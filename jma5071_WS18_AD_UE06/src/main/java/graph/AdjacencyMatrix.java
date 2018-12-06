package graph;

import java.util.Arrays;

public class AdjacencyMatrix implements AdjacencyStructure {
    private BiMap<Vertex, Integer> lookupTable = new BiMap<>();
    private Integer[][] matrix;
    private int currentIndex = 0;
    private int size;
    private boolean resizeable = true;

    public AdjacencyMatrix() {
        this(10);
    }

    public AdjacencyMatrix(int size) {
        matrix = new Integer[size][size];
    }

    public AdjacencyMatrix(int size, boolean resizeable) {
        this(size);
        this.resizeable = resizeable;
    }

    public boolean resize() {
        if (!resizeable) return false;
        try {
            size = size << 1 ;
            Integer[][] resize = new Integer[size][size];
            for (int i = 0; i < matrix.length; i++) {
                System.arraycopy(matrix[i], 0, resize[i], 0, matrix[0].length);
            }
            matrix = resize;
        } catch (OutOfMemoryError e) {
            return false;
        }
        return true;
    }

    public void getEdge(Vertex start, Vertex end) {
        //TODO
    }

    @Override
    public boolean addVertex(Vertex vertex) {
        if (lookupTable.containsK(vertex)) throw new SemanticGraphException("The Vertex already exists");
        if (currentIndex <= size) {
            if (resize()) {
                lookupTable.put(vertex,currentIndex);
                currentIndex++;
            }
        }
        return false;
    }

    @Override
    public boolean addEdge(int startVertex, int endVertex, int weight) {
        return false;
    }

    @Override
    public String toString() {
        return "AdjacencyMatrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
