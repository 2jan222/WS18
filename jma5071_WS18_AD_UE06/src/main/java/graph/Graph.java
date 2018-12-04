package graph;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Graph {
    private AdjacencyStructure structure;

    public Graph(Class<? extends AdjacencyStructure> clazz, int size) {
        System.out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());
        if (clazz.getCanonicalName().equalsIgnoreCase("graph.AdjacencyMatrix")) {
            structure = new AdjacencyMatrix(size);
        } else {
            if (clazz.getCanonicalName().equalsIgnoreCase("graph.AdjacencyList")) {
                structure = new AdjacencyList(size);
            } else {
                throw new RuntimeException("Unknown Subclass");
            }
        }
    }

    public String print() {
        return structure.print();
    }
}
