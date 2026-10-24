public class Largest3SameDigitInString {
    public String largestGoodInteger(String num) {
        var highest = "";

        for (int i = 0; i < num.length() - 2; i++) {
            var nextChar = num.charAt(i);
            var secondNextChar = num.charAt(i + 1);
            var thirdNextChar = num.charAt(i + 2);

            if (nextChar == secondNextChar && secondNextChar == thirdNextChar) {
                if (highest.isEmpty() || nextChar > highest.charAt(0)) {
                    highest = "" + nextChar + nextChar  + nextChar;
                }
            }
        }

        return String.valueOf(highest);
    }
}

class TestLargestDigit {
    static void main(String[] args) {
        Largest3SameDigitInString test = new Largest3SameDigitInString();

        String[] cases = {
                "6777133339", "2300019", "42352338"
        };

        for (var num : cases) {
            var result = test.largestGoodInteger(num);
            System.out.println(result);
        }
    }
}