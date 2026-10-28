package Hard;

public class TriplesWithBitwiseAndEqualToZero {
    public int countTriplets(int[] nums) {
        int[] compatible = new int[1 << 16];
        int result = 0;

        for (int i = 0;  i < compatible.length; i++) {
            for (int num : nums) {
                if ((i & num) == 0) {
                    compatible[i]++;
                }
            }
        }

        for (int first : nums) {
            for (int second : nums) {
                var index = first & second;

                result += compatible[index];
            }
        }

        return result;
    }
}


class TestTriplesWithBitwiseAndEqualToZero {
    static void main(String[] args) {
        TriplesWithBitwiseAndEqualToZero test = new TriplesWithBitwiseAndEqualToZero();

        int[][] cases = {
                {2, 1, 3}, {0, 0, 0}
        };

        for (var c : cases) {
            var result = test.countTriplets(c);
            System.out.println(result);
        }
    }
}