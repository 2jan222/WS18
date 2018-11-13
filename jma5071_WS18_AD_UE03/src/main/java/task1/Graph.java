package task1;

/**
 * @author Janik Mayr on 30.10.2018
 */
public class Graph {
    private final int[][] matrix;



    public Graph(final int size) {
        matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public Graph add(int start, int end, boolean bidirectional) {
        matrix[start][end] = 1;
        if (bidirectional) matrix[end][start] = 1;
        return this;
    }

    public String getSimpleCircularPaths() {
        return "";
    }

    public int getCountSelfConnecting() {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != -1) {
                for (int j = 0; j < matrix.length; j++) {
                    if (i != j) {
                        if (matrix[i][j] == 1) count--;
                    }
                }
                count++;
            }
        }
        return count;
    }


}
