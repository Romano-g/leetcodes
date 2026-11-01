package Medium;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int evens = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                evens += num;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            var index = queries[i][1];
            var value = queries[i][0];
            var originalNum = nums[index];

            var num = originalNum + value;
            nums[index] = num;

            if (originalNum % 2 == 0) {
                evens -= originalNum;
            }

            if (num % 2 == 0) {
                evens += num;
            }

            answer[i] = evens;
        }

        return answer;
    }
}

class TestSumOfEvenNumbersAfterQueries {
    static void main(String[] args) {
        SumOfEvenNumbersAfterQueries test = new SumOfEvenNumbersAfterQueries();

        int[][][][] cases = {
                {new int[][]{new int[]{1, 2, 3, 4}}, {{1,0}, {-3,1}, {-4,0}, {2,3}}},
                {new int[][]{new int[]{1}}, {{4,0}}}
        };

        for (var c : cases) {
            var result = test.sumEvenAfterQueries(c[0][0], c[1]);
            System.out.println(Arrays.toString(result));
        }
    }
}