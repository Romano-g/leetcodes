package Medium;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        var x = 0;
        var constants = 0;
        var sign = 1;
        var sideSign = 1;
        var i = 0;

        while (i < equation.length()) {
            var hasNumber = false;

            if (equation.charAt(i) == '=') {
                sideSign = -1;
                sign = 1;
                i++;
                continue;
            }

            if (equation.charAt(i) == '-') {
                sign = -1;
                i++;
                continue;
            }

            if (equation.charAt(i) == '+') {
                sign = 1;
                i++;
                continue;
            }

            var number = 0;

            while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                number = number * 10 + equation.charAt(i) - '0';
                hasNumber = true;
                i++;
            }

            var effectiveSign = sign * sideSign;

            if (i < equation.length() && equation.charAt(i) == 'x') {
                x += hasNumber ? effectiveSign * number : effectiveSign;
                i++;
            } else {
                constants += number * effectiveSign;
            }
        }

        if (x == 0) {
            if (constants == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        }

        return "x=" + (-constants / x);
    }
}

class TestSolveTheEquation {
    static void main(String[] args) {
        SolveTheEquation test = new SolveTheEquation();

        String[] cases = {
                "x+5-3+x=6+x-2", "x=x", "2x=x", "2x+3x-6x=x+2", "0x=0"
        };

        for (var c : cases) {
            var result = test.solveEquation(c);
            System.out.println(result);
        }
    }
}