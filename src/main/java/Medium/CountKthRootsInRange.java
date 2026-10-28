package Medium;

public class CountKthRootsInRange {
    public int countKthRoots(int l, int r, int k) {
        int result = 0;
        int i = l == 0 ? 0 : 1;

        if (k == 1) { return (r + 1) - l; }

        for (; i <= r; i++) {
            int exponentiation = Math.powExact(i, k);

            if (exponentiation > r) {
                break;
            }

            if (exponentiation >= l) {
                result++;
            }
        }

        return result;
    }
}

class TestCountKthRootsInRange {
    static void main(String[] args) {
        CountKthRootsInRange test = new CountKthRootsInRange();

        int[][] cases = {
                {1, 9, 3, 2},
                {8, 30, 2, 3},
                {1, 9, 1, 9},
                {5, 5, 1, 1},
                {0, 0, 2, 1},
                {0, 1, 2, 2},
                {0, 10, 3, 3},
                {10, 15, 2, 0},
                {2, 3, 2, 0},
                {9, 9, 2, 1},
                {8, 8, 3, 1},
                {1, 100, 3, 4},
                {1, 100, 4, 3},
                {1, 100, 5, 2},
                {1, 100, 30, 1},
                {1, 1_000_000_000, 2, 31622}
        };

        for (var c : cases) {
            var result = test.countKthRoots(c[0], c[1], c[2]) == c[3];
            System.out.println(result);
        }
    }
}
