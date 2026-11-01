package Medium;

public class CountSubstringsWithKFrequencyCharacters {
    public int numberOfSubstrings(String s, int k) {
        var result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int[] freq = new int[26];

            for (int j = i; j < chars.length; j++) {
                freq[chars[j] - 'a']++;

                if (freq[chars[j] - 'a'] >= k) {
                    result += chars.length - j;
                    break;
                }
            }
        }

        return result;
    }
}

class TestCountSubstringsWithKFrequencyCharacters {
    static void main(String[] args) {
        CountSubstringsWithKFrequencyCharacters test = new CountSubstringsWithKFrequencyCharacters();

        String[][] cases = {
                {"abacb", "2" }, {"abcde", "1"}
        };

        for (var c : cases) {
            var result = test.numberOfSubstrings(c[0], Integer.parseInt(c[1]));
            System.out.println(result);
        }
    }
}