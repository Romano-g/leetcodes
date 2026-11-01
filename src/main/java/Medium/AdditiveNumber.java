package Medium;

import java.math.BigInteger;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }

                BigInteger first = new BigInteger(num.substring(0, i));
                BigInteger second = new BigInteger(num.substring(i, i + j));

                int index = i + j;

                while (index < n) {
                    BigInteger sum = first.add(second);
                    String expected = sum.toString();

                    if (!num.startsWith(expected, index)) {
                        break;
                    }

                    index += expected.length();

                    first = second;
                    second = sum;
                }

                if (index == n) {
                    return true;
                }
            }
        }

        return false;
    }
}

class TestAdditiveNumber{
    static void main(String[] args) {
        AdditiveNumber test = new AdditiveNumber();

        String[] cases = {
                "112358", "199100199"
        };

        for (var c : cases) {
            var result = test.isAdditiveNumber(c);
            System.out.println(result);
        }
    }
}