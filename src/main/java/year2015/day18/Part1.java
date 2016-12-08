package year2015.day18;

import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {

        boolean[][] grid = getData();

        for (int k = 0; k < 100; k++) {
            boolean[][] iteration = emptyGrid();
            for (int i = 0; i < iteration.length; i++) {
                for (int j = 0; j < iteration[i].length; j++) {
                    int neiOn = countOnNeigbours(grid, i, j);
                    if (grid[i][j]) {
                        if (neiOn == 2 || neiOn == 3) {
                            iteration[i][j] = true;
                        }
                    } else {
                        if (neiOn == 3) {
                            iteration[i][j] = true;
                        }
                    }
                    if (i == 0 && (j == 0 || j == 99)
                            || i == 99 && (j == 0 || j == 99)) {
                        iteration[i][j] = true;
                    }
                }
            }
            grid = iteration;
        }

        System.out.println(countOn(grid));

    }

    private static int countOn(boolean[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int countOnNeigbours(boolean[][] grid, int i, int j) {
        int result = 0;
        if (getValue(grid, i - 1, j - 1)) {
            result++;
        }
        if (getValue(grid, i - 1, j)) {
            result++;
        }
        if (getValue(grid, i - 1, j + 1)) {
            result++;
        }

        if (getValue(grid, i, j - 1)) {
            result++;
        }
        if (getValue(grid, i, j + 1)) {
            result++;
        }

        if (getValue(grid, i + 1, j - 1)) {
            result++;
        }
        if (getValue(grid, i + 1, j)) {
            result++;
        }
        if (getValue(grid, i + 1, j + 1)) {
            result++;
        }

        return result;

    }

    private static boolean getValue(boolean[][] grid, int i, int j) {
        if (i < 0 || i > 99 || j < 0 || j > 99) {
            return false;
        }
        if (i == 0 && (j == 0 || j == 99)
                || i == 99 && (j == 0 || j == 99)) {
            return true;
        }
        return grid[i][j];

    }

    public static boolean[][] getData() {
        boolean[][] result = emptyGrid();

        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day18-input"))) {
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    result[i][j] = line.charAt(j) == '#';
                }
                i++;
            }
        }
        return result;
    }

    public static boolean[][] emptyGrid() {
        boolean[][] result = new boolean[100][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new boolean[100];
        }
        return result;
    }
}
