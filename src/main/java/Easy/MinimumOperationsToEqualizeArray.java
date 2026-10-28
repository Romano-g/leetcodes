package Easy;

import java.util.Arrays;

public class MinimumOperationsToEqualizeArray {
    public int minOperations(int[] nums) {
        return Arrays.stream(nums).allMatch(n -> n == nums[0]) ? 0 : 1;
    }
}

class TestMinimumOperationsToEqualizeArray {
    static void main(String[] args) {
        MinimumOperationsToEqualizeArray test = new MinimumOperationsToEqualizeArray();

        int[][] cases = {
                {1,2}, {5,5,5}
        };

        for (var c : cases) {
            var result = test.minOperations(c);
            System.out.println(result);
        }
    }
}
