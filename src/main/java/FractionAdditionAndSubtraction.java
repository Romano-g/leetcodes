public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        int i = 0;
        long resultNumerator = 0;
        long resultDenominator = 1;
        var result = "0/1";

        while (i < expression.length()) {
            String signal = "";
            String numerator = "";
            String denominator = "";

            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                signal = String.valueOf(expression.charAt(i));
                i++;
            }

            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                numerator = numerator.concat(String.valueOf(expression.charAt(i)));
                i++;
            }

            if (i < expression.length() && expression.charAt(i) == '/') {
                i++;

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    denominator = denominator.concat(String.valueOf(expression.charAt(i)));
                    i++;
                }
            }

            long intNumerator = Long.parseLong(signal + numerator);
            long intDenominator = Long.parseLong(denominator);

            long newNumerator = resultNumerator * intDenominator
                    + intNumerator * resultDenominator;

            long newDenominator = resultDenominator * intDenominator;

            resultNumerator = newNumerator;
            resultDenominator = newDenominator;
        }

        long a = Math.abs(resultNumerator);
        long b = resultDenominator;

        while (b != 0) {
            long residuum = a % b;
            a = b;
            b = residuum;
        }

        if (!(resultNumerator == 0)) {
        resultNumerator /= a;
        resultDenominator /= a;

        result = resultNumerator + "/" + resultDenominator;
        }

        return result;
    }
}

class TestFractionAdditionAndSubtraction {
    static void main(String[] args) {
        FractionAdditionAndSubtraction test = new FractionAdditionAndSubtraction();

        String[] cases = {
                "-1/2+1/2", "-1/2+1/2+1/3", "1/3-1/2"
        };

        for (var c : cases) {
            var result = test.fractionAddition(c);
            System.out.println(result);
        }
    }
}
