import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValuesWithEquallySpacedOccurrences {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            indexes.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> appearances : indexes.values()) {
            if (appearances.size() != 3) {
                continue;
            }

            if (appearances.get(1) - appearances.get(0) == appearances.get(2) - appearances.get(1)) {
                result++;
            }
        }

        return result;
    }
}


class TestValuesWithEquallySpacedOccurrences {
    static void main(String[] args) {
        ValuesWithEquallySpacedOccurrences test = new ValuesWithEquallySpacedOccurrences();

        int[][] nums = {
                {1,8,1,5,1,5,8,5}, {8,8,8,8}, {8,6,6,8,8}
        };

        for (var num : nums) {
            var result = test.countSpecialIntegers(num);
            System.out.println(result);
        }
    }
}