package Medium;

import java.util.Arrays;

public class MinimumNumberOfValidStringsToFormTarget {
    public int minValidStrings(String[] words, String target) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char c : word.toCharArray()) {
                int i = c - 'a';

                if (current.children[i] == null) {
                    current.children[i] = new TrieNode();
                }

                current = current.children[i];
            }
        }

        int n =  target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            var maxLen = findLongestPrefix(root, target, i);
            for (int j = 1; j <= maxLen; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private int findLongestPrefix(TrieNode root, String target, int start) {
        var current = root;
        var length = 0;

        for (int i = start; i < target.length(); i++) {
            var index = target.charAt(i) - 'a';

            if (current.children[index] == null) {
                break;
            }

            current = current.children[index];
            length++;
        }

        return length;
    }
}

class TrieNode  {
    TrieNode[] children = new TrieNode[26];
}

class TestMinimumNumberOfValidStringsToFormTarget {
    static void main(String[] args) {
        MinimumNumberOfValidStringsToFormTarget test = new MinimumNumberOfValidStringsToFormTarget();

        String[][][] cases = {
                {{"abc","aaaaa","bcdef"}, new String[]{"aabcdabc"}},
                {{"abababab","ab"}, new String[]{"ababaababa"}},
                {{"abcdef"}, new String[]{"xyz"}}
        };

        for (var c : cases) {
            var result = test.minValidStrings(c[0], c[1][0]);
            System.out.println(result);
        }
    }
}