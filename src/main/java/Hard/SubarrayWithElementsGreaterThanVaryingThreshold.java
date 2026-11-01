package Hard;

import java.util.Stack;

public class SubarrayWithElementsGreaterThanVaryingThreshold {
    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                var j = stack.pop();
                var left = stack.isEmpty() ? -1 : stack.peek();
                var k = i - left - 1;

                if ((long) nums[j] * k > threshold) {
                    return k;
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int k = nums.length - left - 1;

            if ((long) nums[j] * k > threshold) {
                return k;
            }
        }

        return -1;
    }
}

class TestSubarrayWithElementsGreaterThanVaryingThreshold {
    static void main(String[] args) {
        SubarrayWithElementsGreaterThanVaryingThreshold test = new SubarrayWithElementsGreaterThanVaryingThreshold();

        int[][][] cases = {
                {{1,3,4,3,1}, new int[]{6}},
                {{6,5,6,5,8}, new int[]{7}},
        };

        for (var c : cases) {
            var result = test.validSubarraySize(c[0], c[1][0]);
            System.out.println(result);
        }
    }
}