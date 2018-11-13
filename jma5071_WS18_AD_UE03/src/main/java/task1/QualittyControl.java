package task1;

/**
 * @author Janik Mayr on 30.10.2018
 */
public class QualittyControl {
    public static CheeseStats check(char[][] cheese) {
        Graph graph = new Graph(cheese.length);
        for (int i = 1; i < cheese.length-1; i++) {
            for (int j = 1; j < cheese.length - 1; j++) {
                if (cheese[i][j] == '*') {
                    graph.add(i,j,true);
                    if (cheese[i][j+1] == '*') {
                        graph.add(i,j+1,true);
                    }
                    if (cheese[i][j-1] == '*') {
                        graph.add(i,j-1,true);
                    }
                    if (cheese[i-1][j-1] == '*') {
                        graph.add(i-1,j-1,true);
                    }
                    if (cheese[i-1][j] == '*') {
                        graph.add(i-1,j,true);
                    }
                    if (cheese[i-1][j+1] == '*') {
                        graph.add(i-1,j+1,true);
                    }
                    if (cheese[i+1][j-1] == '*') {
                        graph.add(i+1,j-1,true);
                    }
                    if (cheese[i+1][j] == '*') {
                        graph.add(i+1,j,true);
                    }
                    if (cheese[i+1][j+1] == '*') {
                        graph.add(i+1,j+1,true);
                    }
                }
            }
        }
        CheeseStats stats = new CheeseStats();
        System.out.println(graph.getCountSelfConnecting());
        return stats;
    }

    public static CheeseStats check2(char[][] cheese) {
        boolean isHole = false;
        boolean lastAstrix = false;
        boolean[][] boolCheese;
        boolCheese = new boolean[cheese.length][cheese.length];
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese.length; j++) {
                if (cheese[i][j]=='*') {
                    if (!lastAstrix) isHole = !isHole;
                    lastAstrix = true;
                } else {
                    lastAstrix = false;
                }
                if (isHole) {
                    boolCheese[i][j] = true;
                }
            }
        }
        CheeseStats stats = new CheeseStats();
        int xLim = -1;
        int yLim = -1;
        boolean found = false;
        int i = 0;
        while (i < cheese.length) {
            int j = 0;
            while (j < cheese.length) {
                if (boolCheese[i][j]) {
                    found = true;
                }
                j++;
            }
            if (found) {
               i = xLim + 1;
            }
            i++;
        }
        return stats;
    }

    private boolean isInHoleBounds(int row, int col, boolean[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length && matrix[row][col];
    }
}
