package Easy;

import java.util.Arrays;

public class CreateGridWithExactlyOnePath {
    public String[] createGrid(int m, int n) {
        char[][] matrix = new char[m][n];
        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';

                if (j != 0 && i != m - 1) {
                    matrix[i][j] = '#';
                }
            }

            result[i] = new String(matrix[i]);
        }

        return result;
    }
}

class TestCreateGridWithExactlyOnePath {
    static void main(String[] args) {
        CreateGridWithExactlyOnePath test = new CreateGridWithExactlyOnePath();

        int[][] cases = {
                {2, 3}, {3, 3}, {1, 4}
        };

        for (var c : cases) {
            var result = test.createGrid(c[0], c[1]);
            System.out.println(Arrays.toString(result));
        }
    }
}
