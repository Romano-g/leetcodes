package Medium;

public class SumOfBeautyInTheArray {
    public int sumOfBeauties(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        var result = 0;

        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        rightMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < rightMin[i + 1] && nums[i] > leftMax[i - 1]) {
                result += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                result += 1;
            }
        }

        return result;
    }
}

class TestSumOfBeautyInTheArray {
    static void main(String[] args) {
        SumOfBeautyInTheArray test = new SumOfBeautyInTheArray();

        int[][] cases = {
                {1,2,3}, {2,4,6,4}, {3,2,1}
        };

        for (var c : cases) {
            var result = test.sumOfBeauties(c);
            System.out.println(result);
        }
    }
}