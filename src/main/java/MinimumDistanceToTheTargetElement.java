public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                var partialResult = Math.abs(i - start);

                result = result == -1 ? partialResult : Math.min(partialResult, result);
            }
        }

        return result;
    }
}

class TestMinimumDistanceToTheTargetElement {
    static void main(String[] args) {
        MinimumDistanceToTheTargetElement test = new MinimumDistanceToTheTargetElement();

        int[][][] cases = {
                {{1, 2, 3, 4, 5}, {5, 3}},
                {{1}, {1, 0}},
                {{1,1,1,1,1,1,1,1,1,1}, {1, 0}}
        };

        for (var c : cases) {
            var result = test.getMinDistance(c[0], c[1][0], c[1][1]);
            System.out.println(result);
        }
    }
}