package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountAlmostEqualPairs2 {
    public int countPairs(int[] nums) {
        int result = 0;
        int maxLength = 0;

        for (int num : nums) {
            maxLength = Math.max(maxLength, String.valueOf(num).length());
        }

        Map<String, Integer> seen = new HashMap<>();

        for (int num : nums) {
            String current = String.format(
                    "%" + maxLength + "s",
                    String.valueOf(num)
            ).replace(' ', '0');

            Set<String> variants = new HashSet<>();
            variants.add(current);

            char[] original = current.toCharArray();
            int length = original.length;

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    swap(original, i, j);
                    variants.add(new String(original));

                    for (int k = 0; k < length; k++) {
                        for (int l = k + 1; l < length; l++) {
                            swap(original, k, l);
                            variants.add(new String(original));
                            swap(original, k, l);
                        }
                    }

                    swap(original, i, j);
                }
            }

            for (String variant : variants) {
                result += seen.getOrDefault(variant, 0);
            }

            seen.merge(current, 1, Integer::sum);
        }

        return result;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}