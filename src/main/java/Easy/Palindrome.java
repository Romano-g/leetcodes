package Easy;

public class Palindrome {
    public String firstPalindrome(String[] words) {
        for (var word : words) {
            var isPalindrome = true;
            var start = 0;
            var end = word.length() - 1;

            while (start < end) {
                var nextChar = word.charAt(start);
                var previousChar = word.charAt(end);

                if (nextChar != previousChar) {
                    isPalindrome = false;
                    break;
                }

                start++;
                end--;
            }

            if (isPalindrome) {
                return word;
            }
        }

        return "";
    }
}

class TestPalindrome {
    public static void main(String[] args) {
        Palindrome test = new Palindrome();

        String[][] cases = {
                {"abc","car","ada","racecar","cool"},
                {"notapalindrome","racecar"},
                {"def","ghi"}
        };

        for (String[] aCase : cases) {
            String result = test.firstPalindrome(aCase);
            System.out.println(result);
        }
    }
}
