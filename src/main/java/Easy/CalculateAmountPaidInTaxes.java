package Easy;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double result = brackets[0][0] <= income ?
                brackets[0][0] * ((double) brackets[0][1] / 100) :
                income * ((double) brackets[0][1] / 100);

        if (income <= brackets[0][0]) { return result;}

        for (int i = 1; i < brackets.length; i++) {
            double lastUpper = brackets[i-1][0];
            double actualUpper = brackets[i][0];
            double actualTaxes = (double) brackets[i][1] / 100;

            if (actualUpper >= income) {
                result += (income - lastUpper) * actualTaxes;
                break;
            }

            result += (actualUpper - lastUpper) * actualTaxes;
        }

        return result;
    }
}

class TestCalculateAmountPaidInTaxes {
    static void main(String[] args) {
        CalculateAmountPaidInTaxes test = new CalculateAmountPaidInTaxes();

        Object[][] cases = {
                {new int[][]{{3, 50},{7, 10},{12, 25}}, 10},
                {new int[][] {{1,0}, {4,25}, {5,50}}, 2},
                {new int[][]{{2,50}}, 0},
                {new int[][]{{4,8}, {5,49}}, 2}
        };

        for (var c : cases) {
            var result = test.calculateTax((int[][]) c[0], (int) c[1]);
            System.out.println(result);
        }
    }
}
